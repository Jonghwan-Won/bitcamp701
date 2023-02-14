<%@page import="data.dto.SmartDto"%>
<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<!-- se2 폴더에서 js 파일 가져오기 -->
<script type="text/javascript" src="../se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

<script type="text/javascript" src="../se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js"
	charset="utf-8"></script>	

<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	b.submit{
		cursor: pointer;
		color: green;
	}
	
	b.submit:hover {
		color: red;
		text-shadow: 5px 5px 5px gray;
	}
	
	#blah{
		position: absolute;
		left: 700px;
		top: 100px;
		width: 250px;
		border: 1px solid black;
	}

</style>

<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>
</head>
<body>

<%
	//num, currentPage 읽기
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	
	//dao 선언
	SmartDao dao=new SmartDao();
	
	//num에 해당하는 dto 얻기
	SmartDto dto=dao.getData(num);
%>


	<div style="margin: 30px 30px; width: 600px;">
	<img id="blah" src="../save/<%=dto.getMainphoto() %>" alt="your image" />
	<!-- 이미지 미리보기 : 절대좌표라서 어디에 붙여넣어도 상관없음 -->
	
		<form action="updateaction.jsp" method="post" enctype="multipart/form-data">
		<!-- hidden 2개 -->
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="currentPage" value="<%=currentPage%>">
		
		
			<table class="table table-bordered">
				<caption align="top"><h5><b><i class="bi bi-pencil-fill"></i>스마트 글수정</b></h5></caption>
				<tr>
					<th width="100" class="table-secondary">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control form-control-sm"
						required="required" autofocus="autofocus" value="<%=dto.getWriter() %>" 
						style="width: 150px">
						<!-- autofoucs : 커서가 자동으로 위치하며 form 안에서 한군데에만 줄 수 있음 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">대표사진</th>
					<td>
						<h5>대표 사진을 변경할 경우에만 다시 선택해주세요</h5>
						<input type="file" name="mainphoto" required="required"
						onchange="readURL(this);">
						
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">제 목</th>
					<td>
						<input type="text" name="subject" class="form-control form-control-sm"
						required="required" value="<%=dto.getSubject()%>">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea id="content" name="content" required="required" 
						style="width: 100%; height: 300px; display: none;"><%=dto.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn btn-outline-danger"
						style="width: 100px;" onclick="submitContents(this)">게시글 수정</button>
						
						<button type="button" class="btn btn-outline-danger"
						style="width: 100px;" onclick="history.back();">이전</button>
						
						<button type="button" class="btn btn-outline-danger"
						style="width: 100px;"
						onclick="location.href='smartlist.jsp?currentPage=<%=currentPage%>'">목록으로</button>
					</td>
				</tr>
			</table>
		</form>
	
	</div>
	
	<!-- 스마트게시판에 대한 스크립트 코드 넣기 -->
	<script type="text/javascript">
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({

    oAppRef: oEditors,

    elPlaceHolder: "content",

    sSkinURI: "../se2/SmartEditor2Skin.html",

    fCreator: "createSEditor2"

}); 

//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.

function submitContents(elClickedObj) {

    // 에디터의 내용이 textarea에 적용된다.

    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [ ]);

 

    // 에디터의 내용에 대한 값 검증은 이곳에서

    // document.getElementById("textAreaContent").value를 이용해서 처리한다.
    try {
        elClickedObj.form.submit();
    } catch(e) { 

    }

}

// textArea에 이미지 첨부

function pasteHTML(filepath){
    var sHTML = '<img src="../save/'+ filepath + '" style="max-width:490px;">';
			oEditors.getById["content"].exec("PASTE_HTML", [ sHTML ]);

		}
	</script>


</body>
</html>