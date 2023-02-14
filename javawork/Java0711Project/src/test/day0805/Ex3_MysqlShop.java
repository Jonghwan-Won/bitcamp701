package test.day0805;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex3_MysqlShop {
	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	public void insert()
	{
		System.out.println("카테고리 선택 : 1.top 2.bottom 3.outer 4.onepiece");
		int n=Integer.parseInt(sc.nextLine());
		
		//카테고리 번호에 해당되지않는 입력을 했을 경우
		if(n<1 || n>4) {
			System.out.println("잘못 입력했습니다");
			return; //메서드 종료
		}
		
		String category=n==1?"top":n==2?"bottom":n==3?"outer":"onepiece";
		//if 써도되지만 삼항연산자가 간단함
		
		System.out.println("상품명은?");
		String sang=sc.nextLine();
		System.out.println("색상은?(영문으로)");
		String color=sc.nextLine();
		System.out.println("사이즈는 (55,66,77,90,95,100");
		String ssize=sc.nextLine();
		System.out.println("가격은?");
		int price=Integer.parseInt(sc.nextLine());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//mysql 연결
		conn=db.getMysqlConnection();
		
		String sql="insert into shop values (null,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, category);
			pstmt.setString(2, sang);
			pstmt.setString(3, color);
			pstmt.setInt(4, price);
			pstmt.setString(5, ssize);
			
			//실행
			pstmt.execute();
			System.out.println("상품을 추가했습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	public void update()
	{
		System.out.println("검색할 상품번호는?");
		int num=Integer.parseInt(sc.nextLine());
		
		int cnt=this.selectOne(num);
		
		if(cnt==0) {
			System.out.println("해당 상품은 없습니다. 종료합니다");
			return;
		}
		
		System.out.println("수정하려는 품목을 선택해주세요");
		System.out.println("1.카테고리 2.상품명 3.색상 4.가격");
		int select=Integer.parseInt(sc.nextLine());
		
		String cname=select==1?"category":select==2?"sang":select==3?"color":"price";
		
		System.out.println("변경할 값을 입력해주세요");
		String newvalue=sc.nextLine();
		
		String sql="update shop set "+cname+"=? where num=?";
//		System.out.println(sql);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩 2개
			pstmt.setString(1, newvalue);
			pstmt.setInt(2, num);
			//실행
			pstmt.execute();
			
			//다시 seletcOne 호출
			selectOne(num);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
		
		
			
	}
	
	public int selectOne(int num)	//num을 입력받아서 호출하고 int형 반환값으로 보낼것
	{
		int n=0;
		String sql="select * from shop where num=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				n=1;
				//출력
				System.out.println("** 검색상품 **");
				System.out.println("카테고리 : "+rs.getString("category"));
				System.out.println("상 품 명 : "+rs.getString("sang"));
				System.out.println("색   상 : "+rs.getString("color"));
				System.out.println("가   격 : "+rs.getString("price"));
				System.out.println("사 이 즈 : "+rs.getString("ssize"));
				System.out.println("입 고 일 : "+rs.getString("ipgoday"));
//				System.out.println("입 고 일 : "+rs.getTimestamp("ipgoday"));
				//단순 출력용도이므로 getTimestamp로 읽어도되고 String으로 읽어도됨(date타입이라 이미 년월일밖에없음)
				
			}else {	//흐름상 초기값이 어차피 0이므로 else는 안줘도됨
				n=0;
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		
		return n;
	}
	
	public void menu()
	{
		System.out.println("** 메뉴 **");
		System.out.println("1.상품 추가");
		System.out.println("2.상품조회 및 수정");
		System.out.println("------------------------");
		
		int menu=0;
		try {
			menu=Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			menu=2;	//문자입력 시 무조건 상품 조회로 넘어감
		}
		
		if(menu==1)
			this.insert();
		else
			this.update();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_MysqlShop ex=new Ex3_MysqlShop();
		ex.menu();
	}

}
