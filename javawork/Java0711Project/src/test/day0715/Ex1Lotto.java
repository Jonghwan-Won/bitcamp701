package test.day0715;

import java.util.Random;

public class Ex1Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 배열에 1~45 사이의 난수를 발생시켜 넣기
		int []lotto=new int[6];
		Random r=new Random();
				
		for(int i=0;i<lotto.length;i++)
		{
			lotto[i]=r.nextInt(45)+1;
			// 중복처리 - 같은숫자가 이전배열번지에 있을경우 다시 구한다

			for(int j=0;j<i;j++)	// i가 0일때는 동작하지 않음 (난수 1개 생성된 후 2번째부터 비교
			{
				if(lotto[i]==lotto[j])
				{
					i--; //증감식 i++로 이동하므로 제자리로 가기위한 --
					break;
				}
			}
		}
		
		// 정렬 - 오름차순
		for(int i=0;i<lotto.length-1;i++) // 시작부터 마지막 전 까지
		{
			for(int j=i+1;j<lotto.length;j++) // 기준 다음값 부터 끝까지
			{
				if(lotto[i]>lotto[j])
				{
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
				
		}
		
		
		System.out.println("** 로또 숫자 출력**");
		for(int a:lotto)
			System.out.printf("%4d",a);
		
		
		
	}

}
