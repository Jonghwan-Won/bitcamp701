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

//Statement : sql을 완벽하게 만든 후 execute할 때 sql 실행

//PreparedStaterment : sql의 value을 미완성으로 만든 후 statement생성 시 sql을 검사
//==> ?(물음표) 자리에 바인딩으로 모든 값을 준 후에 마지막에 execute(sql 파라미터 없음)
//statement 보다 자주 사용함


public class Ex1_OraclePrepare {
	
	DbConnect db=new DbConnect();
	
	public void selectBuseo()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("조회할 부서를 입력해주세요");
		String buseo=sc.nextLine();
		
		//인원수 검색
		int inwon=this.getBuseoCount(buseo);
		if(inwon==0) {
			System.out.println(buseo+" 부서는 없습니다");
			return;	//selectBuseo 메서드 종료
		}
		
//		inwon!=0 일때 아래 실행
		System.out.println("총 "+inwon+"명 직원 검색됨");
		String sql="SELECT * FROM SAWON WHERE BUSEO =?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//db연결
		conn=db.getOracleConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//물음표 갯수만큼 바인딩
			pstmt.setString(1, buseo);
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
	
	public int getBuseoCount(String buseo)		//반환타입이 int //selectBuseo에서 얘를 호출할거임
	{
		int inwon=0;	//값을 받아오는게 try 내부이므로 초기화 필요
		String sql="SELECT COUNT(*) FROM SAWON WHERE BUSEO =?";
		//Statement 로 sql을 실행할때는 +변수+ 를 넣기위해 따옴표로 분리했어야했는데
		//prepared stmt 로 sql을 실행할때는 ?(물음표)로 바인딩하여 쉽게 할 수 있음
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//db연결
		conn=db.getOracleConnection();
		//pstmt
		try {
			pstmt=conn.prepareStatement(sql);	//실행x 검사O

			//? 갯수만큼 값을 넣어줘야함 : 바인딩
			//? 는 첫번째부터 차례대로 1, 2, 3 ... 순서로
			pstmt.setString(1, buseo);
			//실행
			rs=pstmt.executeQuery(); //반환타입이 Resultset 이므로 rs= 를 추가해서 반환값 넣어주기
			if(rs.next())	//next로 해야 1로 이동됨 // 값이 없을 수 있으므로 무조건 if해줘야함
				inwon=rs.getInt(1);	//어차피 컬럼이 하나뿐이라(count(*))의 인덱스 번호로 가져옴
									//여기서 받은 inwon 값을 밑에 return inwon; 으로 반환하게됨
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return inwon;
	}

	
	public static void main(String[] args) {

		Ex1_OraclePrepare ex=new Ex1_OraclePrepare();
		ex.selectBuseo();
		
		
		
		
		
		
	}

}
