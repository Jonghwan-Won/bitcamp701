<%@page import="data.dto.VelogDto"%>
<%@page import="data.dao.VelogDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		//업로드할 폴더
		String realFolder=getServletContext().getRealPath("/save");
		//System.out.println(realFolder);	//콘솔로 이클립스 내 톰캣위치에 저장된 save 확인
	
		//업로드할 이미지의 크기
		int uploadSize=1024*1024*10;	//5mb
		
		//cos.jar -> lib에 넣어줘야 사용할 수 있음
		MultipartRequest multiRequest=null;
		
		try{
			//DefaultFileRenamePolicy: 같은 이름으로 업로드할 경우 자동으로 이름을 변경해줌
			multiRequest=new MultipartRequest(request,realFolder,uploadSize,
					"utf-8",new DefaultFileRenamePolicy());
			
			//dao 선언
			VelogDao dao=new VelogDao();
					
			String num=multiRequest.getParameter("num");
			//num에 해당하는 기존 메인사진 얻기
			String oldphoto=dao.getData(num).getMainphoto();
					
			//String writer=multiRequest.getParameter("writer");
			String subject=multiRequest.getParameter("subject");
			String content=multiRequest.getParameter("content");
			
			//메인사진은 업로드된 파일명으로 저장
			String mainphoto=multiRequest.getFilesystemName("mainphoto");	//getParameter 안됨 
			System.out.println("mainphoto="+mainphoto);
			
			//dto에 저장
			VelogDto dto=new VelogDto();
			dto.setNum(num);
			//dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			
			//메인사진은 선택을 안했을경우 기존사진으로 보낸다
			if(mainphoto==null)
				dto.setMainphoto(oldphoto);
			else
				dto.setMainphoto(mainphoto);
			
			//update
			dao.updateboard(dto);
			
			//contentview.jsp로 이동
			response.sendRedirect("contentview.jsp?num="+num);
			
		}
		catch(Exception e){
			System.out.println("업로드 오류:"+e.getMessage());
		} 
		
%>