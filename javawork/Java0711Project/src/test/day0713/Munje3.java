package test.day0713;

import java.util.Scanner;

public class Munje3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 문제(while)
//		 1~100 사이의 난수를 변수 rnd에 저장 후
//		 while 문을 이용하여 숫자를 입력하여 맞추기
//		 예)  rnd 가 76 일 경우
//				50 -> 50보다 큽니다.
//				80 -> 80보다 작습니다.
//				76 -> 짝짝짝 정답입니다. => 종료
//		 조건 추가 : 10회 이내에 못맞출경우 "시간초과!!" 출력 후 종료
		
		Scanner sc=new Scanner(System.in);
		
		int cnt=0; // 시도 횟수
		
		
		int rnd; // 난수
		rnd=(int)(Math.random()*100)+1; // (00~99) +1 난수 생성 후 rnd에 저장
//		
//		System.out.println(rnd); // rnd 값 미리 보기
//		
//
//		while(cnt<10) { 	// 시도횟수 cnt가 10번이 될 때 까지 반복
//
//			System.out.println("숫자를 입력하세요");
//			int num=sc.nextInt(); // 입력받은 값
//
//
//
//			if(num>rnd) {
//				System.out.println(num+"보다 작습니다.");
//			}
//			else if(num<rnd){
//				System.out.println(num+"보다 큽니다.");
//			}
//			else {
//				System.out.println("짝짝짝 정답입니다.");
//				break;
//			}
//			
//			cnt++;		// 한번 실행 시 cnt 증가
//			
//		}
//		// 반복이 종료되었을 때는 (횟수 초과 or 정답)
//		
//		if(cnt==10)
//			System.out.println(" 시간 초과!! "); // 횟수 초과에 따른 반복문 종료
//		else
//			System.out.println(" 정상 종료"); // num = rnd 정답에 따른 반복문 종료
		

		
		
		
		// 아래는 선생님 풀이
		
		while(true) 
		{
			System.out.println(++cnt+":");
			int num=sc.nextInt();
			
			if(num>rnd) {
				System.out.println("\t"+num+"보다 작습니다.");
			}
			else if(num<rnd){
				System.out.println("\t"+num+"보다 큽니다.");
			}
			else {
				System.out.println("짝짝짝 정답입니다.");
				break;
			
			}
			
			if(cnt==10)
			{
				System.out.println("\t 시간 초과!! 종료합니다"); // 횟수 초과에 따른 반복문 종료
			break;
			}



		}

	}
}