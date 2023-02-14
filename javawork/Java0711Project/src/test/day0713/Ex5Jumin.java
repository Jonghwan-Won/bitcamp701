package test.day0713;

import java.util.Scanner;

public class Ex5Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String jumin;
		System.out.println("주민번호 입력(하이픈 포함)");
		while(true)
		{
			jumin=sc.nextLine();
			if(jumin.length()!=14) {
				System.out.println("다시 입력해주세요");
				continue;
			} 
			break;
			
		}
		System.out.println(jumin);
		//891212-1234567
		char gender=jumin.charAt(7);
		if(gender=='1'||gender=='3')		// gender 는 타입이 char 이기때문에, 꼭 ''를 써줘야함
//		if(gender==49||gender=51)			// 아스키코드에서 49가 '1'이므로 이 방식도 가능함
			System.out.println("남자!!");
		else if(gender=='2'||gender=='4')
			System.out.println("여자!!");
		else
			System.out.println("외계인!!");
		
		//생년월일 얻기
		String sYear=jumin.substring(0, 2); // substring : 문자열에서 추출 0~1까지 추출(시작부터 끝-1)
		String sMonth=jumin.substring(2, 4); //
		String sDay=jumin.substring(4, 6);
		
		System.out.println(sYear+"-"+sMonth+"-"+sDay);

				
//		  문제 : 성별이 1, 2일 경우 1900 더하기
//						3, 4일 경우 2000 더하기
//		  생년월일 : 1989년 12월 12일생
		
		int iYear=Integer.parseInt(sYear);
		if(gender=='1'||gender=='2')
			iYear+=1900;
		else if(gender==3 || gender==4)
			iYear+=2000;
		System.out.println("생년월일 : "+iYear+"년 "+sMonth+"월 "+sDay+"일생");
		
		
		
	}

}
