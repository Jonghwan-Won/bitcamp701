package test.day0715;

public class Ex8Object {
	//멤버 변수와 상수를 선언하는 위치
	//멤버 변수의 경우 객체는 null 로, 숫자는 0으로 자동 초기화
	//일반 멤버변수는 인스턴스 변수가 있어야 호출이 가능하므로
	//인스턴스 멤버변수라고도 부른다
	String name;
	int age;
	//static 변수는 클래스명으로 호출이 가능하므로 클래스멤버 변수라고도 부른다
	static final String MESSAGE="Happy Day!";		// <- static 변수
	
	
	
	public static void main(String[] args) {		// <- static 메서드
		// TODO Auto-generated method stub
		
		// static 메서드는 this라는 인스턴스 변수가 존재하지 않음
		// 그러므로 일반 멤버변수는 접근이 불가(new로 생성하면 가능)
		// System.out.println(this.name); // 에러 발생

		System.out.println(Ex8Object.MESSAGE);
		// 같은 클래스 소속일경우는 클래스명 생략 가능
		System.out.println(MESSAGE);
				
		//멤버변수 호출하려면 
		Ex8Object ex=new Ex8Object();
		System.out.println(ex.name);		// this를 사용하지못할때는 ex=new 이런 방식으로 상단의 멤버변수 호출 가능
		System.out.println(ex.age);
		
		ex.name="강호동";
		ex.age=20;
		System.out.println(ex.name);
		System.out.println(ex.age);
		
		
	}

}
