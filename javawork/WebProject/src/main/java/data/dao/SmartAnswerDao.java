package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.SmartAnswerDto;
import db.DbConnect;

public class SmartAnswerDao {
	DbConnect db=new DbConnect();
	
	//insert
	public void insertAnswer (SmartAnswerDto dto)
	{
		String sql="insert into smartanswer (num,nickname,content,writeday) values (?,?,?,now())";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(conn, pstmt);	
		}
		
	}
	
	//출력
	public List<SmartAnswerDto> getAnswerList(String num)
	{
		List<SmartAnswerDto> list=new ArrayList<SmartAnswerDto>();
		String sql="select * from smartanswer where num="+num+" order by idx desc";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				//dto에 담기
				SmartAnswerDto dto=new SmartAnswerDto();
				
				dto.setNum(rs.getString("num"));
				dto.setIdx(rs.getString("idx"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//dto를 list에 담기
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
	
	//수정 시 나타낼 데이터
	public SmartAnswerDto getAnswerData(String idx)
	{
		SmartAnswerDto dto=new SmartAnswerDto();
		String sql="select * from smartanswer where idx="+idx;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				//dto에 담기
				dto.setNum(rs.getString("num"));
				dto.setIdx(rs.getString("idx"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
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
	
	//수정
	public void updateAnswer(SmartAnswerDto dto)
	{
		String sql="update smartanswer set nickname=?, content=? where idx=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getIdx());
			
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
	public void deleteAnswer(String idx)
	{
		String sql="delete from smartanswer where idx=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, idx);
			
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
