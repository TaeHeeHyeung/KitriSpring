package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloServiceFactory {
	
	@Bean(name = {"hs","helloservice"})
	@Scope (value= "prototype") //프로토타입적용 (디폴트 싱글톤)
	public HelloService getHelloService() {
		return new HelloServiceKor() ;
	}

}
