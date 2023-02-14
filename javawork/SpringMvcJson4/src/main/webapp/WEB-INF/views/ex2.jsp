<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	figure{
		float: left;
		margin-right: 5px;
		border: 1px solid gray; 
	}

</style>
</head>
<body>
	<div style="margin:50px 50px;">
		<h3 class="alert alert-dark">Ex2번 예제</h3>
		<br>
		<button type="button" id="btn1" class="btn btn-dark btn-lg">/list2 json데이터 출력하기</button>
		<div id="out1">
		
		</div>
	</div>
	
	<script type="text/javascript">
		$("#btn1").click(function () {
			$.ajax({
				type:"get",
				dataType:"json",
				url:"list2",
				success:function(res){

					var s="";
					
					$.each(res, function (i, element) {
						s+="<figure>";
						s+="<img src='upload/"+element.photo+"' width=200>";
						s+="<figcaption><b>";
						s+=element.name;
						s+="</b></figcaption>";
						s+="</figure>";
					});
					$("#out1").html(s);
				}
				
			});
		});
	</script>
	
	</div>
</body>
</html>