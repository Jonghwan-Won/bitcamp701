package test.day2;

import java.util.Scanner;

public class Ex10Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		String name;
		int year, mod; // mod 는 나머지 값을 담기위한 임의 변수
		String ddi=""; // 지금처럼 초기값을 줄거면 else if로 모든 조건을 써줘야하고,
						// 초기값을 안줄거면 else 로 끝내서 이외 모든 상황은 그것으로 끝나게 해야함

		System.out.println("이름 입력");
		name=sc.nextLine();
		System.out.println("태어난 년도 입력");
		year=sc.nextInt();

		/*
		 * 년도를 12로 나눈 나머지로 구하기
		 * hint : 서기1년은 닭띠 해 입니다.
		 */

		mod=year%12;
		if(mod==0)
			ddi="원숭이";
		else if(mod==1)
			ddi="닭";
		else if(mod==2)
			ddi="개";
		else if(mod==3)
			ddi="돼지";
		else if(mod==4)
			ddi="쥐";
		else if(mod==5)
			ddi="소";
		else if(mod==6)
			ddi="호랑이";
		else if(mod==7)
			ddi="토끼";
		else if(mod==8)
			ddi="용";
		else if(mod==9)
			ddi="뱀";
		else if(mod==10)
			ddi="말";
		else ddi="양";

		
		System.out.println(name+"님은 "+year+"년생이고 "+ddi+"띠 입니다.");
		
		 
		
	}

}
