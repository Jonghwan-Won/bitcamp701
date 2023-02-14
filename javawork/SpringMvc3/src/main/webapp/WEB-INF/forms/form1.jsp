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
		<form action="read1" method="post">
			<table class="table table-bordered" style="width: 300px;">
				<tr valign="middle">
					<th width="100" style="background-color: lightgray; text-align: center;">이 름</th>
					<td>
						<input type="text" name="name" class="form-control" required="required"
						style="width: 150px;"> 
					</td>
				</tr>
				<tr valign="middle">
					<th width="100" style="background-color: lightgray; text-align: center;">나 이</th>
					<td>
						<input type="text" name="age" class="form-control" required="required"
						style="width: 150px;"> 
					</td>
				</tr>
				<tr valign="middle">
					<th width="100" style="background-color: lightgray; text-align: center;">부 서</th>
					<td align="left">
						<select style="width: 150px" name="buseo" class="form-select">
							<option value="홍보부">홍보부</option>
							<option value="교육부">교육부</option>
							<option value="인사부">인사부</option>
							<option value="관리부">관리부</option>
						</select>
					</td>
				</tr>
				<tr valign="middle">
					<th width="100" style="background-color: lightgray; text-align: center;">입사일</th>
					<td>
						<input type="date" name="ipsaday" class="form-control" required="required"
						style="width: 150px;" value="2022-01-01"> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-secondary">서버저장</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>