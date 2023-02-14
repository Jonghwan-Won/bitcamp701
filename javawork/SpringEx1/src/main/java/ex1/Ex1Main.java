package ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 기본 자바방식으로 객체 생성
		MessageInter m1=new Message1();
		m1.sayHello("이미자");
		
		MessageInter m2=new Message2();
		m2.sayHello("강호동");
		
		//스프링 방식으로 객체 생성
		//아래 코드는 자바메인으로 테스트할때만 필요함, 웹에서는 xml파일이 자동 호출됨
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext1.xml"); //xml을 가져오기위한 변수
		MessageInter m3=(Message1)context.getBean("mes1");
		// <T> : T는 클래스 타입
		// 우측 결과는 전체 반환타입이므로 형변환 해줘야됨 (Message1)
		m3.sayHello("마이클");
		//실제 웹에서는 xml파일에서 <bean> 부분만 보면됨 || 지금은 java형식으로 출력하려고 하는것
		//자바라서 getBean으로 가져오는거임
		
		MessageInter m4=context.getBean("mes2", Message2.class);
		//입력을 두개받는 getBean 은 형변환 안해줘도됨 || 위에서처럼 한개짜리는 형변환 필요
		//2번째 인자에 class 타입을 넣어주면 형변환 안해도됨
		m4.sayHello("캔디");
	}

}
