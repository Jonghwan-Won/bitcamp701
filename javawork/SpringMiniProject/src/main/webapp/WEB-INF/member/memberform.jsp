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
	
	#showimg{
		border: 1px solid gray;
		width: 150px;
		height: 180px;
	}
	
</style>

<script type="text/javascript">
	$(function () {
		//버튼 클릭 시 사진 불러오는 이벤트 추가
		
		$("#btnphoto").click(function () {
			$("#myphoto").trigger("click");	
		});
		
		
		//사진 불러오면 미리보기하기
		$("#myphoto").change(function(){
			 /* console.log("1:"+$(this)[0].files.length);
			 console.log("2:"+$(this)[0].files[0]); */
			 
			 //정규표현식
			var reg = /(.*?)\/(jpg|jpeg|png|bmp|gif)$/;
			var f=$(this)[0].files[0];//현재 선택한 파일
			if(!f.type.match(reg)){
			  alert("확장자가 이미지파일이 아닙니다");
			  return;
			}
			 if($(this)[0].files[0]){
			  var reader=new FileReader();
			  reader.onload=function(e){
			   $("#showimg").attr("src",e.target.result);
			  }
			  reader.readAsDataURL($(this)[0].files[0]);
			 }
		});
		
		//아이디 입력 시 .idsuccess 값 지우기
		$("#loginid").keydown(function () {
			$("div.idsuccess").text("");
		});

		//중복체크 버튼 클릭 시 ID체크
		$("#btnidcheck").click(function () {
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"idcheck",
				data:{"id":$("#loginid2").val()},	//loginid가 충돌나는 현상있어서 2로바꿈
				success:function(res){
					
					if(res.count==0){
						$("div.idsuccess").text("ok");	
					}else{
						$("div.idsuccess").text("fail");
					}
					
				}	//res
				
			}); //ajax
		});	//id체크
		
		
		//2번째 비밀번호(pass2) 입력 시 체크
		$("#pass2").keyup(function () {
			
			var p1=$("#pass").val();
			var p2=$(this).val();
			
			if(p1==p2){
				$("div.passsuccess").text("ok");
			}else{
				$("div.passsuccess").text("");
			}
			
		});	//pass2 체크
		
		
		
	});//function
	
	
	//submit 전에 호출
	//form action 코드 마지막에 onsubmit으로 return check() 있음
	
	function check() {
		
		//사진 넣었는지 체크
		if($("#myphoto").val()==''){
			alert("사진을 넣어주세요");
			return false;
		}
		
		//아이디 중복체크 했는지 여부
		if($("div.idsuccess").text()!='ok'){	//ok가 아니면
			alert("아이디 중복체크를 해주세요")
			return false;
		}
		
		//비밀번호 중복체크 했는지 여부
		if($("div.passsuccess").text()!='ok'){	//ok가 아니면
			alert("비밀번호가 서로 다릅니다")
			
			return false;
		}
	}

</script>

</head>
<body>
	<!-- <h1>회원가입폼</h1> -->
	<h4 class="alert alert-secondary">회원가입</h4></caption>
    <form action="insert" method="post" enctype="multipart/form-data" onsubmit="return check()">
        <table class="table table-bordered" style="width: 600px;">
            <tr>
            	<td style="width:200px" rowspan="4" align="center">
            		
            		<input type="file" id="myphoto" name="myphoto" style="display: none;">
            		<button type="button" id="btnphoto" class="btn btn-secondary btn-sm">사진 선택</button>
            		<br><br>
            		
            		<img id="showimg">
            		
            	</td>
            	<td>
            		<div class="input-group">
	            		<input type="text" placeholder="아이디 입력" id="loginid2" name="loginid"
	            		class="form-control" style="width: 120px;" required="required">
	            	
	            		<button type="button" class="btn btn-dark btn-sm" id="btnidcheck">중복 체크</button>
	            		&nbsp;
	            		<div class="idsuccess" style="width: 60px"></div>
            		</div>
           		</td>       
			</tr>
			<tr>
				<td>
					<div class="input-group">
						<input type="password" style="width: 120px;" class="form-control"
						name="pass" id="pass" placeholder="숫자 4자리" maxlength="4" pattern="[0-9]{4,}"
						required="required">
						
						<input type="password" style="width: 120px;" class="form-control"
						id="pass2" placeholder="숫자 4자리" maxlength="4" pattern="[0-9]{4,}"
						required="required">
						&nbsp;
						<div class="passsuccess" style="width: 60px"></div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="name" class="fomr-control" style="width: 150px;"
					placeholder="이름을 입력하세요" required="required">
				</td>
			</tr>
			<tr>
				<td>
					<input type="email" name="email" class="fomr-control" 
					placeholder="이메일을 입력하세요" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<div class="input-group">
						<input type="text" name="hp" placeholder="(-)없이 번호만 입력"  class="form-control"
						style="width: 100px;" required="required">
						
						<input type="text" name="address" placeholder="주소 입력"  class="form-control"
						style="width: 300px;" required="required">
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success" style="width: 180px;">회원가입</button>
				</td>
			</tr>
			
        </table>
    </form>
	
</body>
</html>