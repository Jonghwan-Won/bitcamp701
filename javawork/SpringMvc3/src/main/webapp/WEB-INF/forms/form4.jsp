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

</style>
</head>
<body>
	<div style="margin: 30px 30px;">
		<form action="read4" method="post" enctype="multipart/form-data">
			<table class="table table-bordered" style="width: 400px;">
				<tr valign="middle">
					<th width="100" style="background-color: lightgray; text-align: center;">사진 설명</th>
					<td>
						<input type="text" name="desc" class="form-control" required="required">
					</td>
				</tr>
				<tr valign="middle">
					<th width="100" style="background-color: lightgray; text-align: center;">사 진</th>
					<td>
						<input type="file" name="upload" class="form-control" required="required"
						multiple="multiple">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-secondary">서버저장4</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>