package test.day0713;

import java.util.Scanner;

public class Munje2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
//		 문제 2. for		
//		 두 수 x,  y 입력 후 x의 y 승의 값을 구하시오
//		 예) 2 3
//		 2의 3승은 8입니다.
//		 2*2*2 = x를 y번 곱함
				
		System.out.println("두 수를 입력하세요");
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=x;				
		
		//선생님 풀이는 int x,y,z=1;  -> z를 1로 초기화해주는데, 후에 x값이 z에 대입되므로 큰 상관은없어보임
		
		for(int i=1;i<y;i++) {
			z*=x;
		}
		
		System.out.println(x+"의 "+y+"승은 "+z);
		
		
	}

}
