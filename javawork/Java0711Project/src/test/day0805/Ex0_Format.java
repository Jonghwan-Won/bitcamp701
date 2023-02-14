package test.day0805;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex0_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 날짜나 숫자를 원하는 패턴으로 변경 후 문자열로 얻기
		// 현재 날짜
		Date date=new Date();
		//문자열로 변환
//		String s1=date.toLocaleString();	//다른것을 더 권한다 (취소선)
		String s1=date.toString();
		System.out.println(s1);	//Fri Aug 05 09:58:25 KST 2022
		
		//원하는 패턴대로 출력하고자 할 경우
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		System.out.println(sdf1.format(date));	//2022년 08월 05일 10시 00분
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd EEEE");	//EEE 세개쓰면 '금'
		System.out.println(sdf2.format(date));	//2022-08-05 금요일
		
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd a hh시");
		System.out.println(sdf3.format(date));	//2022-08-05 오전 10시
		
		//한줄로 줄여서 출력
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));	//2022-08-05 10:11
		
		
		//숫자
		//getCurrencyInstance 로 생성할경우 ₩266,777 이런 식 출력
		NumberFormat nf1=NumberFormat.getCurrencyInstance();	//new로 생성 안된다고함.. 왜?
		String n1=nf1.format(266777);
		System.out.println(n1);	//₩266,777
		
		NumberFormat nf2=NumberFormat.getInstance();
		String n2=nf2.format(2666777);
		System.out.println(n2);	//2,666,777
		
		//한줄로 줄여서 출력
		int money=3456780;
		System.out.println(NumberFormat.getCurrencyInstance().format(money));	//₩3,456,780
		System.out.println(NumberFormat.getInstance().format(money));	//3,456,780
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
