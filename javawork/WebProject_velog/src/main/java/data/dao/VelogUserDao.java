package data.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.VelogUserDto;
import db.DbConnect;

public class VelogUserDao {
	DbConnect db=new DbConnect();

	//insert user
	//insert data 게시글 작성
	public void insertUser(VelogUserDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into velog_user (username,userid,userpass,regdate) values (?,?,?,now())";
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getUserpass());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(conn, pstmt);
		}
				
	}
		
		
	//로그인 계정 체크
	public String logincheck(String userid, String userpass)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		//select 라서 ResultSet 필요
		ResultSet rs=null;
		
		String num=null;
		
		String sql="select num from velog_user where userid=? and userpass=?";
		
		//db연결
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, userid);
			pstmt.setString(2, userpass);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("num")!=null)
				{
					num=rs.getString("num");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt, rs);
		}

		return num;
	}
		
		//로그인 세션 관련
		public VelogUserDto getUser(String num)
		{
			VelogUserDto dto=new VelogUserDto();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			//select 라서 ResultSet 필요
			ResultSet rs=null;
			
			String sql="select * from velog_user where num=?";
			
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
					dto.setUserpass(rs.getString("userpass"));
					dto.setUsername(rs.getString("username"));
					dto.setUserid(rs.getString("userid"));
					dto.setComment(rs.getString("comment"));
					dto.setPimg(rs.getString("pimg"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(conn, pstmt, rs);
			}

			return dto;
		}
	
	
		//사용자 정보 수정용
		public VelogUserDto getUserInfo(String num)
		{
			VelogUserDto dto=new VelogUserDto();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			//select 라서 ResultSet 필요
			ResultSet rs=null;
			
			String sql="select * from velog_user where num=?";
			
			//db연결
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				
				//바인딩
				//pstmt.setString(1, userid);
				pstmt.setString(1, num);
				
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setNum(rs.getString("num"));
					dto.setUserpass(rs.getString("userpass"));
					dto.setUsername(rs.getString("username"));
					dto.setUserid(rs.getString("userid"));
					dto.setComment(rs.getString("comment"));
					dto.setPimg(rs.getString("pimg"));
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
		public void updateUser(VelogUserDto dto)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			String sql="update velog_user set username=?, userid=?, userpass=?, comment=?, pimg=? where num=?";
			
			conn=db.getMysqlConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getUsername());
				pstmt.setString(2, dto.getUserid());
				pstmt.setString(3, dto.getUserpass());
				pstmt.setString(4, dto.getComment());
				pstmt.setString(5, dto.getPimg());
				pstmt.setString(6, dto.getNum());
				
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
