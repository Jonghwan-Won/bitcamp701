package test.day0804;
//sawon 테이블에서 부서별 인원수와 평균 급여 출력하기

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DbConnect;

public class Ex3_OracleSawon {
	DbConnect db=new DbConnect();
	
	public void list()
	{
		//마지막 finally 에서 db.dbClose(conn, stmt, rs);
		//dbClose 할때 외부 기준에서 해당 변수에 값이 있어야 문제없이 닫힘

		//conn은 초반에 외부에서 이미 값을 받아오므로 null값을 주지않아도됨 (줘도 됨)
		//conn=db.getOracleConnection();
		
		//stmt와 rs는 try 내부에서 값이 정해지게되어 외부 기준에서는 없음
		
		
		String sql="select buseo,count(*) count, round(avg(pay),0) pay from sawon group by buseo";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		//oracle 연결
		conn=db.getOracleConnection();
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("부서명\t인원수\t평균급여");
			System.out.println("-----------------------");
			
			while(rs.next()) //next -> 증감식 + 없으면 boolean false
			{
				String buseo=rs.getString("buseo");
				int count=rs.getInt("count");
				int pay=rs.getInt("pay");
				
				System.out.println(buseo+"\t"+count+"명\t"+pay+"원");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, stmt, rs);
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_OracleSawon ex=new Ex3_OracleSawon();
		ex.list();
		
	}

}
