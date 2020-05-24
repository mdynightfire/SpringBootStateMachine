package com.mdynightfire.statusmachine.registry;

import com.mdynightfire.statusmachine.model.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanRegistry
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/14 8:40 下午
 */
@Component
public class BeanRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition = getGenericBeanDefinition();
        registry.registerBeanDefinition("dynamicUser", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    private GenericBeanDefinition getGenericBeanDefinition() {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.getPropertyValues().add("name", "张三");
        beanDefinition.getPropertyValues().add("age", 25);
        //按照Type引入
        beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);
        //单例
        beanDefinition.setScope(ConfigurableBeanFactory.SCOPE_SINGLETON);
        return beanDefinition;
    }
}
