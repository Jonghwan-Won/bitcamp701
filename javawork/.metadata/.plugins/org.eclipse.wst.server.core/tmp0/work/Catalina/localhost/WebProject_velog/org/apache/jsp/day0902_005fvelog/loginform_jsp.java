/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-10-12 10:00:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.day0902_005fvelog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner&family=Gamja+Flower&family=Jua&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&family=Single+Day&family=Sunflower&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.0.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css\">\r\n");
      out.write("<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	*{\r\n");
      out.write("		font-family: 'Noto Sans KR';\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	body {\r\n");
      out.write("		background-color: #f5f5f5;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	div.a{\r\n");
      out.write("		margin: 150px auto;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	h2{\r\n");
      out.write("		font-family: 'sun flower';\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	div.head{\r\n");
      out.write("		font-family: 'Sunflower';\r\n");
      out.write("		margin-left: 92px;\r\n");
      out.write("		margin-top: 49px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	a {\r\n");
      out.write("		color: black;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	a:hover{\r\n");
      out.write("		color: black;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");

	//세션으로부터 아이디와 체크값을 얻는다
	String userid=(String)session.getAttribute("userid");
	String saveid=(String)session.getAttribute("saveid");
			
	boolean savechk=true;
	
	if(saveid==null || saveid.equals("no"))	//조건이 여러가지일경우 반드시 null조건을 먼저 쓴다
	{
		userid="";	//아이디저장을 체크하지 않은경우 아이디를 없앤다
		savechk=false;	//체크하지 않았을경우 false, 그 이외에는 초기값이 true이므로 true가 된다
		
		//조건부분을 간단하게하기위해 savechk 변수를 설정함 
	}

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"head\">\r\n");
      out.write("		<a class=\"navbar-brand\" href=\"boardlist.jsp\">\r\n");
      out.write("			<b style=\"font-size: 28px;\">devlog</b>\r\n");
      out.write("		</a>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"a\" style=\"width: 400px; height: 400px;\">\r\n");
      out.write("		<form action=\"loginaction.jsp\">\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<h2 style=\"color: black;\">Login</h2><br>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<label for=\"pwd\" class=\"form-label\">ID 입력:</label>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" autofocus=\"autofocus\" \r\n");
      out.write("				placeholder=\"ID를 입력해주세요\" name=\"userid\" required=\"required\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"mb-3\">\r\n");
      out.write("				<label for=\"pwd\" class=\"form-label\">비밀번호 :</label>\r\n");
      out.write("				<input type=\"password\" class=\"form-control\" placeholder=\"비밀번호를 입력해주세요\" \r\n");
      out.write("				name=\"userpass\" required=\"required\">\r\n");
      out.write("			</div>\r\n");
      out.write("			 ");
      out.write("\r\n");
      out.write("			<br>\r\n");
      out.write("			<button type=\"button\" class=\"btn btn-primary\"\r\n");
      out.write("			onclick=\"location.href='registerform.jsp'\" style=\"margin-right: 10px;\">회원가입</button>\r\n");
      out.write("			<button type=\"submit\" class=\"btn btn-success\" style=\"width: 300px\">로그인하기</button>\r\n");
      out.write("			\r\n");
      out.write("		</form>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
