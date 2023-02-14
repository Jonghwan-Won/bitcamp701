package test.day0715;

import java.util.Calendar;
import java.util.Date;

public class Ex6Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("현재날짜 얻기");
		Date date=new Date();
		
		// 년도는 1900이 빠진 값으로 반환
		int year=date.getYear()+1900;
		// 월은 0~11 로 되어있음
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		// 요일숫자 - 일:0, 월:1, 화:2 ..........토:6
		int week=date.getDay();
		System.out.println(year+"-"+month+"-"+day);
		System.out.println("요일숫자 : "+week);
		
		System.out.println();
		
		
		
		
		System.out.println("현재날짜 얻기 #2");		// Calendar 활용
		Calendar cal=Calendar.getInstance();
		int year2=cal.get(Calendar.YEAR);
		int month2=cal.get(Calendar.MONTH)+1;		// 0~11 반환으로 +1 해줘야됨
		int day2=cal.get(Calendar.DATE);
		int week2=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year2+"-"+month2+"-"+day2);
		System.out.println("요일숫자:"+week2);		// 일:1, 월:2 .... 토:7
		
		System.out.println();
		
		
		
		
		System.out.println("Date클래스를 이용해서 2021-5-1이 무슨요일인지");
		Date date2=new Date(2021-1900,5-1,1);
		int week3=date2.getDay();
		System.out.println(week3);	// 6:토요일
		
		System.out.println();
		
		
	
		
		System.out.println("Date클래스를 이용해서 2022-12-1이 무슨요일인지");
		Date date3=new Date(2022-1900,12-1,1);
		int week4=date3.getDay();
		System.out.println(week4);  // 4:목요일
		
		
		
		
	}

}
