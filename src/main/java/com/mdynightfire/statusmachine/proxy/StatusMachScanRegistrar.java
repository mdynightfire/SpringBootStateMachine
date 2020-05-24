package com.mdynightfire.statusmachine.proxy;

import java.beans.Introspector;
import java.util.List;

import com.mdynightfire.statusmachine.annotation.StatusMachineScan;
import com.mdynightfire.statusmachine.annotation.StatusMachineService;
import com.mdynightfire.statusmachine.utils.ClassPathScaner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * @ClassName StatusMatchScanRegistrar
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/12 5:46 下午
 */
@Slf4j
public class StatusMachScanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(
            StatusMachineScan.class.getName()));
        // 设置path
        List<String> basePackages = Lists.newArrayList();
        for (String pkg : annoAttrs.getStringArray("path")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        //开始扫描
        doScan(registry, StringUtils.toStringArray(basePackages));
    }

    /**
     * 开始扫描
     *
     * @param registry
     * @param basePackages
     */
    private void doScan(BeanDefinitionRegistry registry, String[] basePackages) {
        for (String onePath : basePackages) {
            log.info("doScan onePath={}", onePath);
            List<Class> workflowServiceList = getWorkflowServiceList(onePath);
            for (Class cls : workflowServiceList) {
                handleOneClass(registry, cls);
            }
        }
    }

    /**
     * 找到工作流服务类列表
     *
     * @param scanPath
     * @return
     */
    private List<Class> getWorkflowServiceList(String scanPath) {
        return ClassPathScaner.scan(scanPath, StatusMachineService.class);
    }

    /**
     * 处理每一个工作流服务类
     *
     * @param beanDefinitionRegistry
     * @param cls
     */
    private void handleOneClass(BeanDefinitionRegistry beanDefinitionRegistry, Class cls) {
        // 需要被代理的接口
        log.info("需要被代理的接口,cls={}", cls);
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(cls);
        GenericBeanDefinition definition = (GenericBeanDefinition)builder.getRawBeanDefinition();
        definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
        definition.setBeanClass(MyProxyFactory.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        // 注册bean名,一般为类名首字母小写
        String beanName = Introspector.decapitalize(cls.getSimpleName());
        beanDefinitionRegistry.registerBeanDefinition(beanName, definition);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
