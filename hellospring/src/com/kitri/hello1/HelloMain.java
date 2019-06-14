package com.kitri.hello1;

public class HelloMain {
	public static void main(String[] args) {
		HelloServiceKor helloServiceKor =  new HelloServiceKor();
		String msgKor = helloServiceKor.helloKor("형태희");
		
		HelloServiceEng helloServiceEng =  new HelloServiceEng();
		String msgEng = helloServiceEng.helloEng("형태희");
		
		System.out.println(msgKor);
		System.out.println(msgEng);
	}
}	
