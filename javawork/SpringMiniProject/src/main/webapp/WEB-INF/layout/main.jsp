<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
* {
	font-family: 'Jua';
}
</style>

<script type="text/javascript">

/* 
$(function () {

	$.ajax({
		type:"get",
		url:"/mini/resources/terms/htmltest.html",
		dataType:"html",
		success:function(res){
			
			$("#my_div").html(res);
			
			//const element = document.getElementById('my_div');
			//element.innerHTML = res;
			
		}
		
	});
	
});
 */

 
 
 $(document).ready(function(){
	 
	 $.ajax({
			type:"get",
			url:"/mini/resources/terms/sampleterm.jsp",
			dataType:"html",
			async: false,
			success:function(res){
				
				$("#my_div").html(res);
				
				//const element = document.getElementById('my_div');
				//element.innerHTML = res;
				
			}
			
		});
	 
	});
	
</script>
</head>
<body>

	<h1>main 화면</h1>
	<div id='my_div'>
	
	</div>


</body>
</html>