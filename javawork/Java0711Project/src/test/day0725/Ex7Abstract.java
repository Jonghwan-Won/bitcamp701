package test.day0725;

//abstract(추상) 메서드를 한개이상 포함하고 있는 경우
//class 앞에도 반드시 abstract를 붙여줘야한다
//그리고 abstract클래스는 new로 생성할 수 없다
abstract class Parent2
{
	//abstract 클래스는 일반 메서드도 만들 수 있다
	public void show()
	{
		System.out.println("부모클래스의 show");
	}
	
	//abstract라는 의미는 미완성이라는 뜻
	abstract public void process();	//미완성의 메서드-오버라이드를 하기위한 메서드
}

//상속받는 클래스 #1
class Play extends Parent2
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("마당에서 뛰어논다");
	}
}

//상속받는 클래스 #2
class Draw extends Parent2
{
	//자식 클래스에도 일반 메서드를 만들어보자
	public void study()
	{
		System.out.println("나홀로 공부");
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("그림을 그린다");
	}
	
}



public class Ex7Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//부모 크래스로 선언
		Parent2 p=null;
		p=new Play();	//abstract 클래스는 자식클래스로만 생성가능
		p.process();
		
		p=new Draw();
		p.show();	//부모가 가진 일반 메서드 호출 가능
//		p.study();	//자식클래스만이 가진 메서드는 부모로 선언 시 호출안됨
		p.process();
		
	}

}
