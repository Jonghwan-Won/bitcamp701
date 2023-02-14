package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DbConnect {
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bitcamp?serverTimezone=Asia/Seoul";

	public DbConnect() {	//패키지가 다르기때문에 반드시 public // 생성자
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {	//오류잡기위해 실패할때만 출력하기로
			System.out.println("MYSQL 드라이버 오류:"+e.getMessage());
		}
	
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("ORACLE 드라이버 오류:"+e.getMessage());
		}
	}

	//oracle 서버 연결
	public Connection getOracleConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"angel","a1234");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패:"+e.getMessage());
		}
		return conn;
		
	}
	
	//mysql 서버 연결
		public Connection getMysqlConnection()
		{
			Connection conn=null;
			try {
				conn=DriverManager.getConnection(MYSQL_URL,"angel","1234");
			} catch (SQLException e) {
				System.out.println("mysql 연결 실패:"+e.getMessage());
			}
			return conn;
			
		}
		
		//close 들 - overloading method
		public void dbClose(Connection conn, Statement stmt) // return 없음 닫으면되기때문
		{
			//호출하는 메서드의 클래스 타입은 레퍼런스 즉 주소가 넘어오므로
			//그 메서드의 변수가 close 된다
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				
			}
		}
		
		public void dbClose(Connection conn, Statement stmt, ResultSet rs) // 중복함수기때문에 이름이 바뀌면 안됨
		{
			//호출하는 메서드의 클래스 타입은 레퍼런스 즉 주소가 넘어오므로
			//그 메서드의 변수가 close 된다
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {

			}
		}
		
		//PreparedStatement dbclose 추가
				public void dbClose(Connection conn, PreparedStatement pstmt) // 중복함수기때문에 이름이 바뀌면 안됨
				{
					//호출하는 메서드의 클래스 타입은 레퍼런스 즉 주소가 넘어오므로
					//그 메서드의 변수가 close 된다
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {

					}
				}
		
		//PreparedStatement dbclose 추가 - resultset 포함
		public void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) // 중복함수기때문에 이름이 바뀌면 안됨
		{
			//호출하는 메서드의 클래스 타입은 레퍼런스 즉 주소가 넘어오므로
			//그 메서드의 변수가 close 된다
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {

			}
		}
		
		



}
