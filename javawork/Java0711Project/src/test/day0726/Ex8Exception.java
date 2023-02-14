package test.day0726;

import java.sql.Date;

public class Ex8Exception {

	//호출하는곳으로 이셉션을 던진다
	public static void write() throws NullPointerException
	{
		Date date=null;
		int year=date.getYear()+1900;
		System.out.println("지금은 "+year+"년도입니다");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		write();
		} catch(NullPointerException e) {
			System.out.println("생성 안됨!!"+e.getMessage());
		}
		System.out.println("** 정상 종료 **");
	}

}
