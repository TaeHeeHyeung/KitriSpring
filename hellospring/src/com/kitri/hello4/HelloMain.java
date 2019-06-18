package com.kitri.hello4;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class);
		HelloService helloService2 = (HelloService) context.getBean("hs", HelloService.class);
		HelloService helloService1 = (HelloService) context.getBean("helloservice", HelloService.class);
		System.out.println(helloService1 +" "+ helloService2);
		
		String msg = helloService1.hello("형태희");
		System.out.println(msg);
			
	}
}
