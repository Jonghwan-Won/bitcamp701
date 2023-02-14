package test.day0804;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;

public class Munje {

	DbConnect db=new DbConnect();
	
	
	// 차량 등록
	public void insertCar(String company,String carname,String carcolor,int carprice)
	{
		String sql="insert into companycar (company,carname,carcolor,carprice,carguip) values ('"
				+company+"','"+carname+"','"+carcolor+"',"+carprice+",now())";
//		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);	//sql문 실행
			
			System.out.println("** 차량등록 후 다시 출력 **");
			this.selectCar();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, stmt);
		}
		
	}
	
	public void selectCar() //전체 조회
	{
		String sql="select * from companycar order by num asc";
//		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("번호\t회사명\t자동차명\t색상\t가격\t구입일");
			System.out.println("====================================================");
			
			SimpleDateFormat sdf=new SimpleDateFormat();
			
			int cnt=0;
			while(rs.next())
			{
				cnt++;
				int num=rs.getInt("num");
				String company=rs.getString("company");
				String carname=rs.getString("carname");
				String carcolor=rs.getString("carcolor");
				int carprice=rs.getInt("carprice");
				
				Timestamp ts=rs.getTimestamp("carguip");
				String day=sdf.format(ts);
				
				System.out.println(num+"\t"+company+"\t"+carname+"\t"+carcolor+"\t"+carprice+"\t"+day);
			}
			System.out.println("총 "+cnt+"개의 차량 보유중");
			System.out.println();
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, stmt, rs);
		}
		
	}
	
	public void selectGroup()	//회사별 통계
	{
//		String sql="select * from companycar";
		String sql="select company 회사명, count(*) 등록갯수, round(avg(carprice),0) 평균단가 from companycar group by company";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//db연결
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();	//statement 만들고
			rs=stmt.executeQuery(sql);

			
			System.out.println("회사명\t등록갯수\t평균단가");
			System.out.println("--------------------------");
			
			while(rs.next())
			{
				String company=rs.getString("회사명");
				int cnt=rs.getInt("등록갯수");
				int avg=rs.getInt("평균단가");
				
				System.out.println(company+"\t"+cnt+"\t"+avg);
			}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			db.dbClose(conn, stmt, rs);
		}
		
	}
	
	public void deleteCar(int num)	//차량 삭제
	{
		String sql="delete from companycar where num="+num;
//		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
				
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println("해당 번호가 없습니다");
			else {
				System.out.println("삭제되었습니다");
				this.selectCar();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, stmt);
		}
		
		
		
		//입력한 숫자가 없다면
	}
	
	public void updateCar(int num, String carname, String carcolor)
	{
		String sql="update companycar set carname='"+carname+"',carcolor='"+carcolor+"' where num = "+num;
//		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println("해당 번호가 없습니다");
			else
			{
				System.out.println("수정 완료되었습니다.");
				this.selectCar();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, stmt);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Munje mj=new Munje();
		Scanner sc=new Scanner(System.in);
		

		while(true)
		{
			System.out.println("** 메뉴 **");
			System.out.println("1.자동차등록 2.전체 조회 3.회사별 통계 4.삭제 5.수정 6.종료");
			
			int n=Integer.parseInt(sc.nextLine());
			
			switch(n)
			{
			case 1:
			{
				System.out.println("현대 기아 쌍용 中 택 1");
				System.out.println("회사명 입력:");
				String company=sc.nextLine();
				//현대 기아 쌍용만 받을 수 있는 방법?
				System.out.println("자동차 이름 입력");
				String carname=sc.nextLine();
				System.out.println("자동차 색상 입력");
				String carcolor=sc.nextLine();
				System.out.println("자동차 가격 입력");
				int carprice=Integer.parseInt(sc.nextLine());
				
				mj.insertCar(company,carname,carcolor,carprice);
				break;
			}
			case 2:
			{
				System.out.println("등록된 차량 전체 조회");
				mj.selectCar();
				break;
			}
			case 3:
			{
				System.out.println("** 회사별 차량 통계 **");
				mj.selectGroup();
				break;
			}
			case 4:
			{
				System.out.println("삭제할 차량의 번호 입력 : ");
				int num=Integer.parseInt(sc.nextLine());
				
				mj.deleteCar(num);
				break;
			}
			case 5:
			{
				System.out.println("수정할 차량의 번호 입력 :");
				int num=Integer.parseInt(sc.nextLine());
				System.out.println("차량 이름 입력 :");
				String carname=sc.nextLine();
				System.out.println("차량 색상 입력 :");
				String carcolor=sc.nextLine();
				
				mj.updateCar(num,carname,carcolor);
				break;
			}
			default:
			{
				System.out.println("** 종료합니다 **");
				System.exit(0);
			}
			
			}//switch
		}//while
		
	}

}
