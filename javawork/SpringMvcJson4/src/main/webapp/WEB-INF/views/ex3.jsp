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

</style>
</head>
<body>
	<div style="margin:50px 50px;">
		<h3 class="alert alert-dark">Ex3번 예제</h3>
		<br>
		<h4>메뉴 이름을 입력 후 엔터를 눌러주세요</h4>
		<b style="color: gray; font-weight: normal;">* 검색어 보기 : 개운해 / 나무늘보 / 냐 / 파이리</b><br>
		<p style="color: gray;">* 보기에 없는 단어 입력 시 다른 사진 출력</p>
		
		<input type="text" id="search" class="form-control" style="width: 130px;">
		<br><br>
		
		<h2 id="fname"></h2>
		<img src="" id="photo">
		
		<script type="text/javascript">
			
			//메뉴명을 입력 후 엔터를 누를때 출력하기
			$("#search").keyup(function (e) {
				if(e.keyCode==13){	//아스키코드 13 --> 엔터
					
					//입력값
					var name=$(this).val();
					
					$.ajax({
						type:"get",
						dataType:"json",
						url:"list3",
						data:{"name":name},
						success:function(res){
							$("#fname").text(res.name);
							$("#photo").attr("src","upload/"+res.photo);
							
							//완료된 후 입력값 지우기
							$("#search").val('');
						}
					});
					
				}
			});
		</script>
		
	</div>
</body>
</html>