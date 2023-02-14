package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data.dto.SmartDto;
import db.DbConnect;

public class SmartDao {
	DbConnect db=new DbConnect();
	
	//all list
	//webproject - day0831 에서 jsonsmartbbs.jsp 만들때 만들어줌
		public List<SmartDto> getAllList()
		{
			List<SmartDto> list=new ArrayList<>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			//select 라서 ResultSet 필요
			ResultSet rs=null;
			
			String sql="select * from smartbbs order by num desc";
			//desc : 게시글은 최신글이 맨위로오기때문
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
								
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					SmartDto dto=new SmartDto();
					dto.setNum(rs.getString("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setMainphoto(rs.getString("mainphoto"));
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
			
			return list;
				
		}
	
	//insert
	public void insertSmart(SmartDto dto)
	{
		String sql="insert into smartbbs (writer,subject,content,mainphoto,writeday) values (?,?,?,?,now())";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getMainphoto());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
		
	}
	
	//paging list
	public List<SmartDto> getPagingList(int startNum,int perPage)
	{
		List<SmartDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		//select 라서 ResultSet 필요
		ResultSet rs=null;
		
		String sql="select * from smartbbs order by num desc limit ?,?";
		//desc : 게시글은 최신글이 맨위로오기때문
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, perPage);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				SmartDto dto=new SmartDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setMainphoto(rs.getString("mainphoto"));
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
		
		return list;
			
	}
	
	//전체갯수 반환
	public int getTotalCount()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int total=0;
		
		String sql="select count(*) from smartbbs";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				total=rs.getInt(1);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, null);
		}
		return total;
	}
	
	//가장 최근에 추가된 글의 num값 얻기
	public int getMaxNum()
	{
		int max=0;
		
		String sql="select max(num) max from smartbbs";
		
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
//			max=rs.getInt(1); //어차피 count(*) 조회하면 1번열 하나만나오므로 열번호 1 만 써도됨
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}
		
		return max;
	}
	
	//one select
	public SmartDto getData(String num)
	{
		SmartDto dto=new SmartDto();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//select 라서 ResultSet 필요
		ResultSet rs=null;
		
		String sql="select * from smartbbs where num=?";
		
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
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setMainphoto(rs.getString("mainphoto"));
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
	
	//readcount update
	public void updateReadCount(String num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update smartbbs set readcount=readcount+1 where num=?";
		
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
	
	//update
	public void updateSmart(SmartDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update smartbbs set writer=?, subject=?, content=?, mainphoto=? where num=?";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getMainphoto());
			pstmt.setString(5, dto.getNum());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
	}
	
	//delete
	public void deleteSmart(String num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="delete from smartbbs where num=?";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
	}
}
