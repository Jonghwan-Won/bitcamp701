package test.day3;

import java.util.Scanner;

public class Ex1Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자 입력");
		int num=sc.nextInt(); //키보드로부터 숫자 읽기
		//switch에서 사용가능한 타입은 byte,short,int,char,String
		switch (num) {
		case 1:
			System.out.println("1111");
			break;
		case 2:
			System.out.println("2222");
			break;
		case 3:
			System.out.println("3333");
			break;

		default:
			System.out.println("1,2,3 이외의 숫자");
			break; //어차피 마지막이라 써도 안써도 의미없음
		}
	}

}
