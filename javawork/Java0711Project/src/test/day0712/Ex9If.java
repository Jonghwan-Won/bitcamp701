package test.day0712;

import java.util.Scanner;

public class Ex9If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
//		int num;
//		// 숫자 num을 입력받은 후 짝수인지 홀수인지 출력
//		// 예 : 5는 홀수입니다.
//	
//		System.out.println("숫자를 입력하세요");
//		num=sc.nextInt();
//		
//		if(num%2==0)
//			System.out.println(num+"는 짝수입니다.");
//		else
//			System.out.println(num+"는 홀수입니다.");
//		
		
		int year;
		// 년도를 입력 후 해당년도가 윤년인지 평년인지 출력하시오
		// 윤년 공식 : 년도%4==0이고, 년도%100!=0 거나 년도%400==0
		// 예 : 2020 년은 윤년입니다.
		

					
		System.out.println("년도를 입력하세요");
		year=sc.nextInt();
		
		if(year%4==0 && year%100!=0 || year%400==0)
			System.out.println(year+" 년은 윤년입니다.");
		else
			System.out.println(year+" 년은 평년입니다.\n");
		
	}

}
