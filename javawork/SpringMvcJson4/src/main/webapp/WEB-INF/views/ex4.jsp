<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script><!-- bs5 icon -->
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

	.fa-camera-retro{
		cursor: pointer;	
	}
	
	#photos{
		margin-top: 50px;
	}
	
	#photos img{
		width: 120px;
		height: 140px;
		border: 1px solid gray;
		border-radius: 30px;
		margin-right: 10px;
		box-shadow: 5px 5px 5px gray;
	}
	
	#photoupload{
		display: none;	/* 공간을 차지하지 않음 */
		/* visibility:hidden; 공간을 차지함 */ 
	}
	
</style>

<script type="text/javascript">
	$(function () {
		//카메라 아이콘 클릭 시 file태그를 클릭한 효과 주기 (파일업로드)
		$(".fa-camera-retro").click(function () {
			$("#photoupload").trigger("click");
		});
		
		/* 
		processData:false -> 서버에 전달하는 데이터는 query string 이라는 형태로 전달된다
			파일 전송의 경우 이를 하지 않아야하는데, 그 설정이 false
		
		contentType:false -> enctype 의 원래 기본값이 application/x-www... 이건데
			false일 경우 multipart/form-data로 변경해준다
		 */
		
		//file태그 변경 시 이벤트
		$("#photoupload").change(function(e) {
			var form=new FormData();
			form.append("upload",$("#photoupload")[0].files[0]);
			//선택한 1개만 추가, 여러개하려면 for문 돌리기
			//배열타입으로 넘어옴
			
			$.ajax({
				type:"post",	/*upload는 무조건 post*/
				dataType:"json",
				url:"oneupload",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					//전송받은 파일명을 img 태그로 만들기
					console.log(res.photoname);
					var s="<img src='upload/"+res.photoname+"'>";
					$("#photos").append(s);
				
				} //success
			}); //ajax
		}); //#photoupload change
	}); //$(function)
</script>

</head>
<body>
	<div style="margin:50px 50px;">
		<h3 class="alert alert-dark">Ex4번 예제</h3>
		
		<input type="file" id="photoupload">
		
		<i class='fas fa-camera-retro' style='font-size:80px'></i>
		
		<div id="photos">
			<!-- CSS 적용 확인을 위한 샘플 이미지 -->
			<!-- 
			<img src="upload/아이스크림.JPG">
			<img src="upload/텀블러.jpg">
			 -->
			
		</div>
	</div>
</body>
</html>