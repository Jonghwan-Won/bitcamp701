<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.VelogDto"%>
<%@page import="data.dao.VelogDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String subject=request.getParameter("subject");

	/* String subject="테스트"; */
	
	
	
	VelogDao dao=new VelogDao();
	
	//검색한 상품만 얻기
	List<VelogDto> list=dao.getSearchboard(subject);
	
	//json 배열 선언
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	for(VelogDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("writer",dto.getWriter());
		ob.put("subject",dto.getSubject());
		ob.put("mainphoto","../save/"+dto.getMainphoto());
		//ob.put("readcount",dto.getReadcount());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		//배열에 추가
		arr.add(ob);
	}

%>

<%= arr.toString()%>