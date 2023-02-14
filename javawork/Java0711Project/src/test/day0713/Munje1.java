package test.day0713;

import java.util.Scanner;

public class Munje1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
//		 문제 1. for
//		 숫자 n을 입력하면 1부터 n까지의 합계를 구하라
//		 예) 숫자 입력 : 100
//		 1부터 100까지는 5050입니다.
		
		System.out.println("숫자를 입력하세요");
		int n=sc.nextInt();
		int sum=0;

		for(int i=1;i<=n;i++) {
			sum+=i;
		}
			System.out.println(sum);
		
		
	}

}
