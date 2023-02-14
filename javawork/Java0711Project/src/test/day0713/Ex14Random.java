package test.day0713;

import java.util.Random;

public class Ex14Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r=new Random();
		
		System.out.println("0~9 사이의 난수");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(10); //0~9
			System.out.println(n);
		}
		System.out.println("-----------------------");
		
		
		
		System.out.println("0~99 사이의 난수");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(100);
			System.out.println(n);
		}
		System.out.println("-----------------------");
		
		
		System.out.println("1~100 사이의 난수");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(100)+1;
			System.out.println(n);
		}
		System.out.println("-----------------------");
		
		
		System.out.println("임의의 알파벳 대문자 (65~90)");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(25)+65;
			System.out.println((char)n);
		}
		System.out.println("-----------------------");
		
		
		
	}

}
