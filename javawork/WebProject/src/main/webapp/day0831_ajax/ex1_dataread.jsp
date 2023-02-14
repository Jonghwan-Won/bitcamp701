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
	<button type="button" class="btn btn-outline-info" id="btn1">data5.xml읽기</button>
	<button type="button" class="btn btn-outline-info" id="btn2">data6.json읽기</button>
	<br><br>
	
	<div id="result">result 위치<br></div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			//xml읽기
			var s="";
			$.ajax({
				type: "get",
				url: "data5.xml",
				dataType: "xml",
				success:function(data){
					
					$(data).find("guest").each(function(idx,ele){
						var e=$(ele);
						s+="<div class='box'>";
						s+="인덱스"+idx+"<br>";
						s+="날짜:"+e.find("date").text()+"<br>";
						s+="메세지:"+e.find("message").text()+"<br>";
						
						var photo="<img src='"+e.find("photo").text()+"' width="+e.find("photo").attr("width")+">";
						s+="사진:"+photo+"<br>";
						s+="</div>";
						
					});
					
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
				url: "data6.json",
				dataType: "json",
				success:function(data){
					$.each(data,function(idx,ele){
						
						s+="<div class='box'>"
						s+="Idx:"+idx+"<br>";
						s+="Name:"+ele.name+"<br>";
						s+="Score:<br>";
						
						var cnt=0, sum=0;
						$.each(ele.score, function(i,sc){
							cnt++;
							s+=(i+1)+" :"+sc+"점<br>";
							sum+=Number(sc);
						});
						s+="총 "+cnt+"과목, 총점:"+sum+"점<br>"
						s+="Age:"+ele.age+"<br>";
						s+="<img src='"+ele.photo+"'><br>";
						s+="</div>";
					
					});
					
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