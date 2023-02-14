package test.day3;

import java.util.Scanner;

public class Ex7For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 구구단(2~0) 을 입력받아 해당 구구단을 출력하시오
		/*
		 * 		** 3 단 **
		 *  	3 x 1 = 3
		 *  	3 x 2 = 6 
		*/
		
		Scanner sc=new Scanner(System.in);
		System.out.println("구구단 입력");
		int dan=sc.nextInt();
		
		// 아래↓ 2~9를 넘어가는 구구단을 입력받는 경우 종료 (main 메소드를 종료하기 -> return)
		
//		if(!(dan>=2 && dan<=9)) //! 을 넣어서 2와 9 사이의 값이 아닐때를 뜻
		if(dan<2 || dan>9)
		{
			System.out.println("\t2~9사이의 값이어야 합니다");
			return; //메서드 종료 → 아래 내용 진행안됨
		}
		
		
		System.out.printf("\t** %d단 **\n\n",dan);
		
		for(int i=1;i<=9;i++)
		{
			System.out.printf("\t%d x %d = %2d \n",dan,i,dan*i);
			//%d로 해도 문제없지만 %2d 로 하는 이유는 출력결과를 오른쪽 정렬하기위해서
			//%02d 는 공백대신 0이 채워짐
			
		}
		
		
	}

}
