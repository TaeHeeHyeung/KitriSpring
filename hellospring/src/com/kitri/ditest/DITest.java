package com.kitri.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/ditest/applicationContext.xml");
		MemberDto m1 = context.getBean("m1",MemberDto.class);
		System.out.println("----------------------------------m1----------------------------------");
		System.out.println(m1.toString());

		MemberDto m2 = context.getBean("m2",MemberDto.class);
		System.out.println("----------------------------------m2----------------------------------");
		System.out.println(m2.toString());
		
		MemberDto m3 = context.getBean("m3",MemberDto.class);
		System.out.println("----------------------------------m3----------------------------------");
		System.out.println(m3.toString());
		
		MemberDto m4 = context.getBean("m4",MemberDto.class);
		System.out.println("----------------------------------m4----------------------------------");
		System.out.println(m4.toString());
		
		MemberDto m5 = context.getBean("m5",MemberDto.class);
		System.out.println("----------------------------------m5----------------------------------");
		System.out.println(m5.toString());
		
		MemberDto m6 = context.getBean("m6",MemberDto.class);
		System.out.println("----------------------------------m6----------------------------------");
		System.out.println(m6.toString());
		
		
		MemberDto m7 = context.getBean("m7",MemberDto.class);
		System.out.println("----------------------------------m7----------------------------------");
		System.out.println(m7.toString());
	}

}
