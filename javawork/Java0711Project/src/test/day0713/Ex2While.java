package test.day0713;

import java.util.Scanner;

public class Ex2While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int score;
		int cnt=0;//제대로 입력된 점수의 갯수
		int tot=0;//점수들의 합
		
		while(true)
		{
			System.out.print("점수:");
			score=sc.nextInt();
			//999 일경우 빠져나간다
			if(score==999)
				break;
			//잘못 입력한경우 갯수에서 제외-다시 입력
			if(score<0 || score>100)
			{
				System.out.println("\t잘못된 점수입니다");
				continue;//조건식으로 이동
			}
			//갯수 증가
			cnt++;
			//총합
			tot+=score;
		}
		System.out.println("총 "+cnt+"개 점수 입력됨");
		System.out.println("총 합계:"+tot+"점");
	}

}
