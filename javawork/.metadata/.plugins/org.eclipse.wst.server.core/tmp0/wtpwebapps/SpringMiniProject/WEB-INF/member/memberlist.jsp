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
		/* background-color: #121212; */
		/* color: #bbb; */
	}

</style>
</head>
<body>
	
	<!-- <h1>memberlist 화면</h1> -->
	<h4 class="alert alert-secondary">총 ${totalCount}명의 회원이 있습니다</h4>
	<br>
	<table class="table table-bordered">
		<c:forEach var="dto" items="${list}">	<!-- 번호 없으니까 varstatus 필요없음 -->
			<tr>
				<td style="width: 250px;" align="center" rowspan="5">
					<img src="../upload/${dto.photo}" width="230" height="250" border="1">
					<br>
					<!-- 여기서 forEach 반복문 안에 id값들을 줬지만 쓰지말아야함 (ID는 고유값인데 반복하면 같은iD가 여러개됨 -->
					<!-- 2022 09 20 id로 부여되어있던걸 클래스로 수정함 -->
					
					<br>
					
					<!-- 로그인 상태에서 본인의 수정/삭제버튼 보이게 -->
					<c:if test="${sessionScope.loginok!=null and sessionScope.loginid==dto.loginid}">
						<input type="file" id="newphoto" style="display: none;" num="${dto.num}"> <!-- 사진 수정 시 호출 -->
						<button type="button" class="btn btn-secondary btnnewphoto">사진 수정</button>
					</c:if>
				</td>
				<td style="width: 300px;">회원명 : ${dto.name}</td>
				<td rowspan="5" align="center" valign="middle">
					<!-- 로그인 상태에서 본인의 수정/삭제버튼 보이게 -->
					<c:if test="${sessionScope.loginok!=null and sessionScope.loginid==dto.loginid}">
						<button type="button" class="btn btn-secondary btnupdate" num="${dto.num}"
						data-bs-toggle="modal" data-bs-target="#myUpdateModal">수정</button>
						<br><br>
						<button type="button" class="btn btn-danger btndelete" num="${dto.num}">삭제</button>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>아이디 : ${dto.loginid}</td>
			</tr>
			<tr>
				<td>이메일 : ${dto.email}</td>
			</tr>
			<tr>
				<td>핸드폰 : ${dto.hp}</td>
			</tr>
			<tr>
				<td>주소 : ${dto.address}</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 로그인창 -->
	<!-- The Modal -->
	<div class="modal" id="myUpdateModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원정보 수정</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <div class="input-group mb-3 input-group-sm">
			  <span class="input-group-text" style="width: 80px;">회원명</span>
			  <input type="text" class="form-control" id="updatename">
			</div>
			<div class="input-group mb-3 input-group-sm">
			  <span class="input-group-text" style="width: 80px;">연락처</span>
			  <input type="text" class="form-control" id="updatehp">
			</div>
			<div class="input-group mb-3 input-group-sm">
			  <span class="input-group-text" style="width: 80px;">이메일</span>
			  <input type="email" class="form-control" id="updateemail">
			</div>
			<div class="input-group mb-3 input-group-sm">
			  <span class="input-group-text" style="width: 80px;">주소</span>
			  <input type="text" class="form-control" id="updateaddr">
			</div>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success" data-bs-dismiss="modal" id="btnupdateok">수정</button>
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<script type="text/javascript">
		$(".btnnewphoto").click(function () {
			$("#newphoto").trigger("click");
		});
		
		$("#newphoto").change(function () {
			var num=$(this).attr("num");
			console.log(num);
			
			var form=new FormData();
			form.append("photo",$("#newphoto")[0].files[0]);	//선택한 1개만 추가
			form.append("num",num);
			console.dir(form);
			
			$.ajax({
				type: "post",	//반환 안받음
				dataType:"text",
				url:"updatephoto",
				processData:false,
				contentType:false,
				data:form,
				success:function(res){
					
					location.reload();
				}	//success 종료
				
			});	//ajax 종료
		}); //사진수정 버튼 이벤트 종료
		
		//멤버 삭제
		$(".btndelete").click(function () {
			
			var num=$(this).attr("num");
			//alert(num);
			
			var ans=confirm("정말 탈퇴하시겠습니까?");
			if(ans){
				
				$.ajax({
					type: "get",	//반환 안받음
					dataType:"text",
					url:"delete",
					//processData:false,
					//contentType:false,
					data:{"num":num},
					success:function(res){
						
						alert("탈퇴가 완료되었습니다")
						location.reload();
					}	//success 종료
					
				}); //ajax 종료
			} //if 종료
		}); //delete 버튼이벤트 종료
		
		//수정 버튼 클릭 시 데이터 가져오기
		$(".btnupdate").click(function () {
			updatenum=$(this).attr("num");	//일부러 var 안씀.. 왜?
			//alert(updatenum);
			
			$.ajax({
				type: "get",
				dataType:"json",
				url:"updateform",
				data:{"num":updatenum},
				success:function(res){
					console.dir(res);
					$("#updatename").val(res.name);
					$("#updatehp").val(res.hp);
					$("#updateemail").val(res.email);
					$("#updateaddr").val(res.address);
					
				}	//success 종료
				
			}); //ajax 종료
			
		});	//update버튼 이벤트 종료
		
		
		//수정
		$("#btnupdateok").click(function () {
			
			var updatename=$("#updatename").val();
			var updatehp=$("#updatehp").val();
			var updateemail=$("#updateemail").val();
			var updateaddr=$("#updateaddr").val();
			
			var data="num="+updatenum+"&name="+updatename+"&hp="+updatehp+"&email="+updateemail+"&address="+updateaddr;
			console.log(data);
			
			$.ajax({
				type: "post",	//반환 안받음
				dataType:"text",
				url:"update",
				data:data,
				success:function(res){
					
					location.reload();
				}	//success 종료
				
			});	//ajax 종료
			
		}); //btnupdate 버튼 이벤트 종료
		
	</script>
</body>
</html>