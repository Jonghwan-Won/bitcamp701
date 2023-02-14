<%@page import="data.dao.SmartAnswerDao"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SimpleBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 10초마다 boardlist 호출 -->
<!-- <meta http-equiv="Refresh" content="10;url=boardlist.jsp"> -->

<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	a:link,a:visited {
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		text-decoration: underline;
		color: red;
	}

</style>
</head>

<%
	//dao 선언
	SmartDao dao=new SmartDao();
	
	//페이징 처리에 필요한 변수들
	//전체 갯수
	int totalCount=dao.getTotalCount();
	int perPage=4;	//한 페이지당 보여질 글의 갯수
	int perBlock=3;	//한 블럭당 보여질 페이지의 갯수
	int startNum;	//db에서 가져올 글의 시작번호 (mysql은 첫글이 0번, 오라클은 1번)
	int startPage;	//각 블럭당 보여질 시작페이지
	int endPage;	//각 블럭당 보여질 끝 페이지
	int currentPage; //현재 페이지
	int totalPage;	//총 페이지 수
	int no;	//각 페이지당 출력할 시작번호
	
	//현재 페이지를 읽는다. 단, null일 경우 1페이지로 준다
	if(request.getParameter("currentPage")==null)
		currentPage=1;
	else
		//계산을 해야하므로 int로 변환
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	
	//총 페이지수를 구한다
	//총 글의 갯수/한페이지당보여질갯수로 나눔
	//나머지가 1이라도 있으면 무조건 1페이지 추가 (글 7개, 한페이지당 5개면 2페이지가 필요)
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	
	//각 블럭당 보여질 시작페이지
	//perBlock=5 일 경우 현재페이지가 1~5 일때는 시작페이지가 1, 끝페이지가 5
	//만약 현재페이지가 13 일 경우는 시작페이지가 11, 끝페이지가 15
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	//총 페이지수가 23개일 경우 마지막 블럭은 끝페이지가 25가 아니라 23이어야한다
	if(endPage>totalPage)
		endPage=totalPage;
	
	//각 페이지에서 보여질 시작번호
	//예 : 1페이지 -> 0, 2페이지 -> 5, 3페이지 : 10 ....
	startNum=(currentPage-1)*perPage;
	
	//각 페이지당 출력할 시작번호 구하기
	//예 : 총 글 갯수가 23이라면 1페이지는 23부터 시작, 2페이지는 18, 3페이지는 13..
	no=totalCount-(currentPage-1)*perPage;
	
	
	
	//페이지에서 보여질 글만 가져오기
	//전체 데이터
	/* List<SimpleBoardDto> list=dao.getAllDatas(); */
	List<SmartDto> list=dao.getPagingList(startNum, perPage);
	
	//list의 각 dto에 댓글 갯수 저장해두기
	SmartAnswerDao adao=new SmartAnswerDao();	//댓글 관련 dao
	for(SmartDto dto:list)
	{
		//댓글 변수에 총 갯수 넣기
		//dto.setAnswercount(adao.getAnswerList(dto.getNum()).size());	//한줄작성
		int acount=adao.getAnswerList(dto.getNum()).size();
		dto.setAnswercount(acount);
		
	}
	
	

	//게시판 날짜 형식
	SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
%>

