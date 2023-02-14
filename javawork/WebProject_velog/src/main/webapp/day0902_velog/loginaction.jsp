<%@page import="data.dao.VelogUserDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String userid = request.getParameter("userid");
	String userpass	= request.getParameter("userpass");
	String saveid=request.getParameter("saveid");	//체크박스 on or null
	
	VelogUserDao dao = new VelogUserDao();
	
	String num=dao.logincheck(userid, userpass);
	
	
	if(num!=null){
		//세션 유지시간을 1시간으로 설정하고
		session.setMaxInactiveInterval(60*60*1);
	
		session.setAttribute("num", num);
		session.setAttribute("userid", userid);
		session.setAttribute("loginok", "yes");
		session.setAttribute("saveid", saveid==null?"no":"yes");	/* check안하면 no */
	
	
		// 세션 저장 후 메인으로 이동
		response.sendRedirect("boardlist.jsp");
	} else {
	%>
		<script>
			alert("ID와 비밀번호를 다시 확인해주세요");
			history.back();
		</script>
	<%	
	}	
%>