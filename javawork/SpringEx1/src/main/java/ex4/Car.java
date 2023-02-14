package ex4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Car {
	
	/*
	//xml 방식일때 
	//인터페이스 선언
	Tire tire;
	
	//꼭 주입해줘야됨 안하면 null point Exception
	
	Car(Tire tire)
	{
		this.tire=tire;
	}
	*/
	
	//@Autowired : 같은 타입을 찾아서 자동주입시킨다. 생성자나 setter메서드가 필요없다
	//인터페이스를 상속받은 클래스가 한개일경우는 에러가 없으나 2개이상일경우
	//정확한 클래스명으로 선언해야 에러가 없다
	//@Autowired
	//Tire tire;
	
	//따로 지정해주면 문제없는데 Tire tire; 라고 하면 오류발생
	//KoreaTire tire; 
	//CanadaTire tire;
	
	//2개 이상 매칭될경우 정확한 이름으로 가져온다
	//이름을 따로 지정안했을땐 클래스명이 이름이되고 첫글자를 소문자로 변경
	//@Resource(name = "canadaTire")
	@Resource(name = "koreaTire")
	Tire tire; //상속받은 클래스가 2개
	
	
	
	//확인
	public void myCarInfo()
	{
		System.out.println("내 차의 타이어는 "+tire.getTireName()+"입니다");
		
	}
}
