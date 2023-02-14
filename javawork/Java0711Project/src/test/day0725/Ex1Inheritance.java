package test.day0725;

//super class
class Super1
{
	private void writeA()
	{
		System.out.println("private method");
	}
	
	void writeB()
	{
		System.out.println("default method");	//패키지가 다르면 default 도 안됨
	}
	
	protected void writeC()
	{
		System.out.println("protected method");
	}
	
	public void writeD()
	{
		System.out.println("public method");	
	}
	
}
/////////////////////////////////////////////

class Apple extends Super1
{
	public void writeD()
	{
		System.out.println("public sub method");
	}
	
	public void process()
	{
		System.out.println("부모의 레퍼런스 변수인 super로 호출");
		super.writeB();
		super.writeC();
		super.writeD();	//this에도 writeD가 있으나 super로 호출 시 부모 writeD가 호출됨
		
		System.out.println("같은 이름의 메서드가 나에게 없다면 this로 호출 가능");
		this.writeB();
		this.writeC();
		this.writeD();	//sub class에 같은 이름의 메서드가 있으므로 sub메서드가 우선 호출됨
	}
}


public class Ex1Inheritance {	//Inheritance : 상속

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple apple=new Apple();
		apple.writeB();	//패키지가 다르면 default 도 안됨
		apple.writeC();
		apple.writeD();
		apple.process();
	}

}
