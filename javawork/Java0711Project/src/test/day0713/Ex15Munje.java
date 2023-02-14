package test.day0713;

import java.util.Random;
import java.util.Scanner;

public class Ex15Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
//		 문제 1. for
//		 숫자 n을 입력하면 1부터 n까지의 합계를 구하라
//		 예) 숫자 입력 : 100
//		 1부터 100까지는 5050입니다.
		
//		System.out.println("숫자를 입력하세요");
//		int n=sc.nextInt();
//		int sum=0;
//
//		for(int i=1;i<=n;i++) {
//			sum+=i;
//		}
//			System.out.println(sum);
		
//		 문제 2. for		
//		 두 수 x,  y 입력 후 x의 y 승의 값을 구하시오
//		 예) 2 3
//		 2의 3승은 8입니다.
//		 2*2*2 = x를 y번 곱함
				
//		System.out.println("두 수를 입력하세요");
//		int x=sc.nextInt();
//		int y=sc.nextInt();
//		int z=x;				//선생님 풀이는 int x,y,z=1;  -> z를 1로 초기화해주는데, 후에 x값이 z에 대입되므로 큰 상관은없어보임
//		
//		for(int i=1;i<y;i++) {
//			z*=x;
//		}
//		
//		System.out.println(x+"의 "+y+"승은 "+z);
		
		
// 		 문제3. while
//		 1~100 사이의 난수를 변수 rnd에 저장 후
//		 while 문을 이용하여 숫자를 입력하여 맞추기
//		 예)  rnd 가 76 일 경우
//				50 -> 50보다 큽니다.
//				80 -> 80보다 작습니다.
//				76 -> 짝짝짝 정답입니다. => 종료
//		 조건 추가 : 10회 이내에 못맞출경우 "시간초과!!" 출력 후 종료
		
		int cnt=0; // 시도 횟수
		
		
		int rnd; // 난수
		rnd=(int)(Math.random()*100)+1; // (00~99) +1 난수 생성 후 rnd에 저장
		
		System.out.println(rnd); // rnd 값 미리 보기
		

		while(cnt<10) { 	// 시도횟수 cnt가 10번이 될 때 까지 반복

			System.out.println("숫자를 입력하세요");
			int num=sc.nextInt(); // 입력받은 값



			if(num>rnd) {
				System.out.println(num+"보다 작습니다.");
			}
			else if(num<rnd){
				System.out.println(num+"보다 큽니다.");
			}
			else {
				System.out.println("짝짝짝 정답입니다.");
				break;
			}
			
			cnt++;		// 한번 실행 시 cnt 증가
			
		}
		// 반복이 종료되었을 때는 (횟수 초과 or 정답)
		
		if(cnt==10)
			System.out.println(" 시간 초과!! "); // 횟수 초과에 따른 반복문 종료
		else
			System.out.println(" 정상 종료"); // num = rnd 정답에 따른 반복문 종료
	}

}


