package test.day0803;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1_Jdbc {

	public void oracleConnect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패:"+e.getMessage());
		}
		
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			System.out.println("나의 오라클 연결됨");
		} catch (SQLException e) {
			System.out.println("내 오라클 연결 실패 : "+e.getMessage());
		}
	}
	
	public void mysqlConnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql8 드라이버 실패:"+e.getMessage());
		}
		
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/bitcamp?serverTimezone=Asia/Seoul";
		try {
			conn=DriverManager.getConnection(url, "angel", "1234");
			System.out.println("나의 mysql8 연결됨");
		} catch (SQLException e) {
			System.out.println("나의 mysql8 연결 실패 : "+e.getMessage());
		}
	}
	
	public void gangsaOracleConnect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패:"+e.getMessage());
		}
		
		Connection conn=null;
		String url="jdbc:oracle:thin:@192.168.0.27:1521:xe";
		try {
			conn=DriverManager.getConnection(url, "angel", "a1234");
			System.out.println("강사 오라클 연결됨");
		} catch (SQLException e) {
			System.out.println("강사 오라클 연결 실패 : "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		Ex1_Jdbc ex=new Ex1_Jdbc();
		
		while(true)
		{
			System.out.println("1.oracle 연결	  2.mysql 연결	   3.강사PC 오라클연결    4.종료");
			int n=sc.nextInt();
			
			switch (n) {
			case 1:
				ex.oracleConnect();
				break;
			case 2:
				ex.mysqlConnect();
				break;
			case 3:
				ex.gangsaOracleConnect();
				break;
			default:
				System.out.println("** 종료합니다 **");
				System.exit(0);
			}
		}
			
	}

}
