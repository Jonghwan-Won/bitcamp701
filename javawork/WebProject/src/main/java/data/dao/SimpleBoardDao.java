package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import data.dto.SimpleBoardDto;
import db.DbConnect;

public class SimpleBoardDao {
	DbConnect db=new DbConnect();
	
	//전체 조회
	public List<SimpleBoardDto> getAllDatas()
	{
		List<SimpleBoardDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		//select 라서 ResultSet 필요
		ResultSet rs=null;
		
		String sql="select * from simpleboard order by num desc";
		//desc : 게시글은 최신글이 맨위로오기때문
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				SimpleBoardDto dto=new SimpleBoardDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setPass(rs.getString("pass"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setSubject(rs.getString("subject"));
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
	
	//부분 조회(startNum 부터 perPage 갯수만큼만 반환)
		public List<SimpleBoardDto> getPagingList(int startNum, int perPage)
		{
			List<SimpleBoardDto> list=new ArrayList<>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			//select 라서 ResultSet 필요
			ResultSet rs=null;
			
			String sql="select * from simpleboard order by num desc limit ?,?";
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
					SimpleBoardDto dto=new SimpleBoardDto();
					dto.setNum(rs.getString("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setPass(rs.getString("pass"));
					dto.setContent(rs.getString("content"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setSubject(rs.getString("subject"));
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
	
	//num 에 해당하는 DTO 반환 (게시글 상세)
	public SimpleBoardDto getContent(String num)
	{
		SimpleBoardDto dto=new SimpleBoardDto();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//select 라서 ResultSet 필요
		ResultSet rs=null;
		
		String sql="select * from simpleboard where num=?";
		
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
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setSubject(rs.getString("subject"));
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
	public void insertBoard(SimpleBoardDto dto)	//SimpleBoardDto 를 받아서 저장할것이므로
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
//		String sql="insert into simpleboard values (null,?,?,?,?,0,now())";
		String sql="insert into simpleboard (writer,pass,subject,content,readcount,writeday) values (?,?,?,?,0,now())";
		
		//db연결
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩 (물음표의 위치, dto에서 가져올 값)
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);
		}
		
		
	}
	
	//readcount update
	//update 는 반환하지않기때문에 반환타입은 void
	public void updateReadCount(String num)	//String num ? : 특정 num에 대해 readcount 세어야하기때문 
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="update simpleboard set readcount=readcount+1 where num=?";
		
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
	
		//전체갯수(int) 반환
		public int getTotalCount() 
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			//select 문이므로 ResultSet 필요
			ResultSet rs=null;
			int total=0;
			
			String sql="select count(*) from simpleboard";
			
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
		
		//select max(num) max from simpleboard
		//가장 최근에 추가된 글의 num값 얻기 
		//새글 저장할때 목록이아닌 이 글의 상세 view화면으로 넘어가기위한 작업
		public int getMaxNum()
		{
			int max=0;
			
			String sql="select max(num) max from simpleboard";
			
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
//				max=rs.getInt(1); //어차피 count(*) 조회하면 1번열 하나만나오므로 열번호 1 만 써도됨
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(conn, pstmt, rs);
			}
			
			return max;
		}
		
		//select count(*) from simpleboard where num=2 and pass='1234'
		//비밀번호가 맞는지 체크하는 메서드
		public boolean isPassCheck(String num,String pass)
		{
			boolean check=false;

			String sql="select count(*) from simpleboard where num=? and pass=?";
			//num과 pass가 일치하면 count가 1(true) 불일치하면 0 (false)
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, num);
				pstmt.setString(2, pass);
				
				//실행
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					//초기값이 false 이므로 else는 주지않아도됨
					if(rs.getInt(1)==1)	
						//getInt( ) : 열번호 (=count(*))
						//비번 틀릴경우 0
						check=true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return check;
		}
		
		//수정
		public void updateBoard(SimpleBoardDto dto)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			String sql="update simpleboard set writer=?, subject=?, content=? where num=?";
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
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
		
		//삭제
		public void deleteBoard(String num)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			String sql="delete from simpleboard where num=?";
			
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
