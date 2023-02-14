package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import data.dto.VelogDto;
import db.DbConnect;

public class VelogDao {
	//jdbc db연결을 위한 dbconnect 선언
	DbConnect db=new DbConnect();
	
	//게시글목록 boardlist
	public List<VelogDto> getAllData()
	{
		//변수선언
		List<VelogDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//sql
		String sql="select * from velog_board order by num desc";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				VelogDto dto=new VelogDto();
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
		} finally {
			db.dbClose(conn, pstmt, rs);
		}
		return list;
	}	
	
	
	//게시글 갯수 구하기
	public int getTotalCount()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int total=0;
		
		//sql
		String sql="select count(*) from velog_board";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				//sql문 결과의 1번 컬럼의 값을 total에 넣기
				total=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt, rs);
		}

		return total;
		
	}
	
	//insert data 게시글 작성
	public void insertData(VelogDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into velog_board (writer,subject,content,mainphoto,writeday) values (?,?,?,?,now())";
		
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
		} finally {
			db.dbClose(conn, pstmt);
		}
				
	}

	//조회수 증가 update
	public void updateReadCount(String num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update velog_board set readcount=readcount+1 where num=?";
		
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
	
		//detail view
		public VelogDto getData(String num)
		{
			VelogDto dto=new VelogDto();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			//select 라서 ResultSet 필요
			ResultSet rs=null;
			
			String sql="select * from velog_board where num=?";
			
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
	
		//update
		public void updateboard(VelogDto dto)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			String sql="update velog_board set subject=?, content=?, mainphoto=? where num=?";
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				//pstmt.setString(1, dto.getWriter());
				pstmt.setString(1, dto.getSubject());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getMainphoto());
				pstmt.setString(4, dto.getNum());
				
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
		public void deleteboard(String num)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			String sql="delete from velog_board where num=?";
			
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
		
		//제목으로 조회
		public List<VelogDto> getSearchboard(String subject)
		{
			List<VelogDto> list=new Vector<>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			String sql="select * from velog_board where subject like ? order by num desc";

			//db연결
			conn=db.getMysqlConnection();

			//pstmt 생성
			try {
				pstmt=conn.prepareStatement(sql);
				
				//execute하기전에 바인딩
				pstmt.setString(1, "%"+subject+"%");
				
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					//db에서 가져와서 dto에 담기
					VelogDto dto=new VelogDto();
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
		
		//내가 작성한 게시글 목록
		public List<VelogDto> getMyData(String writer)
		{
			//변수선언
			List<VelogDto> list=new ArrayList<>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			//sql
			String sql="select * from velog_board where writer=? order by num desc";
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setString(1, writer);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					VelogDto dto=new VelogDto();
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
			} finally {
				db.dbClose(conn, pstmt, rs);
			}
			return list;
		}	
		
		//myboard 본인작성 게시글 갯수 구하기
		public int getMyBoardCount(String writer)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int total=0;
			
			//sql
			String sql="select count(*) from velog_board where writer=?";
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setString(1, writer);
				
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					//sql문 결과의 1번 컬럼의 값을 total에 넣기
					total=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(conn, pstmt, rs);
			}

			return total;
			
		}
		
}
