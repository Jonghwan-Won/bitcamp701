package test.day0715;

import java.util.Random;
import java.util.Scanner;

public class Ex2Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		int money;
		int []lotto=new int[6];
		
		// 구입 금액을 입력받기
		System.out.println("로또 구입 금액을 입력하세요");
		money=sc.nextInt();
		
		// 받은 금액에 대한 조건문
		if(money<1000)	// 1000원보다 적을 경우 "금액 부족" 출력 후 종료
		{
			System.out.println("금액이 부족합니다.\t 종료합니다.");
			return;
			
		}
		else	// 1000원 이상일 경우 '구입 가능 회차'와 '거스름돈' 출력
		{
			System.out.println("총 "+money/1000+" 회 구입");
			System.out.println("거스름돈 : "+money%1000+"원");
		}
		
		System.out.println("--------------------------------------");
		
		for(int n=0;n<money/1000;n++)
		{
			System.out.printf("%2d회 : ",n+1);
			// 1000원 미만은 위에서 걸러지므로 1000원 이상에 따른 1회는 무조건 나오므로
			// 회차에 나오는 %2d 에는 n+1이 오게됨 (n=0 -> 1회)
			
			
			// 1부터 45까지 로또 숫자 구하기
			for(int i=0;i<lotto.length;i++)
			{
				lotto[i]=r.nextInt(45)+1; // 난수 생성 후 lotto 배열에 넣기 (0이아닌 1부터 생성해야하므로 +1)
				
				for(int j=0;j<i;j++) // i가 1이 됐을때 시작됨
				{
					if(lotto[i]==lotto[j])
					{
						i--;
						break;
						// 중복 처리
						// 바로 이전의 배열 숫자와 비교하고 같으면 감소시킨후 난수생성 반복문으로 빠져나가 다시 생성
					}
					
				}
			}
			
			
			// 정렬 - 오름차순
			for(int i=0;i<lotto.length-1;i++)
			{
				for(int j=i+1;j<lotto.length;j++)
				{
					if(lotto[i]>lotto[j])	// 비교 -> 1번째 숫자가 2번쨰 숫자보다 크면 둘의 위치를 바꿈
					{
						int temp=lotto[i];	// 같은 타입의 빈 변수를 만들고 i번 배열의 숫자를 넣음
						lotto[i]=lotto[j];	// j번 배열의 값을 i번으로 대입
						lotto[j]=temp;		// temp에 있던 i번의 값(더 큰 값)을 j번 배열로 넣음
					}
					
				}
				
			}
			
			
			// 출력
			for(int a:lotto)
				System.out.printf("%4d",a);
			System.out.println();
			
		} // 변수 n이 종료되는 시점
			
	}

}
