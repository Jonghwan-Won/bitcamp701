package ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext3.xml");
		
		System.out.println("첫번째 고객정보");
		Person per1=(Person)context.getBean("person");
		per1.showPerson();
		
		System.out.println();
		System.out.println("두번째 고객정보");
		Person per2=(Person)context.getBean("person2");
		per2.showPerson();
	}

}
