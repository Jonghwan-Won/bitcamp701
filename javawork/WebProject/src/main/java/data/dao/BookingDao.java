package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.BookingDto;
import db.DbConnect;

public class BookingDao {
	DbConnect db=new DbConnect();
	
	//insert
	public void insertBooking(BookingDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into booking values (null,?,?,?,?,?,?,?,now())";
		
		//db연결 mysql
		conn=db.getMysqlConnection();
		
		//pstmt 생성 - try&catch
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩 (물음표 순서, 값)
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getBookday());
			pstmt.setInt(4, dto.getInwon());
			pstmt.setString(5, dto.getFoodphoto());
			pstmt.setString(6, dto.getFoodprice());
			pstmt.setString(7, dto.getMessage());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
	}
	
	//전체 출력
	public List<BookingDto> getAllBookings()
	{
		List<BookingDto> list=new ArrayList<>();
		
		String sql="select * from booking order by num asc";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//db연결
		conn=db.getMysqlConnection();
		
		//pstmt생성
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				//db에서 가져와서 dto에 담기
				
				BookingDto dto=new BookingDto();
				//매번생성해야하기떄문에 반드시 반복문 안에서!
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBookday(rs.getString("bookday"));
				dto.setInwon(rs.getInt("inwon"));
				dto.setFoodphoto(rs.getString("foodphoto"));
				dto.setFoodprice(rs.getString("foodprice"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				dto.setMessage(rs.getString("message"));
				
				//list에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//num 에 해당하는 부킹정보 반환
	public BookingDto getBooking(String num)
	{
		BookingDto dto=new BookingDto();
		String sql="select * from booking where num=?";

		//connection 부터 finally 까지 복붙 (전체 출력)
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//db연결
		conn=db.getMysqlConnection();
		
		//pstmt생성
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			if(rs.next())	
				//num 에 해당하는 값만 가져올것이기때문에 while 반복할 필요 없음
				//그래서 list.add(dto) 도 필요없음
				
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBookday(rs.getString("bookday"));
				dto.setInwon(rs.getInt("inwon"));
				dto.setFoodphoto(rs.getString("foodphoto"));
				dto.setFoodprice(rs.getString("foodprice"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				dto.setMessage(rs.getString("message"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	//삭제 delete
	public void deleteBooking(String num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from booking where num=?";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);

			//바인딩 (첫번째 물음표에 어떤값)
			pstmt.setString(1, num);
			
			//실행
			pstmt.execute();
				// select는 pstmt.executequery
				// 개수를 알고싶으면 pstmt.executeupdate		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	//수정
		public void updateBooking(BookingDto dto)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="update booking set name=?,gender=?,bookday=?,inwon=?,foodphoto=?,foodprice=?,message=?,writeday=now() where num=?";
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);

				//바인딩 (첫번째 물음표에 어떤값)
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getGender());
				pstmt.setString(3, dto.getBookday());
				pstmt.setInt(4, dto.getInwon());
				pstmt.setString(5, dto.getFoodphoto());
				pstmt.setString(6, dto.getFoodprice());
				pstmt.setString(7, dto.getMessage());
				pstmt.setString(8, dto.getNum());
				
				//실행
				pstmt.execute();
					// select는 pstmt.executequery
					// 개수를 알고싶으면 pstmt.executeupdate		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(conn, pstmt);
			}
		}
}
