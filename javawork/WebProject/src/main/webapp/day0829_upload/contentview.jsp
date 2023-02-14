<%@page import="data.dto.SmartDto"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<!-- jQuery UI / dialogue -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<style type="text/css">
	body *{
		 font-family: 'Jua';
	}
	
	span.day{
		color: #ccc;
		font-size: 0.8em;
	}
	
	div.alist{
		margin-left: 20px;
		
	}
	
	div.alist span.aday{
		/* float: right; */
		font-size: 0.8em;
		color: #bbb;
	}
	
</style>

<script>
	$(function() {
		//처음 시작 시 댓글 출력 호출
		list();
		
		
		$(document).on("click",".adel",function(){
			var a=confirm("댓글을 삭제하려면 [확인]을 눌러주세요");
			
			//idx얻기
			var idx=$(this).attr("idx");
			
			if(a){
				
				$.ajax({
					type:"get",
					url:"deleteanswer.jsp",
					dataType:"html",
					data:{"idx":idx},
					success:function(res){	
						
						//댓글 삭제 후 댓글목록(list)을 다시 출력
						list();
						
					},
					statusCode: {
						404:function(){
							alert("json 파일을 찾을수 없어요!");
						},
						500:function(){
							alert("서버 오류..코드를 다시 한번 보세요!");
						}
					}
				});
				
				
			}
		});
		
		
		$( "#dialog" ).dialog({
		      autoOpen: false,
		      show: {
		        effect: "fade",
		        duration: 300
		      },
		      hide: {
		        effect: "fade",
		        duration: 300
		      }
		    });
		
		
		$(document).on("click",".amod",function(){
			idx=$(this).attr("idx");
			//alert(idx);	//댓글의 idx번호 확인
			//var idx는 이 안에서만 사용가능하고 
			//var 를 빼면 다른곳에서도 사용가능
			
			
			//form 타입으로 데이터를 보내므로 json
			$.ajax({
					type: "get",
					url: "jsonupdateform.jsp",
					dataType: "json",
					data: {"idx":idx},
					success:function(res){
						
						$("#unickname").val(res.nickname);
						$("#ucontent").val(res.content);
						
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
			
			$( "#dialog" ).dialog( "open" );
		});
		
		
		//댓글 수정
		$(document).on("click","#btnaupdate",function(){
			var nickname= $("#unickname").val();
			var content= $("#ucontent").val();
			
			$.ajax({
				type: "get",
				url: "updateanswer.jsp",
				dataType: "html",
				data: {"idx":idx,"nickname":nickname,"content":content},
				success:function(res){

					$( "#dialog" ).dialog( "close" );	//다이얼로그 닫기
					list();
					
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
		
	});	//$function close
	
	function list() {
		//댓글 출력
		//console.log("list num="+num);
		console.log("list num="+$("#num").val());
		
		$.ajax({
			type:"get",
			url:"listanswer.jsp",
			dataType:"json",
			data:{"num":$("#num").val()},
			success:function(res){	
				
				//댓글 갯수 출력
				$("b.acount>span").text(res.length);
				
				var s="";
				$.each(res,function(ixd,item){
					s+="<div style='margin-top:15px; border-bottom:1px solid lightgray'>";

						/* 댓글 작성자, 내용 묶음 */
						s+="<div>";
							s+="<img class='rounded-circle' src='../image/user_default.png' width='30px' height='30px' style='margin-right:10px;'>";
							s+="<div style='width:100px; display:inline-block;'><b style='width'>"+item.nickname+"</b></div>";
							s+="<span>"+item.content+"</span>";
						s+="</div>";
						
						/* 날짜 수정버튼 삭제버튼 묶음 */
						s+="<div style='float:right; position:relative; top:-35px;'>";
							s+="<span class='aday'>"+item.writeday+"</span>&nbsp;";
							s+="<div class='btn-group' style='margin-bottom:5px;'>";
								s+="<button type='button' idx="+item.idx+" class='amod btn btn-outline-success btn-sm'>수정</button>&nbsp;";
								s+="<button type='button' idx="+item.idx+" class='adel btn btn-outline-danger btn-sm'>삭제</button>";
							s+="</div>";
						s+="</div>";
						
					s+="</div>";
					
				});
				$("div.alist").html(s);
			},
			statusCode: {
				404:function(){
					alert("json 파일을 찾을수 없어요!");
				},
				500:function(){
					alert("서버 오류..코드를 다시 한번 보세요!");
				}
			}
		});

		
		
	}
	
	
</script>

</head>
<body>

<div id="dialog" title="댓글 수정" style="width: 500px; height: 500px;">
	<b>닉네임 : </b>
	<input type="text" id="unickname" style="width: 100%;">
	<br><br>
	<b>댓글 내용 : </b>
	<input type="text" id="ucontent" style="width: 100%;">
	<br>
	<br>
	<button type="button" id="btnaupdate" class="btn btn-success" style="width: 100%">댓글 수정</button>
	<br>
	<button type="button" id="" class="btn btn-secondary" 
	style="width: 100%; margin-top: 10px;">취소</button>
</div>


<jsp:useBean id="dao" class="data.dao.SmartDao"/>
<%
	//num을 읽는다
	String num=request.getParameter("num");
	//현재 페이지를 읽는다
	String currentPage=request.getParameter("currentPage");
	
	//조회수 1 증가
	dao.updateReadCount(num);
	
	//dto 가져오기
	SmartDto dto=dao.getData(num);
	
	//날짜 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");	
%>
<input type="hidden" id="num" value="<%=num%>">
<div style="margin: 30px auto;width: 700px;">
	<table class="table table-bordered">
		<caption align="top">
		<div  class="input-group">
			<img src="../save/<%=dto.getMainphoto()%>" width="70" height="70"
			class="rounded-circle" onerror="this.src='../image/noimage.png'">&nbsp;
			<h2><b><%=dto.getSubject() %></b></h2>
		</div>
		</caption>
		<tr>
			<td>
				<b>작성자:<%=dto.getWriter()%></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %>
				&nbsp;&nbsp;조회 <%=dto.getReadcount()%>
				</span>
			</td>
		</tr>
		<tr height="150">
			<td>
			<%
				if(dto.getContent()==null){%>
					<h1 style="color: red;">저장된 내용 없음!</h1>
				<%}else{%>
					<!-- 엔터없이 길게 썼을 경우 500px 안에서 자동 줄넘김되게 하기 -->
					<!-- <div style="white-space:pre-wrap;word-wrap:break-word;width: 500px;"> -->
					<%=dto.getContent()%>
					<!-- </div> -->
					<!-- 스마트에디터라서 자동줄넘김 등 코드가 이미 적용되어있음 -->
				<%}
			%>	
			</td>		
		</tr>
		<tr>
			<td>
				<b class="acount">댓글 <span>0</span></b>
				<div class="alist" id="alist">
					댓글목록
				</div>
				<div class="aform input-group">
					<input type="text" id="nickname" class="form-control form-control-sm"
					 style="width: 100px;" placeholder="닉네임">
					 
					 <input type="text" id="content" class="form-control form-control-sm"
					 style="width: 300px;" placeholder="댓글메세지">
					 
					 <button type="button" id="btnasend" class="btn btn-secondary btn-sm">저장</button>
				</div>
			</td>
		</tr>
		
		<script>
			//댓글부분 ajax insert code
			//댓글 저장할때 어느글에 대한 댓글을 보내는지 알아야하므로 num 이 출력되어야함
			<%-- var num='<%=num%>'; --%>
			var num=$("#num").val();
			console.log(num);
			
			$("#btnasend").click(function() {
				//alert(1);	//저장버튼 눌러서 1 나오는거 확인하면 주석
				var nickname=$("#nickname").val().trim();
				var content=$("#content").val().trim();
				if(nickname==''){
					alert("닉네임을 입력 후 저장해주세요");
					return;
				}
				if(content==''){
					alert("댓글내용을 입력 후 저장해주세요");
					return;
				}
				
				
				$.ajax({
					type: "get",
					url: "insertanswer.jsp",
					dataType: "html",
					data: {"num":num,"nickname":nickname,"content":content},
					success:function(res){
						//저장이 완료되면 입력창 비우기
						$("#nickname").val('');
						$("#content").val('');
						
						//댓글 추가(성공success) 후 댓글목록(list)을 다시 출력
						list();
						
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
		
		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-info btn-sm" style="width: 100px;"
				onclick="location.href='smartform.jsp'">
				<i style='font-size:14px' class='fas'>&#xf304;</i> 글쓰기</button>
				
				<button type="button" class="btn btn-outline-success btn-sm" style="width: 100px;"
				onclick="location.href='updateform.jsp?num=<%=num%>&currentPage=<%=currentPage%>'">
				<i class='far fa-edit' style='font-size:14px'></i> 수정</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm" style="width: 100px;"
				onclick="funcdel(<%=num%>,<%=currentPage%>)">
				<i class="bi bi-trash"></i> 삭제</button>
				
				<button type="button" class="btn btn-outline-secondary btn-sm" style="width: 100px;"
				onclick="location.href='smartlist.jsp?currentPage=<%=currentPage%>'">
				<i class="bi bi-layout-text-window-reverse"></i> 목록</button>
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
	function funcdel(num,currentPage){
		//alert(num+","+currentPage);
		
		var a=confirm("삭제하려면 [확인] 을 눌러주세요")
		if(a){
			location.href="deleteaction.jsp?num="+num+"&currentPage="+currentPage;
		}
	}
</script>
</body>
</html>
