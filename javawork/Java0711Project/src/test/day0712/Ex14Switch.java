package test.day0712;

import java.util.Scanner;

public class Ex14Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int num;
		System.out.println("num 숫자 입력");
		num=sc.nextInt();
		switch(num)
		{
		case 1:
			System.out.println("one!!");
			break; // 해당 case 실행 후 빠져나간다
		case 2:
			System.out.println("two!!");
			break;
		case 3:
			System.out.println("three!!");
			break;
		default:
			System.out.println("1, 2, 3 이외의 숫자!!");
		}
		
		switch(num%2)
		{
		case 0:
			System.out.println("짝수입니다.");
			break;
		default:
			System.out.println("홀수입니다.");
		}
		
		

	}

}
