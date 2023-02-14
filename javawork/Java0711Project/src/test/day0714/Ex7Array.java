package test.day0714;

import java.util.Scanner;

public class Ex7Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data= {2,6,12,8,9,15,17,4,19,16};
		int su,i;
		Scanner sc=new Scanner(System.in);
		
//		boolean flag=false; 
//		Ex6Array 의 다른방식
//		i를 for 밖에서 선언하고, boolean 방식을 사용하지않는 방법
		
		/*
		 * 숫자를 입력 후 그 숫자가 몇번째에 있는지 출력
		 * 없을 경우 "없습니다" 출력
		 *
		*/
		
		System.out.println("찾고자하는 숫자 입력");
		su=sc.nextInt(); // 배열 data의 타입도 int 임
		
		for(i=0;i<data.length;i++)
		{
			if(su==data[i])
			{
				System.out.println(i+1+"번째 있습니다");
				break;
			}
		}

		
		if(i==data.length) 
			System.out.println("없습니다.");

	}

}