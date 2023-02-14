package test.day0713;

public class Ex13Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 임의의 수를 구하는 방법 2가지
		// Math.random() 을 이용하는 방법
		// Random 클래스를 이용
		
		for(int i=1;i<=5;i++)
		{
			double d=Math.random();		//0.000~0.999 사이의 double 형 발생
			System.out.println(d);
		}
		System.out.println("-------------------");
		
		System.out.println("0~9사이의 난수");
		for(int i=1;i<=5;i++)
		{
			int d=(int)(Math.random()*10);		//0.000~0.999 사이의 double 형 발생
			System.out.println(d);
		}
		System.out.println("-------------------");
		
		
		System.out.println("0~99사이의 난수");
		for(int i=1;i<=5;i++)
		{
			int d=(int)(Math.random()*100);		//0.000~0.999 사이의 double 형 발생
			System.out.println(d);
		}
		System.out.println("-------------------");
		
		
		System.out.println("1~100사이의 난수");
		for(int i=1;i<=5;i++)
		{
			int d=(int)(Math.random()*100)+1;		//0.000~0.999 사이의 double 형 발생
			System.out.println(d);
		}
		System.out.println("-------------------");
		
		System.out.println("임의의 알파벳 대문자(65~90)");
		for(int i=1;i<=5;i++)
		{
			int d=(int)(Math.random()*26+65);		//0.000~0.999 사이의 double 형 발생
			System.out.println((char)d);
		}
		System.out.println("-------------------");
		
		
	}

}
