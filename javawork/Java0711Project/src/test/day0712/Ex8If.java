package test.day0712;

import java.util.Scanner;

public class Ex8If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		// 점수를 입력 후 90 이상이면 "잘했어요!"
		// 80 이상이면 "조금 더 노력하세요!"
		// 나머지는 "공부하세요!!!"
		// 0~100 을 벗어나면 "잘못입력했어요" 라고 출력 후 종료 // return : 메서드 종료
		
		// 변수선언 → 키보드 입력 → 계산 → 출력	
		
		int score;
		String result;
		
		System.out.println("점수를 입력하세요");
		score=sc.nextInt();
		
//		if(score<0 || score>100)
		if(!(score>=0 && score<=100)) //위의 조건과 같음
		{
			System.out.println("\t잘못입력했어요");
			return; //메서드 종료
		}
		
		if(score>=90)
			result="잘했어요!";
		else if(score>=80)
			result="조금 더 노력하세요!";
		else
			result="공부하세요!!!";
		// else if 없이 모든 조건을 if로 걸면
		// 95점일때 90이상 적합 + 80이상 적합하게됨
		
		System.out.println(score+" : "+result);
		System.out.println("** 정상 종료 ** ");
		
		
	}

}
