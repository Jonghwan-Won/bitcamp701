package test.day0718;

// 같은 패키지 안에서 호출하는 연습 (생성자 활용)

// 생성자(constructor)
// 1. 반드시 클래스명과 동일한 이름이어야 한다
// 2. overloading 이 가능하다 (즉, 여러개 가능)
// 3. 주로 멤버변수의 초기화를 담당한다
// 4. new로 생성 시 자동으로 호출된다
// 5. 리턴타입이 없다


class Person
{
	// 멤버 변수 선언
	String name;
	int age;
	
	
	
	Person()
	{
		System.out.println("디폴트 생성자 호출");
		name="홍길동";		// this. 이 생략됨
		age=10;
	}
	
	
	
	Person(String name)
	{
		this.name=name;
		age=5;
	}
	
	
	
	Person(String name, int age)
	{
		this.name=name;
		this.age=age;
				
	}
	
	
	
	
	public void show ()
	{
		System.out.println("name: "+name+", age="+age);
			
	}
	
	
	
}

public class Ex3Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//constructor : 생성자
		
		Person p1=new Person();		// 생성자 호출
		p1.show();
		
		
		Person p2=new Person("강호동");
		p2.show();
		
		Person p3=new Person("이영자",35);
		p3.show();
		
		// 위는 같은 패키지 안에서 진행된 부분
		// test.day0715 패키지에 Studet.java 생성
	}

}