<body>
	<div style="margin: 30px auto; width: 800px;">
		
			
		<br>
		<h3><b>스마트 게시판</b></h3>
		<table class="table table-bordered">
			<caption align="top">
				<h6><b>총 <%=totalCount %>개의 게시글이 있습니다</b></h6>
			</caption>
			<tr class="table-secondary" style="text-align: center;">
				<th width="50">체크</th>
				<th width="50">번호</th>
				<th width="400">제목</th>
				<th width="100">작성자</th>
				<th width="150">작성일</th>
				<th>조회</th>	<!-- width 안주면 남은공간 활용  -->
			</tr>
				
			<%
			if(totalCount==0)
			{%>
				<tr height="40">
					<td colspan="5" align="center">
						<h6><b>등록된 게시글이 없습니다</b></h6>
					</td>
				</tr>
			<%}else{
				
				//for(int i=0;i<list.size();i++)
				for(SmartDto dto:list)
				{
					//dto 선언
					//SmartDto dto=list.get(i);
					%>
					<tr>
						<%-- <td><%=dto.getNum() %></td> --%>
						<!-- 실제 시퀀스넘버는 노출시키지않으며, 게시글을 삭제했을경우에 그 번호는 사용불가-->
						<%-- <td align="center"><%=totalCount-i %></td> --%>
						<td align="center">
							<input type="checkbox" class="alldel" value="<%=dto.getNum()%>">
							&nbsp;&nbsp;
						</td>
						<td align="center"><%=no-- %></td>
						<td>
							<div class="input-group">
						
							<a href="contentview.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>">
								<span style="text-overflow:ellipsis;overflow: hidden;white-space: nowrap;display: block;max-width: 300px;">
								<img src="../save/<%=dto.getMainphoto()%>" width="40" height="40"
								border="1">&nbsp;&nbsp;
								<%=dto.getSubject() %>
								</span>
							</a>
							
							&nbsp;
							<!-- 댓글 표기 -->
							<%
							if(dto.getAnswercount()>0)	//댓글갯수가 0보다 클때만! (=0은 표기안함)
							{%>
								<!-- 같은 페이지로 이동할때 마지막에 #id를 추가하면 그 부분이 시작하는곳으로 열린다 -->
								<a href="contentview.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>#alist" style="color: red;">
									[<%=dto.getAnswercount() %>]
								</a>
							<%}
							
							%>
							</div>
							
						</td>
						<td align="center"><%=dto.getWriter() %></td>
						<td align="center"><%=dt.format(dto.getWriteday()) %></td>
						<td align="center"><%=dto.getReadcount() %></td>
					</tr>
				<% }%>
					<tr>
						<td colspan="6">
						<label><input type="checkbox" class="alldelcheck"> 전체 선택</label>
						<span style="float: right;">
							<button type="button" class="btn btn-outline-danger btn-sm"
							id="btndel">
							<i class="bi bi-trash"></i>삭제</button>
							&nbsp;
							<button type="button" class="btn btn-outline-info btn-sm"
								onclick="location.href='smartform.jsp'">
								<i class="bi bi-pencil-fill"></i>글쓰기
							</button>
						</span>
						</td>
					</tr>
			<% } %>
			
		</table>

		
		<!-- 페이지 번호 출력 -->
		<div style="width: 750px; text-align: center;">
		<ul class="pagination justify-content-center" >
		<%
			//이전
			if(startPage>1)
			{%>
				<li class="page-item">
				<a class="page-link" 
				href="smartlist.jsp?currentPage=<%=startPage-1 %>" style="color: black;">이전</a>
				</li>
			<% }
		
		for(int pp=startPage;pp<=endPage;pp++)
		{
			if(pp==currentPage)	//현재 페이지와 같은 경우 약간의 css추가
			{%>
				<li class="page-item active">
				<a href="smartlist.jsp?currentPage=<%=pp%>" 
				class="page-link"><%=pp%></a>
				</li>
									
			<%}else{ %>
				<li class="page-item">
				<a href="smartlist.jsp?currentPage=<%=pp%>" 
				class="page-link"><%=pp%></a>
				</li>
			<%}
		}
		
		//다음
		if(endPage<totalPage)
		{%>
			<li class="page-item">
			<a class="page-link" 
			href="smartlist.jsp?currentPage=<%=endPage+1 %>" style="color: black;">다음</a>
			</li>
		
		<% } %>
		</ul>
		</div>
		
		
	</div>
	
	<script>
		//전체체크 클릭 시 체크값을 얻어서 모든 체크값 전달하기
		$(".alldelcheck").click(function() {
			//전체 체크값 얻기
			var chk=$(this).is(":checked");
			
			console.log(chk);
			$(".alldel").prop("checked",chk);
		});
	
		//삭제 버튼 클릭 시 삭제
		$("#btndel").click(function(){
			//체크를 안했을경우 '최소 1개 이상의 글을 선택해주세요' 라고 alert
			
			//체크된 길이 구하기
			var len=$(".alldel:checked").length;
			
			if(len==0){
				alert("최소 1개 이상의 글을 선택해주세요");
			}else{
				var a=confirm(len+"개의 글을 삭제하려면 [확인]을 눌러주세요");
				
				if(a){
					//체크된곳의 value 값(num) 얻기
					var n="";
					$(".alldel:checked").each(function(idx){
						n+=$(this).val()+",";
					});
					//마지막 컴마 제거하기
					n=n.substring(0, n.length-1);
					console.log(n);
					
					//삭제 파일로 get방식 전송
					location.href="alldelete.jsp?nums="+n;
				}
				
			}
		});
	</script>
</body>
</html>

<!-- --------------------원종환-------------------- 버전 -->
<%-- <%@page import="data.dto.SimpleBoardDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 10초마다 smartlist 호출 -->
<!-- <meta http-equiv="Refresh" content="10;url=smartlist.jsp"> -->

<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">	
	*{
		font-family: 'Jua';
	}
	
	a:link,a:visited {
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		text-decoration: underline;
		color: red;
	}
	
	th {
		text-align: center;
}

</style>
</head>

