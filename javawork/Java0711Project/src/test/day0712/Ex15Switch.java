package test.day0712;

import java.util.Scanner;

public class Ex15Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int score;
		char grade;
		System.out.println("점수 입력");
		score=sc.nextInt();
		if(score<0 || score>100)
		{
			System.out.println("잘못입력했습니다.");
			return;
		}
		
		// case형식에는 어울리지 않는 예제
		// case 1: 이런 형식만 가능하므로, 10점으로 나누는 방식 선택
		// Ex11Operator 와 같음
		
		
		switch (score/10)
		{
		case 10:
		case 9:
			grade='A'; break;
		case 8:
			grade='B'; break;
		case 7:
			grade='C'; break;
		case 6:
			grade='D'; break;
		default:
			grade='F';
			
		}
		System.out.println(score+"점은 "+grade+"학점입니다.");
		
	}

}
