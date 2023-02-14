package test.day3;

import java.util.Scanner;

public class Ex4EndDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int year,month,endday;
		System.out.println("년도와 월을 입력해주세요");
		year=sc.nextInt();
		month=sc.nextInt();
		System.out.printf("%d년 %02d월 입력하였습니다\n",year, month);
		//입력한 년도가 윤년인지 평년인지 판단하기
		
		boolean flag=year%4==0&&year%100!=0||year%400==0;
		//윤년 공식 : 4년에 한번씩이므로....
		
		if(flag) // if(flag==true) 를 줄인 것
			System.out.println(year+"년은 윤년입니다.");
		else
			System.out.println(year+"년은 평년입니다.");
		
		switch(month) {
		case 2:
			endday=flag?29:28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			endday=30;
			break;
			
		case 1: case 3: case 5: case 7:
		case 8: case 10: case 12:
			endday=31;
			break;
			
			default:
				endday=0; //아무값이나 지정
				break;
				
		}
		
		if(endday==0)
			System.out.println("월을 잘못 입력했습니다!!");
		else
			System.out.printf("%d년 %02d월은 %d일까지 있습니다",year,month,endday);
			
		
	}

}
