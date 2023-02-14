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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style type="text/css">
	*{
		font-family: 'Jua';
	}

	span.likes{
		cursor: pointer;
	}
	
	span.day{
		color: #333;
		float: right;
		font-size: 0.9em;
	}
	
	span.writer{
		color: red;
		font-weight: bold;
		border: 1px solid red;
		border-radius: 10px;
		margin-left: 5px;
		font-size: 0.9em;
		padding: 3px;
	}
	
	.adel{
		color: red;
		cursor: pointer;
		margin-left: 5px;
		font-size: 0.8em;
		font-weight: bold;
	}
	
	div.alist pre{
		text-indent: 10px;
		color: gray;
	}
	
	div.alist img{
		width: 40px;
		height: 40px;
		cursor: pointer;
		border: 1px solid gray;
		border-radius: 10px;
		margin-left: 10px;
	}
	
	
	
</style>

<script type="text/javascript">
	
	var num=${dto.num};	//전역변수 선언
	
	$(function () {
		console.log("num="+num);
		
		list();	//처음 시작 시 출력
		
		
	});
	
	function list() {
		
		var loginok='${sessionScope.loginok}';
		var loginid='${sessionScope.loginid}';	//로그인 한 사람의 아이디
		var writeid='${dto.id}';	//글쓴 사람의 아이디 
		
		//alert(loginok+","+loginid);
		
		var s="";
		
		$.ajax({
			type:"get",
			url:"../answer/list",
			dataType:"json",
			data:{"num":num},
			success:function(res){
				
				//댓글 갯수부터 출력해보기
				$("b.banswer").text(res.length);	//배열로 넘어오니까 length가 개수
				
				$.each(res, function(i, elt) {
					s+="<div style='border-top:1px solid lightgray;'>"+name+elt.name;
					
					if(elt.photo!='no')
						{
							s+="<a href='../upload/"+elt.photo+"' target='_blank'>";
							s+="<img src='../upload/"+elt.photo+"'>";
							s+="</a>";
						}
					
					if(writeid==elt.id){	//로그인 한 사람과 작성자가 같으면 댓글에 '작성자'표시
						s+="<span class='writer'>작성자</span>";	
					}
					s+="<br>";
					s+="<pre>"+elt.message
					s+="<span class='day'>"+elt.writeday+"&nbsp;";
					
					if(loginok=='yes' && loginid==elt.id){
						s+='<i class="material-icons adel" idx='+elt.idx+'>close </i>';
					}
					
					s+="</prd></span></div>";
					
				});	//each 반복 종료
				
				$("div.alist").html(s);
				
			}	//success 종료
			
		});	//ajax 종료
		
	} //function list 종료

</script>

