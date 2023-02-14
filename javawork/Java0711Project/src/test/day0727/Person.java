package test.day0727;

public class Person {
	private String name;
	private String age;	// 계산 목적이 아니여서 그냥 String으로 선언함
	private String addr;
	
	// 디폴트 생성자
	public Person() {
		super();
	}
	
	//파라미터 3개 다 받는 생성자
	public Person(String name, String age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	//setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

	
	
	
	
}
