package com.aopexample.demo;

import com.aopexample.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		//User dynamicUser = ctx.getBean("dynamicUser", User.class);
		User dynamicUser = ctx.getBean(User.class);
		System.out.println(dynamicUser);
		//Map<String, Object> beans = applicationContext.getBeansWithAnnotation(DoneTime.class);
		//System.out.println(beans);
		//for (Map.Entry<String, Object> entry : beans.entrySet()) {
		//	IndexController indexController = (IndexController)entry.getValue();
		//	System.out.println(indexController.index2());
		//}
		//Map<String, IService> serviceMap = applicationContext.getBeansOfType(IService.class);
		//for (Map.Entry<String, IService> entry : serviceMap.entrySet()) {
		//	Class<? extends IService> clazz = entry.getValue().getClass();
		//	String name = entry.getKey();
		//	IService instance = applicationContext.getBean(name,IService.class);
		//	System.out.println("name="+name+",clazz="+clazz.toString()+",instance="+instance);
		//}

	}

}
