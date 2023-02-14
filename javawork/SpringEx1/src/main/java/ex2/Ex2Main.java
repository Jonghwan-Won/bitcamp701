package ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//인터페이스 없이 클래스니까
		//같은 객체를 두번 생성 시 singleton 일 경우에는 주소가 같고
		//prototype 일 경우 계속 새로운곳에 생성되므로 주소가 다르다
		MyInfo myInfo=context.getBean("myinfo", MyInfo.class);
		MyInfo myInfo2=context.getBean("myinfo", MyInfo.class);
		
		//Myinfo.java 에서 toString , return : 반환이므로
		System.out.println(myInfo);	//toString이 호출
		System.out.println(myInfo.toString());
		
		System.out.println();
		System.out.println("두 객체의 주소 출력해보기");
		System.out.println(myInfo.hashCode()+" : "+myInfo2.hashCode());
		//appContext2 에서 singleton 에서는 두개 주소가 같고
		//prototype으로 변경해보면 둘의 주소가 다르다
		
		
		Student s1=(Student)context.getBean("stu");
		System.out.println();
		s1.show();
		
		
	}

}
