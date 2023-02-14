package test.day0714;

import java.util.Scanner;

public class Ex1RandomWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 난수발생 후 정답 시 '다시 시작' 여부를 물어봄
		// y를 눌러 계속 할 경우 난수를 다시 생성하고 맞추는게 반복됨

		Scanner sc=new Scanner(System.in);
		int su,rnd,cnt;

		Exit:
			while(true)
			{
				cnt=0;
				rnd=(int)(Math.random()*100)+1;

				while(true)
				{
					System.out.print(++cnt+"회:");
					su=Integer.parseInt(sc.nextLine());		// 예전에 키보드 버퍼(엔터) 관련 이슈로 인해 이 방식으로 사용
					if(su>rnd)
						System.out.println("\t"+su+"보다 작습니다.");
					else if(su<rnd)
						System.out.println("\t"+su+"보다 큽니다.");
					else {
						System.out.println("*** 정답입니다 ***");
						System.out.println("계속하려면 y, 종료하려면 n을 입력해주세요");
						String ans=sc.nextLine();
						
						if(ans.equalsIgnoreCase("y")) {			// 대소문자 상관없이 비교
							System.out.println("** 새로운 난수 발생함! **");
							continue Exit;		// 바깥 while문의 처음(조건식)으로 이동
						}
						else {
							System.out.println("** 프로그램을 종료합니다");			// y를 제외한 입력은 모두 프로그램 종료
							break Exit;		// 두개의 while문을 모두 빠져나간다
						}
					}



				}

			}

	}

}
