package test.day3;

public class Ex6For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum=0; // 초기값 없으면 쓰레기값 들어가므로 초기화 해줘야함 ex.대입연산자
		//for문을 이용해서 1~100까지의 합을 sum 에 구해서 출력해보세요
		
		for(int i=1;i<=100;i++)
		{
			sum+=i;			
		}
		
		System.out.println("sum="+sum);
		System.out.printf("1부터 100까지의 합은 %d\n",sum);
		System.out.println();
		
		/* 아래는 그냥 내가 해본 홀수의 합
		 * int hi=0;
		 * 
		 * for(int i=1;i<=100;i+=2) hi+=i;
		 * 
		 * System.out.println(hi); 
		 * System.out.printf("1부터 100까지 홀수의 합은 %d",hi);
		 */
		
		int fact=1;
		for(int i=1;i<=10;i++)
		{
			fact*=i;
			System.out.printf("%d factorial=%d\n",i,fact);
		}
		
	}

}
