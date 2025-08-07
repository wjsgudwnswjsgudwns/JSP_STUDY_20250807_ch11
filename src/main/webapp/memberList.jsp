<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>회원 정보</title>

<style type="text/css">
	table {
	width: 800px;
	border-collapse: collapse;
	}
	th, td {
	border: 1px solid; #dddddd;
	padding: 10px;
	text-align: center;
	}
	th {
	background-color: #f5f5f5;
	}
</style>

</head>
<body>
	<h2>회원 정보</h2>
	<hr>
	
	<table>
		<tr>
			<th>No.</th>
			<th>회원 아이디</th>
			<th>회원 이름</th>
			<th>회원 나이</th>
			<th>회원 등록일</th>
		</tr>
		
		<c:forEach var="memberDto" items="${memberList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${memberDto.mid}</td>
				<td>${memberDto.mname}</td>
				<td>${memberDto.mage}</td>
				<td>${memberDto.mdate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="javascript.history.go(-1);">뒤로가기</a>
</body>
</html>