package test.day0713;

public class Ex10For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 공백 4칸 * 1개
		// 공백 3칸 * 3개
		// 공백 2칸 * 5개
		// 공백 1칸 * 7개
		// 공백 0칸 * 9개
		
		for(int i=1;i<=5;i++)			// 행 방향
		{
			// 공백 -> 4,3,2,1,0
			for(int sp=i;sp<5;sp++)		// 열 방향
				System.out.print(' ');
			
			// * -> 1,3,5,7,9
			for(int j=1;j<=2*i-1;j++)		// 열 방향
			{
				System.out.print("*");
			}
			System.out.println();
		
		}System.out.println("----------------");
		
		
		
//		1****
//		*2***
//		**3**
//		***4*
//		****5
		
		for(int i=1;i<=5;i++)		// 행 5개
		{
				
			for(int j=1;j<=5;j++)	// 열 5개
			{
			if(i==j)  				// ex. 1행 1열일때, 2행 2열일때.. 그 나머지는 *로 채운다
					System.out.print(i);
				else
					System.out.print("*");
			}
			
			System.out.println();
			
		}
		
	}

}