<%
	//dao 선언
	SmartDao dao=new SmartDao();
	
	//페이징 처리에 필요한 변수들
	//전체 갯수
	int totalCount=dao.getTotalCount();
	int perPage=2;	//한 페이지당 보여질 글의 갯수
	int perBlock=3;	//한 블럭당 보여질 페이지의 갯수
	int startNum;	//db에서 가져올 글의 시작번호 (mysql은 첫글이 0번, 오라클은 1번)
	int startPage;	//각 블럭당 보여질 시작페이지
	int endPage;	//각 블럭당 보여질 끝 페이지
	int currentPage; //현재 페이지
	int totalPage;	//총 페이지 수
	int no;	//각 페이지당 출력할 시작번호
	
	//현재 페이지를 읽는다. 단, null일 경우 1페이지로 준다
	if(request.getParameter("currentPage")==null)
		currentPage=1;
	else
		//계산을 해야하므로 int로 변환
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	
	//총 페이지수를 구한다
	//총 글의 갯수/한페이지당보여질갯수로 나눔
	//나머지가 1이라도 있으면 무조건 1페이지 추가 (글 7개, 한페이지당 5개면 2페이지가 필요)
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	
	//각 블럭당 보여질 시작페이지
	//perBlock=5 일 경우 현재페이지가 1~5 일때는 시작페이지가 1, 끝페이지가 5
	//만약 현재페이지가 13 일 경우는 시작페이지가 11, 끝페이지가 15
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	//총 페이지수가 23개일 경우 마지막 블럭은 끝페이지가 25가 아니라 23이어야한다
	if(endPage>totalPage)
		endPage=totalPage;
	
	//각 페이지에서 보여질 시작번호
	//예 : 1페이지 -> 0, 2페이지 -> 5, 3페이지 : 10 ....
	startNum=(currentPage-1)*perPage;
	
	//각 페이지당 출력할 시작번호 구하기
	//예 : 총 글 갯수가 23이라면 1페이지는 23부터 시작, 2페이지는 18, 3페이지는 13..
	no=totalCount-(currentPage-1)*perPage;
	
	
	
	//페이지에서 보여질 글만 가져오기
	//전체 데이터
	/* List<SimpleBoardDto> list=dao.getAllDatas(); */
	List<SmartDto> list=dao.getPagingList(startNum, perPage);
	

	//게시판 날짜 형식
	SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
%>

<body>
	<div style="margin: 30px auto; width: 750px;">
		
			
		<br>
		<h3><b>음식 자유 게시판</b></h3>
		<table class="table table-bordered">
			<caption align="top">
				<h6><b>총 <%=totalCount %>개의 게시글이 있습니다</b></h6>
			</caption>
			<tr class="table-secondary">
				<th width="50">번호</th>
				<th width="400">제목</th>
				<th width="100">작성자</th>
				<th width="150">작성일</th>
				<th>조회</th>	<!-- width 안주면 남은공간 활용  -->
			</tr>
				
			<%
			if(totalCount==0)
			{%>
				<tr height="40">
					<td colspan="5" align="center">
						<h6><b>등록된 게시글이 없습니다</b></h6>
					</td>
				</tr>
			<%}else{
				
				for(int i=0;i<list.size();i++)
				{
					//dto 선언
					SmartDto dto=list.get(i);
					%>
					<tr>
						<td><%=dto.getNum() %></td>
						<!-- 실제 시퀀스넘버는 노출시키지않으며, 게시글을 삭제했을경우에 그 번호는 사용불가-->
						<td align="center"><%=totalCount-i %></td>
						<td align="center"><%=no-- %></td>
						<td>
							<a href="contentview.jsp?num=<%=dto.getNum() %>">
								<img src="../image/<%=dto.getMainphoto() %>" width="50">
								<%=dto.getSubject() %>
							</a>
						</td>
						<td align="center"><%=dto.getWriter() %></td>
						<td align="center"><%=dt.format(dto.getWriteday()) %></td>
						<td align="center"><%=dto.getReadcount() %></td>
					</tr>
				<% }
			} %>
			
		</table>
		<caption>
			<button type="button" class="btn btn-outline-secondary btn-lg"
			onclick="location.href='smartform.jsp'"
			style="width: 120px; margin-left: 630px;">
			<i class="bi bi-pencil-fill"></i>글쓰기</button>
		</caption>
		
		<!-- 페이지 번호 출력 -->
		
		<div class="container mt-3" style="text-align: center;">
			<ul class="pagination" style="margin-left: 250px;">
				<% if(startPage>1){%>
					<li class="page-item"><a class="page-link" 
					href="smartlist.jsp?currentPage=<%=startPage-1 %>">이전</a></li>
				<%} else{%>
					<li class="page-item disabled"><a class="page-link" 
					href="smartlist.jsp?currentPage=<%=startPage-1 %>">이전</a></li>
				<%}
				
				
				for(int pp=startPage;pp<=endPage;pp++)
				{
					if(pp==currentPage)	//현재 페이지와 같은 경우 약간의 css추가
					{%>
						<li class="page-item active"><a class="page-link" href="smartlist.jsp?currentPage=<%=pp%>"> 
						<%=pp%></a>
						&nbsp;					
					<%}else{ %>
				
					<li class="page-item"><a class="page-link" href="smartlist.jsp?currentPage=<%=pp%>" style="color: black;"><%=pp%></a>
					&nbsp;				
					<%}
				}				
				if(endPage<totalPage) {%>
					<li class="page-item"><a class="page-link" 
					href="smartlist.jsp?currentPage=<%=endPage+1 %>">다음</a></li>
				<%} else {%>
					<li class="page-item disabled"><a class="page-link" 
					href="smartlist.jsp?currentPage=<%=endPage+1 %>">다음</a></li>
				<%} %>
				
				
			</ul>
		</div>
		
		
	</div>
</body>
</html> --%>