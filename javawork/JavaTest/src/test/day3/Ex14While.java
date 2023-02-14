package test.day3;

import java.util.Scanner;

public class Ex14While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 점수를 입력후 총 몇개를 입력했는지 갯수와 총 합계를 출력
		 * 단, 0이 입력되면 입력을 종료하고 결과를 출력   → break
		 * 1~100을 벗어나는 경우는 갯수와 총합에서 제외   → continue
		*/
		
		Scanner sc=new Scanner(System.in);
		int num,sum=0,cnt=0;
		
		System.out.println("점수를 입력하세요");
		
		while(true)
		{
			//num 입력
			num=sc.nextInt();
			
			//0입력시 break
			if(num==0) {
				break;
			}
			
			//1~100 을 벗어나면 continue(조건식으로 이동)
			if (num<1 || num>100) {
				continue;
			}
			
			//cnt증가 : 증감연산자이므로 초기값이 필요함 → 0으로 초기화 필요
			cnt++;
			
			//sum에 num 더하기 : 대입연산자이므로 초기값이 필요함 → 0으로 초기화 필요
			sum+=num;
			
		}
		//cnt와 sum 출력
		System.out.println("cnt: "+cnt);
		System.out.println("sum: "+sum);
		
//평균 구하기		System.out.println("avg: "+sum/cnt); 
	}

}

/*
 * 90
 * 100
 * 120
 * -10
 * 0
 * 
 * cnt:2  → 90과 100만 카운트
 * sum:190  → 90과 100만 조건에 맞으므로 합산
 */