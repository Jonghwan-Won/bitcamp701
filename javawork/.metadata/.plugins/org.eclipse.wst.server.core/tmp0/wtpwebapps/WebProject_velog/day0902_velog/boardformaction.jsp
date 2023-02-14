<%@page import="data.dao.VelogUserDao"%>
<%@page import="data.dto.VelogUserDto"%>
<%@page import="data.dao.VelogDao"%>
<%@page import="data.dto.VelogDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		//mainphoto가 업로드될 폴더
		String realFolder=getServletContext().getRealPath("/save");
		System.out.println(realFolder);	//콘솔로 이클립스 내 톰캣위치에 저장된 save 확인
	
		//업로드할 이미지의 크기
		int uploadSize=1024*1024*10;	//10mb
		
		//cos.jar -> lib에 넣어줘야 사용할 수 있음
		MultipartRequest multiRequest=null;
		
		try{
			//DefaultFileRenamePolicy: 같은 이름으로 업로드할 경우 자동으로 이름을 변경해줌
			multiRequest=new MultipartRequest(request,realFolder,uploadSize,
					"utf-8",new DefaultFileRenamePolicy());
			
			//폼데이터 읽기
			String subject=multiRequest.getParameter("subject");
			String num=multiRequest.getParameter("num");
			String content=multiRequest.getParameter("content");
			
			//메인사진은 업로드된 파일명으로 저장
			String mainphoto=multiRequest.getFilesystemName("mainphoto");	//getParameter 안됨 
			
			//dto에 저장
			VelogDto dto=new VelogDto();
			
			VelogUserDao userdao=new VelogUserDao();
			VelogUserDto userdto=userdao.getUser(num);
			
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setWriter(userdto.getUserid());
			dto.setMainphoto(mainphoto);
			
			//dao 선언
			VelogDao dao=new VelogDao();
			
			//insert
			dao.insertData(dto);
			
			//boardlist.jsp로 이동
			response.sendRedirect("boardlist.jsp");
			
		}
		catch(Exception e){
			System.out.println("업로드 오류:"+e.getMessage());
		} 
		
%>