</head>
<body>
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<td>
				<h2><b>${dto.subject}</b></h2>
				<c:if test="${memphoto!='no'}"> <!-- 탈퇴한 회원은 사진 안나옴 -->
					<img src="../upload/${memphoto}" width="50" height="50" class="rounded-circle"
					align="left" onerror="this.src='../image/noimage.png'" hspace="20">
				</c:if>
				
				
				<b>${dto.name}(${dto.id})</b><br>
				<span style="color: #ccc; font-size: 13px;">
					<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
					&nbsp;&nbsp;
					조회&nbsp;${dto.readcount}
				</span>
				
			</td>
		</tr>
		<tr height="300" valign="top">
			<td>
				<pre>${dto.content}</pre>
				<br><br>
				<%-- ${dto.photo} --%>
				<c:if test="${dto.photo!='no'}">
					<c:forTokens items="${dto.photo}" delims=","> 
						<img src="../upload/${dto.photo}" width="250" class="img-thumbnail"
						onerror="this.style.display='none'"> <!-- 해당 폴더에 없는 사진은 안보이게 처리 -->
					</c:forTokens>
				</c:if>
				
				<br><br>
				<span class="likes">
					<!-- <i class='fas fa-heart'></i> -->
					<i class='far fa-heart'></i>&nbsp;
					좋아요 <b>${dto.likes}</b></span>
					&nbsp;&nbsp;
					
				<i class='far fa-comment-dots'></i>
				&nbsp;<b class="banswer">댓글 0</b>
				
				<br>
				<div class="alist" style="margin-top: 20px;">
					댓글목록
				</div>
				
				
				<c:if test="${sessionScope.loginok!=null}">
				
				<div class="aform">
					<form id="aform">
						<input type="hidden" name="num" value="${dto.num}">
						<input type="hidden" name="id" value="${sessionScope.loginid}">
						<input type="hidden" name="name" value="${sessionScope.loginname}">
						
						<input type="file" id="upload" style="display: none;">
						<button type="button" class="btn btn-success btn-sm" id="btnphoto">사진</button>
						<img src="" id="aphoto" width="50" height="50" style="display: none;"> 
						
						<br>
						
						<div class="input-group">
							<textarea name="message" id="message" style="width: 400px;height: 70px; margin-top: 10px;"
							class="form-control"></textarea>
							<button type="button" class="btn btn-secondary btn-sm" id="btnsave" style="margin-top: 10px;">등록</button>
						</div>
						<!-- ajax는 id로 읽음 -->
						<!-- json은 name 으로 읽음 -->
					</form>
				</div>
				
				</c:if>
				
				
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='form'">새글</button>
				
				<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
				
				<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='list?currentPage=${currentPage}'">목록</button>
				
				
				<!-- 로그인중이면서, 세션ID와 글작성자와 같다면 수정/삭제 가능하도록(보이도록) -->
				<c:if test="${sessionScope.loginok!=null && sessionScope.loginid==dto.id}">
				
					<button type="button" class="btn btn-outline-secondary"
					onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
					
					<button type="button" class="btn btn-outline-secondary"
					onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
				</c:if>
				
			</td>
		</tr>
		
		
		
	</table>
	
	<script type="text/javascript">
	
		//하트 클릭 시 빨강하트 & 빈하트 번갈아 나오게 하기
		$("span.likes").click(function () {

			var heart=$(this).find("i").attr("class"); //i태그로하면 안되는경우가 있어서, class로 주기
			if(heart=='far fa-heart'){
				$(this).find("i").attr("class","fas fa-heart").css("color","red");
			}else{
				$(this).find("i").attr("class","far fa-heart").css("color","black");
			}
			
		
	
		//ajax 이용해서 좋아요 수 증가 후 출력
		var num=${dto.num};
		console.log(num);
		
		$.ajax({
			type:"get",
			url:"likes",
			dataType:"json",
			data:{"num":num},
			success:function(res){
				
				$("span.likes").find("b").text(res.likes);
				
			}
			
		});
	});	//이벤트 종료
	
	//댓글의 사진 버튼
	$("#btnphoto").click(function () {
		$("#upload").trigger("click");
	});
	
	//file 태그
	$("#upload").change(function () {
		var form=new FormData();
		form.append("photo",$("#upload")[0].files[0]);	//선택한 1개만 추가
		
		$.ajax({
			type: "post",	//반환 안받음
			dataType:"json",	//map으로 보냈음
			url:"../answer/updatephoto",
			processData:false,
			contentType:false,	//멀티파트 폼데이터
			data:form,
			success:function(res){
				
				console.log(res.aphoto);
				
				//upload사진을 #aphoto에 출력
				$("#aphoto").attr("src","../upload/"+res.aphoto);
				$("#aphoto").css("display","inline-block");
				
			} //success 종료
			
		}); //ajax 종료
	});
	
	//댓글 저장
	$("#btnsave").click(function () {
		var fdata=$("#aform").serialize();	//form태그 안의 name을 쿼리스트링 형태로 읽어온다
		//alert(fdata);
		
		$.ajax({
			type:"post",
			url:"../answer/insert",
			dataType:"text", //void 이므로 json이 아닌 text
			data:fdata,	//fdata는 쿼리스트링 형태
			success:function(res){
				
				list();	//댓글 목록을 다시 db에서 가져와서 출력
				
				
				//입력값이랑 사진 안보이게 처리
				$("#message").val("");	//메세지 value 값 비우기
				$("#aphoto").attr("src","").css("display","none");	//aphoto 의 src 비우고, 안보이게하기 
			}
			
		});
		
	});
	
	
	//댓글 삭제
	$(document).on("click", ".adel", function () {
		
		confirm("댓글을 삭제하시겠습니까?");

		var idx=$(this).attr("idx");
		
		console.log(idx);
		
		
		$.ajax({
			type:"get",
			url:"../answer/delete",
			dataType:"text", //void 이므로 json이 아닌 text
			data:{"idx":idx},
			success:function(res){
				
				list();	//댓글 목록을 다시 db에서 가져와서 출력
			 	
	
			} //res 종료
			
		});	//ajax 종료
		
	});
		
	</script>
	
	
</body>
</html>