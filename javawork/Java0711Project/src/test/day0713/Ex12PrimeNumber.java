package test.day0713;

public class Ex12PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("1~100 사이의 소수 구하기");

		// 소수? 1을 제외하고 자기 자신만을 약수로 가진 수
		// 다중 for문

		// 2 3 5 7 11 13 17 ... 
		// i=2	2%2==0	i와 j가 같으므로 소수
		// i=3	3%2!=0, 3%3==0	소수	
		// i=4	4%2==0, i와 j가 다르므로 소수가 아님

		Exit:
			for(int i=2;i<=100;i++)
			{
				for(int j=2;j<=i;j++)
				{
					if(i%j==0)
					{
						if(i==j)
							System.out.printf("%3d",i);
//							System.out.printf("%-3d",i);	-> 3칸, 왼쪽정렬
						else
							continue Exit;
					}

				}

			}

	}

}
