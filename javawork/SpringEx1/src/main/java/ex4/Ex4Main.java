package ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Ex4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext4.xml");
		
		Car car=(Car)context.getBean("car");
		car.myCarInfo();
	
	
	}

}
