package ex3;

public class Person {
	String name;
	String address;
	
	//MyShop 타입으로 변수 선언
	MyShop myShop;

	//생성자 주입
	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	//MyShop은 setter 주입
	public void setMyShop(MyShop myShop) {
		this.myShop = myShop;
	}

	public void showPerson()
	{
		System.out.println("고객명:"+name);
		System.out.println("고객주소:"+address);
		System.out.println("고객이 구입한 상품정보");
		myShop.showShop();
		
	}
	
	
}
