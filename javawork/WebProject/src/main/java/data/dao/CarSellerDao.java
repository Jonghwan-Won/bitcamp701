package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.CarsellerDto;
import data.dto.SimpleBoardDto;
import db.DbConnect;

public class CarSellerDao {
	
	//db연결
	DbConnect db=new DbConnect();
	
	//게시글 리스트
	public List<CarsellerDto> getAllDatas(){
		
		List<CarsellerDto> list=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from carseller order by num desc";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				//dto에 담기위해 선언
				CarsellerDto dto=new CarsellerDto();
				
				dto.setNum(rs.getString("num"));
				dto.setChkbox(rs.getString("chkbox"));
				dto.setWriter(rs.getString("writer"));
				dto.setPass(rs.getString("pass"));
				dto.setCarname(rs.getString("carname"));
				dto.setCarcolor(rs.getString("carcolor"));
				dto.setCaryear(rs.getString("caryear"));
				dto.setCarprice(rs.getInt("carprice"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 추가
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		//list 반환
		return list;	
	}

	
	//전체갯수(int) 반환
			public int getTotalCount() 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				//select 문이므로 ResultSet 필요
				ResultSet rs=null;
				int total=0;
				
				String sql="select count(*) from carseller";
				
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						total=rs.getInt(1); //1번 열( count(*) )의 값을 가져와서 total에 초기화
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt, rs);
				}
				return total;
			}
			
			//체크갯수(int) 반환
			public int getChkCount() 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				//select 문이므로 ResultSet 필요
				ResultSet rs=null;
				int chktotal=0;
				
				String sql="select count(*) from carseller where chkbox=1";
				
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						chktotal=rs.getInt(1); //1번 열( count(*) )의 값을 가져와서 total에 초기화
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt, rs);
				}
				return chktotal;
			}
			
			
			//num 에 해당하는 DTO 반환 (게시글 상세)
			public CarsellerDto getContent(String num)
			{
				CarsellerDto dto=new CarsellerDto();
				
				Connection conn=null;
				PreparedStatement pstmt=null;
				//select 라서 ResultSet 필요
				ResultSet rs=null;
				
				String sql="select * from carseller where num=?";
				
				//db연결
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					
					//바인딩
					pstmt.setString(1, num);
					
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
						dto.setNum(rs.getString("num"));
						dto.setWriter(rs.getString("writer"));
						dto.setPass(rs.getString("pass"));
						dto.setCarname(rs.getString("carname"));
						dto.setCaryear(rs.getString("caryear"));
						dto.setCarcolor(rs.getString("carcolor"));
						dto.setContent(rs.getString("content"));
						dto.setReadcount(rs.getInt("readcount"));
						dto.setWriteday(rs.getTimestamp("writeday"));

					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt, rs);
				}

				return dto;
			}
			
			//insert (select 처럼 값을 보여주는(=반환하는)게 아니라 삽입이므로 반환타입은 void(반환없음))
			public void insertBoard(CarsellerDto dto)	//SimpleBoardDto 를 받아서 저장할것이므로
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				String sql="insert into carseller"
						+ "(writer, pass, carname, carcolor, caryear, carprice, content, readcount, writeday)\r\n"
						+ "values(?,?,?,?,?,?,?,0,now())";
				
				//db연결
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					
					//바인딩 (물음표의 위치, dto에서 가져올 값)
					pstmt.setString(1, dto.getWriter());
					pstmt.setString(2, dto.getPass());
					pstmt.setString(3, dto.getCarname());
					pstmt.setString(4, dto.getCarcolor());
					pstmt.setString(5, dto.getCaryear());
					pstmt.setInt(6, dto.getCarprice());
					pstmt.setString(7, dto.getContent());
					
					//실행
					pstmt.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt);
				}
				
				
			}
			
			
			//select max(num) max from simpleboard
			//가장 최근에 추가된 글의 num값 얻기 
			//새글 저장할때 목록이아닌 이 글의 상세 view화면으로 넘어가기위한 작업
			public int getMaxNum()
			{
				int max=0;
				
				String sql="select max(num) max from carseller";
				
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
					max=rs.getInt("max");
//					max=rs.getInt(1); //어차피 count(*) 조회하면 1번열 하나만나오므로 열번호 1 만 써도됨
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt, rs);
				}
				
				return max;
			}
			
			//readcount update
			//update 는 반환하지않기때문에 반환타입은 void
			public void updateReadCount(String num)	//String num ? : 특정 num에 대해 readcount 세어야하기때문 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				String sql="update carseller set readcount=readcount+1 where num=?";
				
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					//바인딩
					pstmt.setString(1, num);
					
					pstmt.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt);
				}
				
			}
			
			//관심글 chkbox 값 update
			public void updateChkBox(String num)	//String num ? : 특정 num에 대해 readcount 세어야하기때문 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				String sql="update carseller set chkbox=1 where num=?";
				
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					//바인딩
					pstmt.setString(1, num);
					
					pstmt.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt);
				}
				
			}
			
			//관심글 체크된 데이터 보여주기
			public List<CarsellerDto> getChkDatas(){
				
				List<CarsellerDto> list=new ArrayList<>();
				
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
			
				String sql="select * from carseller where chkbox=1 order by num desc";
				
				conn=db.getMysqlConnection();
				try {
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					
					while(rs.next())
					{
						//dto에 담기위해 선언
						CarsellerDto dto=new CarsellerDto();
						
						dto.setNum(rs.getString("num"));
						dto.setChkbox(rs.getString("chkbox"));
						dto.setWriter(rs.getString("writer"));
						dto.setPass(rs.getString("pass"));
						dto.setCarname(rs.getString("carname"));
						dto.setCarcolor(rs.getString("carcolor"));
						dto.setCaryear(rs.getString("caryear"));
						dto.setCarprice(rs.getInt("carprice"));
						dto.setContent(rs.getString("content"));
						dto.setReadcount(rs.getInt("readcount"));
						dto.setWriteday(rs.getTimestamp("writeday"));
						
						//list에 추가
						list.add(dto);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(conn, pstmt, rs);
				}
				
				//list 반환
				return list;	
			}
				
}