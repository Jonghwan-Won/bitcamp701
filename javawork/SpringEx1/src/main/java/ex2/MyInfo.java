package ex2;

public class MyInfo {
	private String name;
	private int age;
	private String addr;
	
	//생성자
	public MyInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Myinfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
}
