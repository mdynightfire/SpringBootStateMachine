package com.mdynightfire.statusmachine.proxy;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName MyProxyFactory
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/9 6:01 下午
 */
public class MyProxyFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceClass;
    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }
    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
    @Override
    public T getObject() throws Exception {
        return (T) new MyProxy().bind(interfaceClass);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        // 单例模式
        return true;
    }

}
