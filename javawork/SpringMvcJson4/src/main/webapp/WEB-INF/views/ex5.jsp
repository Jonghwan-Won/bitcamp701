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
	
	#photos figure{
		/* figure 속성으로 인해 아래로 내려감 float를 줘야 옆으로 정렬됨*/
		float: left;
		width: 150px;
		height: 170px;
		margin-right: 10px;
		text-align: center;
	}
	
	#photos figure figcaption{
		font-weight: bold;
		text-align: center;
	}
	
	#photos img{
		width: 120px;
		height: 120px;
		border: 1px solid gray;
		border-radius: 30px;
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
			
			//여러개 업로드를 위한 for문
			for(i=0;i<$("#photoupload")[0].files.length;i++){
				form.append("upload",$("#photoupload")[0].files[i]);	//선택한 사진 모두 추가	
			}
			
			$.ajax({
				type:"post",	/*upload는 무조건 post*/
				dataType:"json",
				url:"multiupload",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					
					console.dir(res)	//콘솔에서 배열형태로 넘어오는지 확인
					
					//res를 스프링에서 List<Map> 형태로 반환
					var s="";
					$.each(res,function(i,elt){
						s+="<figure>";
						s+="<img src='upload/"+elt.photoname+"'>";
						s+="<figcaption>";
						s+=elt.photosize;
						s+="</figcaption>";
						s+="</figure>";
					}); //$.each
					
					$("#photos").append(s);
					
				} //success
			}); //ajax
		}); //#photoupload change
	}); //$(function)
</script>

</head>
<body>
	<div style="margin:50px 50px;">
		
		<h3 class="alert alert-dark">Ex5번 예제 - 한번에 여러 이미지 업로드</h3>
		
		<input type="file" id="photoupload" multiple="multiple"> <!-- 여러개 선택 -->
		
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