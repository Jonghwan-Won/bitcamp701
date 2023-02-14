package test.day0804;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

//드라이버 -> Connection -> Statement, PreparedStatement, CallableStatement -> 
//execute(실행) -> select 같은 경우는 ResultSet 이라는 클래스를 이용해서
//데이터를 가져옴 -> 모든작업이 끝난 후 항상 모든 자원은 close

public class Ex1_OracleJdbc {
	static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public Ex1_OracleJdbc() {	// 디폴트 생성자 만들기
		// TODO Auto-generated constructor stub
		try {
			Class.forName(DRIVER);
			System.out.println("오라클 드라이버 클래스 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 클래스 실패 :"+e.getMessage());
		}
	}
	
	//오라클 서버에 연결 후 반환하는 메서드
	public Connection getConnection()	//java.sql 패키지		Connection 타입으로 반환
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			System.out.println("오라클 연결 성공!!");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패:"+e.getMessage());
		}
		return conn;
	}

	//food 테이블의 데이터를 조회해서 가져오기
	public void foodSelect()
	{
		Connection conn=null;	//멤버변수가 아닌 지역변수 사용
		Statement stmt=null;	//java.sql 패키지
		ResultSet rs=null;		//java.sql 패키지
		String sql="select foodno,fname,to_char(fprice,'L99,999')"
				+ " fprice from food order by fname asc";
		
		//제목
		System.out.println("foodno\tfood\tprice");
		System.out.println("--------------------------");
	
		//오라클 서버에 연결
		conn=this.getConnection();
		//statement
		//sql을 실행하기위해 statement 종류를 얻어야함
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())	//rs.next() 는 다음 레코드로 이동, 데이터가 없으면 false 반환
			{
				//index로 가져와보자
//				int fno=rs.getInt(1);
//				String fname=rs.getString(2);
//				int fprice=rs.getInt(3);
				
				//column name 으로 가져와보자
				int fno=rs.getInt("foodno");
				String fname=rs.getString("fname");
				String fprice=rs.getString("fprice");
				
				System.out.println(fno+"\t"+fname+"\t"+fprice);
			}
			System.out.println("** FOOD 조회 끝 **");
		} catch (SQLException e) {
			System.out.println("select 오류 :"+e.getMessage());
		} finally {
			try {	//닫을때는 역순으로
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	//insert method
	public void insertFood(String fname,int fprice)
	{
		String sql="insert into food values (seq1.nextval,'"+fname+"',"+fprice+")";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		//db연결
		conn=this.getConnection();
		try {
			stmt=conn.createStatement();
			//실행
			stmt.execute(sql);
			//결과 다시 출력
			System.out.println("** insert 후 전체 다시 출력 **");
			//같은 메서드끼리는 this로 호출가능
			this.foodSelect();
			
		} catch (SQLException e) {
			System.out.println("insert 오류:"+e.getMessage());
		}finally {
			try {	//닫을때는 역순으로
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	}
	
	//delete method
	public void deleteFood(String fname)
	{
		String sql="delete from food where fname='"+fname+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=this.getConnection();
		
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);	//삭제된 레코드의 갯수를 반환
			if(n==0)
				System.out.println(fname+" 메뉴는 없습니다!!");
			else
				System.out.println("총 "+n+"개의 메뉴가 삭제되었습니다");
		} catch (SQLException e) {
			System.out.println("delete 오류:"+e.getMessage());
		}finally {
			try {	//닫을때는 역순으로
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_OracleJdbc ex=new Ex1_OracleJdbc();
//		ex.foodSelect();	//scanner로 입력받아서 조회메뉴를 따로 부르거임
		
		Scanner sc=new Scanner(System.in);
		String num="";
		while (true)
		{
			System.out.println("1.추가 2.전체출력 3.삭제 4.종료");
			num=sc.nextLine();
			switch(num)
			{
			case "1":
			{
				System.out.println("추가할 메뉴명");
				String fname=sc.nextLine();
				System.out.println("가격은?");
				int fprice=Integer.parseInt(sc.nextLine());
				//메서드 호출
				ex.insertFood(fname, fprice);
			}
				break;
			case "2":
				ex.foodSelect();
				break;
			case "3":
			{
				System.out.println("삭제할 메뉴명을 입력하세요");
				String fname=sc.nextLine();
				// 삭제 메서드 호출
				ex.deleteFood(fname);
			}
				break;
			default:
				System.out.println("** 종료합니다 **");
				System.exit(0);
			}
		}
		
	}

}
