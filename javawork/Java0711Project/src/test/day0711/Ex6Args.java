package test.day0711;

import java.text.DecimalFormat;

public class Ex6Args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 	args : 이영자 2560000 35000
		 * 
		 * 	String name 에 이름 저장
		 *  int pay 에 2560000 저장
		 *  int sudang 에 35000 저장
		 *  int tax 에 pay의 3프로 계산해서 저장
		 *  int totpay = pay-tax+sudang 값 저장
		 *  
		 *  출력 (이번에는 println을 이용해서 출력
		 *  이름
		 *  기본급
		 *  수당
		 *  세금
		 *  총급여
		*/
				
		String name = args[0];
		int pay = Integer.parseInt(args[1]);
		int sudang = Integer.parseInt(args[2]);
//		int tax = pay*3/100;
		int tax = (int)(pay*0.03);
		int totpay = pay-tax+sudang;
		
		System.out.println("이름 : "+name);
		System.out.println("기본급 : "+pay+" 원");
		System.out.println("수당 : "+sudang+" 원");
		System.out.println("세금 : "+tax+" 원");
		System.out.println("총급여 : "+totpay+" 원");
		
		
	}

}
