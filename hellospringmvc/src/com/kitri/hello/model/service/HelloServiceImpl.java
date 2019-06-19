package com.kitri.hello.model.service;

import com.kitri.hello.model.dao.HelloDao;

public class HelloServiceImpl implements HelloService {
	private HelloDao helloDao;
	


	public HelloServiceImpl() {
		
		
	}
	
	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}
	
//	public void setHelloDao(HelloDao helloDao) {
//		this.helloDao = helloDao;
//	}

//	public HelloServiceKor() {
//		System.out.println("HelloServicekor 생성자 호출!!!!!!");
//	}
	
	public String hello(String name) {
		return name+"님 안녕하세요."+ helloDao.getGreeting();
	}
}
