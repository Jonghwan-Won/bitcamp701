<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	body{
		margin: 30px 50px;
	}
	
	div.box{
		border: 4px solid gray;
		margin-left: 200px;
		margin-bottom: 10px;
		padding: 10px 10px;
		width: 400px;
	}
	

</style>
</head>
<body>
	
	<img src="../image/03.png"><br><br>
	<button type="button" class="btn btn-outline-info" id="btn1">xmldata1.jsp읽기</button>
	<button type="button" class="btn btn-outline-info" id="btn2">jsondata2.jsp읽기</button>
	<br><br>
	
	<div id="result">result 위치<br></div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			
			var s="";
			$.ajax({
				type: "get",
				url: "xmldata1.jsp",
				dataType: "xml",
				success:function(data){
					s="<div class='box'>";
					s+="이름: "+$(data).find("name").text()+"<br>";
					s+="주소: "+$(data).find("addr").text();
					s+="</div>"
					$("#result").html(s);
					
				},
				statusCode: {
					404:function(){
						alert("xml 파일을 찾을 수 없어요!");
					},
					500:function(){
						alert("서버 오류..코드를 다시 한번 확인하세요!");
					}
				}
				
			});
			
		});
		
		$("#btn2").click(function(){
			$("#result").empty();
			
			//json읽기
			var s="";
			
			$.ajax({
				type: "get",
				url: "jsondata2.jsp",
				dataType: "json",
				success:function(data){
					
					s+="<div class='box'>";
					s+="이름 :"+data.name+"<br>";
					s+="주소 :"+data.addr;
					s+="</div>";
					
					$("#result").append(s);
					
				},
				statusCode: {
					404:function(){
						alert("json 파일을 찾을 수 없어요!");
					},
					500:function(){
						alert("서버 오류..코드를 다시 한번 확인하세요!");
					}
				}
				
			});
			
		});
	
	</script>
	
</body>
</html>