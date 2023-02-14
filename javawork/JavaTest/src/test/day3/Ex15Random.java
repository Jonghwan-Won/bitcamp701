package test.day3;

public class Ex15Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 난수 구하기 -> Random 클래스를 사용하거나 Math 클래스? 를 사용하는 방법이 있음
		for(int i=1;i<=5;i++)
		{
			double a=Math.random(); // 0.0000 ~ 0.9999
			System.out.println(a);
		}
		
		
		System.out.println("0~9 사이 난수 5개");
		for(int i=1;i<=5;i++)
		{
			int n=(int)(Math.random()*10);
			System.out.println(n);
		}
		
		
		System.out.println("1~10 사이 난수 5개");
		for(int i=1;i<=5;i++)
		{
			int n=(int)(Math.random()*10+1);
			System.out.println(n);
		}
		
		
		System.out.println("1~100 사이 난수 5개");
		for(int i=1;i<=5;i++)
		{
			int n=(int)(Math.random()*100+1);
			System.out.println(n);
		}
		
	}

}
