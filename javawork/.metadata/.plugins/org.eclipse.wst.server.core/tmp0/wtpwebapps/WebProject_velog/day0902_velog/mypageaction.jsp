<%@page import="data.dto.VelogUserDto"%>
<%@page import="data.dao.VelogUserDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
			//session num 정보 가져오기
			//String snum=(String)session.getAttribute("num");

			//pimg(프로필사진)가 업로드될 폴더(userphoto)
			String realFolder=getServletContext().getRealPath("/userphoto");
			System.out.println(realFolder);	//콘솔로 이클립스 내 톰캣위치에 저장된 save 확인
			
			//업로드할 이미지의 크기
			int uploadSize=1024*1024*10;	//10mb
			
			//cos.jar -> lib에 넣어줘야 사용할 수 있음
			MultipartRequest multiRequest=null;
			
			try{
				//DefaultFileRenamePolicy: 같은 이름으로 업로드할 경우 자동으로 이름을 변경해줌
				multiRequest=new MultipartRequest(request,realFolder,uploadSize,
						"utf-8",new DefaultFileRenamePolicy());
				
				//dao 선언
				VelogUserDao dao=new VelogUserDao();
				
				//mypage update에서 넘어온 form 정보 변수에 담기
				String num=multiRequest.getParameter("num");
				String username=multiRequest.getParameter("username");
				String userid=multiRequest.getParameter("userid");
				String userpass=multiRequest.getParameter("userpass");
				String comment=multiRequest.getParameter("comment");
				
				//user num에 해당하는 기존 메인사진 얻기
				String oldphoto=dao.getUserInfo(num).getPimg();
				System.out.println("oldphoto="+oldphoto);
				
				//pimg(프로필사진)은 업로드된 파일명으로 저장
				String pimg=multiRequest.getFilesystemName("pimg");	//getParameter 안됨 
				System.out.println("pimg="+pimg);
				
				//dto에 저장
				VelogUserDto dto=new VelogUserDto();
				dto.setNum(num);
				dto.setUsername(username);
				dto.setUserid(userid);
				dto.setUserpass(userpass);
				dto.setComment(comment);
				dto.setPimg(pimg);
				
				//메인사진은 선택을 안했을경우 기존사진으로 보낸다
				if(pimg==null)
					dto.setPimg(oldphoto);
				else
					dto.setPimg(pimg);
				
				//update
				dao.updateUser(dto);
				
				
				
				//boardlist.jsp로 이동
				response.sendRedirect("boardlist.jsp");
				
			}
			catch(Exception e){
				System.out.println("업로드 오류:"+e.getMessage());
			} 
			

%>