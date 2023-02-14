package test.day0715;

// 같은 패키지안에서 여러개의 클래스 구현 가능
// 단 앞에 public 붙일 수 없음. 즉 다른 패키지에서는 접근 불가
class Apple
{
	// private 접근지정자는 패키지 상관없이 다른 클래스에서 접근 불가
	private String name;
	private int age;
	public static final String IT_LANG="JAVA";		// static final 상수
	
	// 멤버변수의 값을 변경하기위한 setter method
	public void setName(String name)
	{
		this.name=name; //같은 구역안에 같은 변수명이 있을경우 멤버변수는 this. 필수로 붙여야함
	}
	// 멤버변수의 값을 반환하는 getter method
	public String getName()
	{
		return name; 	// this.name : this 생략 가능
	}
	
	
	// age에 대한 setter getter
	public void setAge(int age)
	{
		this.age=age;
		
	}
	
	public int getAge()
	{
		return age;
	}

	// 일반 멤버 메서드
	public void writeInfo()
	{
		System.out.println(name+"님은 "+(age>=20?"성인입니다":"미성년자입니다."));
		
	}
	
	
	
}



public class Ex9Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Apple.IT_LANG);		// 클래스가 다르므로 생략불가 (Apple. 써줘야됨)
												// public으로 되어있는 IT_LANG 는 호출 가능
		// Apple 생성
		Apple a=new Apple();
//		System.out.println(a.name);				// private라서 접근 불가
		
		// Apple 클래스의 이름과 나이 변경
		a.setName("강말자");
		a.setAge(30);
		
		// 변경된 이름과 나이 출력
		// 이름:강말자
		// 나이:30
		
		System.out.println("이름:"+a.getName());
		System.out.println("나이:"+a.getAge());
		
		Apple a2=new Apple();
		a2.setName("이말자");
		a2.setAge(19);
		
		System.out.println(a2.getName()+"님의 나이는 "+a2.getAge()+" 세 입니다.");
		
		a.writeInfo();
		a2.writeInfo();
		

	}

}
	