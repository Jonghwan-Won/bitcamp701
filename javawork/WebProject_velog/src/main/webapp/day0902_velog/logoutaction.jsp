<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에서 loginok 제거 후
	/* session.invalidate()	//모든 세션이 제거되므로 사용하지않음 */
	session.removeAttribute("num");
	session.removeAttribute("userid");
	session.removeAttribute("loginok");
	
	//로그인 메인으로 이동
	response.sendRedirect("boardlist.jsp");
%>


<<script type="text/javascript">
	alert("로그아웃되었습니다");
</script>
