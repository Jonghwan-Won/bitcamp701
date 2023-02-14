package test.day0713;

public class Ex9For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=5;i++)			// 행 방향
		{
			for(int j=1;j<=5;j++)		// 열 방향
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("----------------");
		
		for(int i=1;i<=5;i++)			// 행 방향
		{
			for(int j=1;j<=i;j++)		// 열 방향
			{
				System.out.print("*");
			}
			System.out.println();					
		
		}System.out.println("----------------");

		
		for(int i=5;i>=1;i--)			// 행 방향
		{
			for(int j=1;j<=i;j++)		// 열 방향
			{
				System.out.print("*");
			}
			System.out.println();					
		
		}System.out.println("----------------");
		
		
//		for(int i=1;i<=5;i++)			// 행 방향
//		{
//			for(int j=i;j<=5;j++)		// 열 방향
//			{
//				System.out.print("*");
//			}
//			System.out.println();					
//		
//		}System.out.println("----------------");
		
		
//		    *
//		   **
//		  ***
//		 ****
//		*****
		

		for(int i=1;i<=5;i++)			// 행 방향
		{
			//공백-> 4,3,2,1,0
			for(int sp=i;sp<5;sp++)		// 열 방향

				System.out.print(' ');

			// * -> 1,2,3,4,5
			for(int j=1;j<=i;j++)		// 열 방향
			{
				System.out.print("*");
			}
			System.out.println();

		}System.out.println("----------------");
		
	}
}
