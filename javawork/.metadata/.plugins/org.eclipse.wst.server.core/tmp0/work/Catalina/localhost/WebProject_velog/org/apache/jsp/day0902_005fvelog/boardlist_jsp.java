/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-10-11 10:35:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.day0902_005fvelog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import data.dto.VelogUserDto;
import data.dao.VelogUserDao;
import java.text.SimpleDateFormat;
import data.dto.VelogDto;
import java.util.List;
import data.dao.VelogDao;

public final class boardlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("data.dao.VelogUserDao");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("data.dto.VelogDto");
    _jspx_imports_classes.add("data.dto.VelogUserDto");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("data.dao.VelogDao");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner&family=Gamja+Flower&family=Jua&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&family=Single+Day&family=Sunflower&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.0.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	*{\r\n");
      out.write("		font-family: 'Noto Sans KR';\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	nav{\r\n");
      out.write("		background-color: #f5f5f5;\r\n");
      out.write("		/* border-bottom: 1px solid gray; */\r\n");
      out.write("		height: 150px;\r\n");
      out.write("		padding-left: 80px;\r\n");
      out.write("		padding-right: 18.5%;\r\n");
      out.write("	}\r\n");
      out.write("	a{\r\n");
      out.write("		color: black;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	a:hover{\r\n");
      out.write("		color: black;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	body {\r\n");
      out.write("		margin-left: 80px;\r\n");
      out.write("		background-color: #f5f5f5;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	div.totcount{\r\n");
      out.write("		width: 80%;\r\n");
      out.write("		height: 45px;\r\n");
      out.write("		color: black;\r\n");
      out.write("		font-size: 15px;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		border-bottom: 1px solid gray;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	ul.board{\r\n");
      out.write(" 		display: flex;\r\n");
      out.write(" 	}\r\n");
      out.write(" 	\r\n");
      out.write(" 	ul.board li{\r\n");
      out.write(" 		list-style: none;\r\n");
      out.write(" 		text-align: center;\r\n");
      out.write(" 		margin-right: 35px;\r\n");
      out.write(" 		margin-bottom: 20px;\r\n");
      out.write(" 		cursor: pointer;\r\n");
      out.write(" 		background-color:white;\r\n");
      out.write(" 		\r\n");
      out.write(" 		\r\n");
      out.write(" 		width: 300px;\r\n");
      out.write(" 		height: 400px;\r\n");
      out.write(" 		border: 1px solid lightgray;\r\n");
      out.write(" 		border-radius: 10px; \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	ul.board li:hover{\r\n");
      out.write(" 		box-shadow: 5px 5px 5px lightgray;\r\n");
      out.write(" 		\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.txt_line{\r\n");
      out.write("		text-overflow:ellipsis;\r\n");
      out.write("		overflow: hidden;\r\n");
      out.write("		white-space: nowrap;\r\n");
      out.write("		display: block;\r\n");
      out.write("		max-width: 260px;\r\n");
      out.write("		padding-left: 40px;\r\n");
      out.write("		border-radius: \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#writepost{\r\n");
      out.write("		/* visibility: hidden; */\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	div.dropdown>button{\r\n");
      out.write("		border: none;\r\n");
      out.write("		background-color: transparent;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	//dao 선언
	VelogDao dao=new VelogDao();


	//dto list에 담아둔 getAllData 가져오기
	List<VelogDto> list=dao.getAllData();
	
	//날짜형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	//totalCount 가져오기
	int totalCount=dao.getTotalCount();
	
	
	
	//로그인 성공했을때 세션 가져오기 *(String)으로 형변환 필요
	String num=(String)session.getAttribute("num");
	
	//user정보 가져오기
	VelogUserDao userdao=new VelogUserDao();
	VelogUserDto userdto=userdao.getUser(num);
	
	

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<nav class=\"navbar navbar-expand-sm fixed-top\">\r\n");
      out.write("	  <div class=\"container-fluid\">\r\n");
      out.write("	    <a class=\"navbar-brand\" href=\"boardlist.jsp\"><h3><b>devlog</b></h3></a>\r\n");
      out.write("	    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#mynavbar\">\r\n");
      out.write("	      <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("	    </button>\r\n");
      out.write("	    <div class=\"collapse navbar-collapse\" id=\"mynavbar\">\r\n");
      out.write("	      \r\n");
      out.write("	      <ul class=\"navbar-nav me-auto\">\r\n");
      out.write("\r\n");
      out.write("	      </ul>\r\n");
      out.write("	      <form class=\"d-flex\">\r\n");
      out.write("	      ");
if(num==null) {
      out.write("\r\n");
      out.write("	      	<div>\r\n");
      out.write("		      	<button class=\"btn btn-dark\" type=\"button\" id=\"btnsearch\" onclick=\"location.href='searchboard.html'\">\r\n");
      out.write("		      	<i class=\"bi bi-search\"></i> 검색</button>&nbsp;&nbsp;\r\n");
      out.write("		        <button class=\"btn btn-primary\" type=\"button\" id=\"btnlogin\" onclick=\"location.href='loginform.jsp'\">로그인</button>&nbsp;&nbsp;\r\n");
      out.write("	        </div>\r\n");
      out.write("	        ");
}else{ 
      out.write("\r\n");
      out.write("	        <div style=\"display: flex; justify-content: flex-end;\">\r\n");
      out.write("	       		<button class=\"btn btn-dark\" type=\"button\" id=\"btnsearch\" onclick=\"location.href='searchboard.html'\">\r\n");
      out.write("		        <i class=\"bi bi-search\"></i> 검색</button>&nbsp;&nbsp;\r\n");
      out.write("	       		\r\n");
      out.write("	       		<button type=\"button\" class=\"btn btn-success\" style=\"float: right;\"\r\n");
      out.write("					onclick=\"location.href='boardform.jsp'\" id=\"writepost\">\r\n");
      out.write("					<i class=\"bi bi-pencil\"></i> 글쓰기</button>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("		        </div>\r\n");
      out.write("		        \r\n");
      out.write("		        <div class=\"dropdown\">\r\n");
      out.write("		        	<button type=\"button\" class=\"dropdown-toggle\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("				        <img src=\"../userphoto/");
      out.print(userdto.getPimg() );
      out.write("\" width=\"37\" height=\"37\" style=\"border-radius:50px;\">\r\n");
      out.write("				        <span>");
      out.print(userdto.getUsername() );
      out.write("님</span>\r\n");
      out.write("\r\n");
      out.write("				    </button>\r\n");
      out.write("				    \r\n");
      out.write("				    <ul class=\"dropdown-menu\" style=\"padding-left: 5px;\">\r\n");
      out.write("				    	<li><a class=\"dropdown-item\" href=\"mypageupdate.jsp\">\r\n");
      out.write("				    	<i class=\"bi bi-pencil-square\"></i> 내 정보수정</a></li>\r\n");
      out.write("				    	<li><a class=\"dropdown-item\" href=\"myboard.jsp\">\r\n");
      out.write("				    	<i class=\"bi bi-list\"></i> 내 게시글</a></li>\r\n");
      out.write("				    	<li><a class=\"dropdown-item\" href=\"logoutaction.jsp\">\r\n");
      out.write("				    	<i class=\"bi bi-door-open\"></i> 로그아웃</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("		        </div>\r\n");
      out.write("\r\n");
      out.write("		        <!-- <button class=\"btn btn-danger\" type=\"button\" id=\"btnlogout\" \r\n");
      out.write("		        onclick=\"location.href='logoutaction.jsp'\">로그아웃</button> -->\r\n");
      out.write("	      \r\n");
      out.write("	        ");
} 
      out.write("\r\n");
      out.write("	      </form>\r\n");
      out.write("	    </div>\r\n");
      out.write("	  </div>\r\n");
      out.write("	</nav>\r\n");
      out.write("	\r\n");
      out.write("	<div style=\"margin-top: 180px; height: 1000px;\">\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"totcount\">\r\n");
      out.write("		<span>총 ");
      out.print(dao.getTotalCount() );
      out.write(" 개의 게시글이 있습니다</span>\r\n");
      out.write("		<!-- <button type=\"button\" class=\"btn btn-dark\" style=\"float: right;\"\r\n");
      out.write("		onclick=\"location.href='boardform.jsp'\">글쓰기</button><br> -->\r\n");
      out.write("		</div><br>\r\n");
      out.write("			\r\n");
      out.write("	    <div>\r\n");
      out.write("	    	\r\n");
      out.write("		    <ul class=\"board\">\r\n");
      out.write("		    ");
 for(int i=0;i<list.size();i++){ 
		    	VelogDto dto=list.get(i);
		    	
      out.write("\r\n");
      out.write("				<li class=\"posting\">\r\n");
      out.write("					<a href=\"contentview.jsp?num=");
      out.print(dto.getNum());
      out.write("\">\r\n");
      out.write("					<br>\r\n");
      out.write("					<img src=\"../save/");
      out.print(dto.getMainphoto());
      out.write("\" \r\n");
      out.write("					 onerror=\"this.onerror=null; this.src='../image/noimage.png'\"\r\n");
      out.write("					 width=\"250\" height=\"200\" style=\"border:1px solid lightgray; border-radius: 10px;\">\r\n");
      out.write("					<br><br>\r\n");
      out.write("					<h5><b class=\"txt_line\">");
      out.print(dto.getSubject() );
      out.write("</b></h5><br><br>\r\n");
      out.write("					");
      out.write("\r\n");
      out.write("					<b>");
      out.print(sdf.format(dto.getWriteday()));
      out.write("</b><br>\r\n");
      out.write("					<b style=\"font-size: 15px;\">");
      out.print(dto.getWriter() );
      out.write("</b>\r\n");
      out.write("					</a>\r\n");
      out.write("				</li>\r\n");
      out.write("			");

			if((i+1)%4==0){ 
      out.write("\r\n");
      out.write("				</ul><ul class=\"board\">\r\n");
      out.write("		    ");
 }
			
		    } 
      out.write("\r\n");
      out.write("	        </ul>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}