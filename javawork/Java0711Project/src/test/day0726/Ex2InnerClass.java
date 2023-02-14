package test.day0726;

class Outer1
{
	int a=10;
	static int b=20;
	
	//Member 내부클래스
	class Inner1
	{
		int c=30;
//		static int d=40;	//member 내부 클래스에서는 static 변수 선언 불가
		public void disp()
		{
			//내부클래스에서는 외부클래스의 변수도 사용가능
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
		}
	}
	
	//static 내부 클래스
	static class Inner2
	{
		int n=50;
		static int m=60;
		
		public void disp()
		{
//			System.out.println("a="+a);	//static 내부클래스에서는 외부클래스의 static 변수만 사용 가능
			System.out.println("b="+b);
			System.out.println("n="+n);
			System.out.println("m="+m);
		}
	}
	
	public void process()
	{
		System.out.println("member 내부클래스 생성");
		Inner1 in1=new Inner1();
		in1.disp();
		
		System.out.println("static 내부클래스 생성");
		Inner2 in2=new Inner2();
		in2.disp();
	}
}

public class Ex2InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer1 outer1=new Outer1();
		outer1.process();

	}

}
