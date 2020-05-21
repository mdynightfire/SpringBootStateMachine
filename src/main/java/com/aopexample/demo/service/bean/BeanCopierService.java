package com.aopexample.demo.service.bean;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;

import com.aopexample.demo.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @ClassName BeanCoperService
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/17 5:10 下午
 */
@Service
public class BeanCopierService {

    private User userFrom;
    private int times = 1000000;

    @PostConstruct
    public void init() {
        userFrom = new User();
        userFrom.setAge(11);
        userFrom.setName("张三");
    }

    public void testBeanCopier() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //测试Apache的bean拷贝
        //testApacheBeanCopier();
        //测试Apache的PropertyUtils.copyProperties
        //testApachePropertyCopier();
        //测试Spring的BeanUtils.copyProperties
        testSpringBeanUtilsCopier();
        //测试Spring的beanCopier
        testSpringBeanCopierCopier();
        //测试CGLIb
        testcglibCopier();
    }

    /**
     * 测试CGLIb
     */
    private void testcglibCopier() {
        User userTo = new User();
        net.sf.cglib.beans.BeanCopier beanCopier = net.sf.cglib.beans.BeanCopier.create(User.class,User.class,false);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            beanCopier.copy(userFrom,userTo,null);
        }
        long end = System.currentTimeMillis();
        System.out.println("testcglibCopier:" + (end - startTime));
    }

    /**
     * 测试Spring的beanCopier
     */
    private void testSpringBeanCopierCopier() {
        User userTo = new User();
        BeanCopier beanCopier = BeanCopier.create(User.class, User.class, false);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            beanCopier.copy(userFrom, userTo, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("testSpringBeanCopierCopier:" + (end - startTime));
    }

    /**
     * 测试Spring的BeanUtils.copyProperties
     */
    private void testSpringBeanUtilsCopier() {
        User userTo = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            org.springframework.beans.BeanUtils.copyProperties(userFrom, userTo);
        }
        long end = System.currentTimeMillis();
        System.out.println("testSpringBeanUtilsCopier:" + (end - startTime));
    }

    /**
     * 测试Apache的PropertyUtils.copyProperties
     *
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private void testApachePropertyCopier()
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User userTo = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            PropertyUtils.copyProperties(userTo, userFrom);
        }
        long end = System.currentTimeMillis();
        System.out.println("testApachePropertyCopier:" + (end - startTime));
    }

    /**
     * 测试Apache的bean拷贝
     */
    private void testApacheBeanCopier() throws InvocationTargetException, IllegalAccessException {
        User userTo = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            BeanUtils.copyProperties(userTo, userFrom);
        }
        long end = System.currentTimeMillis();
        System.out.println("testApacheBeanCopier:" + (end - startTime));
    }
}
