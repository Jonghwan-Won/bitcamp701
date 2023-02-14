package test.day0715;

import java.util.Date;
import java.util.Scanner;

public class Ex7Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int year, month, week, endday;
		
		//년도와 월 입력
		System.out.println("출력할 달력의 년도와 월 입력");
		year=sc.nextInt();
		month=sc.nextInt();
		
		if(month<1 || month>12)
		{
			System.out.println("월은 1~12의 값으로 입력해주세요");
			System.out.println("종료합니다");	
			return;
		}
		
		// 입력한 년월의 1일에 대한 요일을 구한다
		Date date=new Date(year-1900,month-1,1);
		week=date.getDay();
		
		// 입력한 달이 몇일까지 있는지 구한다
		switch(month)
		{
		case 2:
			if(year%4==0 && year%100!=0 || year%400==0)
				endday=29;
			else
				endday=28;
			break;
		case 4: case 6: case 9: case 11:
			endday=30;
			break;
		default:
			endday=31;
			
		}
		
		// 출력
		System.out.println("\t\t"+year+"년"+month+"월");
		System.out.println();
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//요일 week 숫자만큼 탭 띄우기
		for(int i=1;i<=week;i++)
			System.out.print("\t");
		
		//1일부터 endday까지 출력
		for(int i=1;i<=endday;i++)
		{
			System.out.printf("%2d\t",i);
			week++;
			if(week%7==0)
				System.out.println();
		}
	}

}
