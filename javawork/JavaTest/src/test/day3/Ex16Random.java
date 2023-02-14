package test.day3;

import java.util.Scanner;

public class Ex16Random {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int cnt=0,num;
		
		//1~100 사이의 난수 구하기
		int rnd=(int)(Math.random()*100)+1; // =랜덤코드
		
		System.out.println("숫자를 입력하세요");
		
		while(true)
		{
			System.out.print(++cnt+":");
			//num 입력
			num=sc.nextInt();
			
			//num 과 rnd 비교
			if(num>rnd)
				System.out.println(num+" 보다 작습니다.");
			else if(num<rnd)
				System.out.println(num+" 보다 작습니다.");
			else {
				//정답입니다 출력 후 종료 (break)
				System.out.println("정답입니다.");
				break; //break의 위치 중요함!! 정답일때 break되어야하므로 중괄호로 꼭 출력문구와 함께!
			}
		}
		System.out.println("** 종료합니다 **");
		

	}
}
