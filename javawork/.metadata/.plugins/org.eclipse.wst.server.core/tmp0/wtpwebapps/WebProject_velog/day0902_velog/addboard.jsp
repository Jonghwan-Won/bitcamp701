<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dto" class="data.dto.VelogDto"/>
<jsp:useBean id="dao" class="data.dao.VelogDao"/>

<jsp:setProperty property="*" name="dto"/>
<%
	dao.insertData(dto);
%>