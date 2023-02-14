package test.day0805;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;

public class Ex2_OracleSawon {

	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	public void insert()
	{
		System.out.println("데이터를 추가하려면 y 를, 바로 목록을 보려면 n");
		char a=sc.nextLine().charAt(0);	//문자열(nextLine)의 첫글자만 얻기
		
		if(a!='y')	//y가 아니면 무조건 list를 호출
		{
			list();
			return;
		}
		
		//y일 경우 데이터 추가
		System.out.println("사원명");
		String name=sc.nextLine();
		System.out.println("부서명");
		String buseo=sc.nextLine();
		System.out.println("급여");
		int pay=0;
		try {
			pay=Integer.parseInt(sc.nextLine());	//문자가 섞여있으면 이셉션 발생
		} catch (NumberFormatException e) {
			pay=30000; //입력시 문제가 발생하면 무조건 3만원으로 저장
		}
		System.out.println("나이");
		int age=Integer.parseInt(sc.nextLine());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
//		ResultSet rs=null;	//insert라서 필요없음, select 할 때 필요함
		
		//db연결
		conn=db.getOracleConnection();
		
		String sql="insert into sawon values (seq1.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//물음표 갯수만큼 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, buseo);
			pstmt.setInt(3, pay);
			pstmt.setInt(4, age);
			
			//실행
			pstmt.execute();
			
			//다시출력
			System.out.println("** insert 후 다시 출력 **");
			list();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		
	}
	
	public void list()		// insert 후 list에서 호출
	{
		String sql="select * from sawon order by name asc";	//name의 오름차순으로 정렬
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//db연결
		conn=db.getOracleConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//sql문에 물음표가 없으므로 바인딩 작업이 필요없음
			//pstmt.setString(1, buseo);
			
			//실행
			rs=pstmt.executeQuery();
			
			//제목부터 출력
			System.out.println("번호\t이름\t부서\t급여\t나이\t입사일");
			System.out.println("=====================================================");
			
			while(rs.next())
			{
				int num=rs.getInt("num");	//단순 출력 용도로 가져올땐 타입을 굳이 맞출필요없음 (ex. String으로 가져와도됨)
				String name=rs.getString("name");
				String b=rs.getString("buseo");
				int pay=rs.getInt("pay");
				int age=rs.getInt("age");
				Timestamp ipsa=rs.getTimestamp("ipsaday");
				
				System.out.print(num+"\t");
				System.out.print(name+"\t");
				System.out.print(b+"\t");
				System.out.print(NumberFormat.getCurrencyInstance().format(pay)+"\t");
				System.out.print(age+"\t");
				System.out.println(new SimpleDateFormat("yyyy-MM-dd EEE").format(ipsa));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}

	}
	
	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Ex2_OracleSawon ex=new Ex2_OracleSawon();	// main에서는 insert만 호출
		ex.insert();
	}

}
