package com.kitri.hello3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloMain {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/kitri/hello3/applicationContext.xml"));
		
		HelloService helloService =  (HelloService) factory.getBean("hsKor");
		String msg = helloService.hello("형태희");
		System.out.println(msg);
//		HelloServiceEng helloServiceEng =  new HelloServiceEng();

		System.out.println("프로그램 시작 ");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/applicationContext.xml");
		System.out.println("설정파일을 읽었다.");
		helloService = (HelloService) context.getBean("hsKor", HelloService.class);
		System.out.println("서비스를 얻어왔다.");
		msg = helloService.hello("형태희");
		
		System.out.println(msg);
			
	}
}
