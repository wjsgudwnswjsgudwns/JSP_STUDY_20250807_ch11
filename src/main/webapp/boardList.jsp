<%@page import="dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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

<title> 자유 게시판</title>
</head>
<body>
	<!-- 게시판 리스트 -->
	<h2>자유 게시판</h2>
	<table>
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		
		<c:forEach var="boardDto" items="${boardList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				
				<td>
				<!-- 글 제목이 40자 이상일 때 40자 이상은 ... 표시 -->
					<c:choose>
						<c:when test="${fn:length(boardDto.btitle) > 30}">
							<a href="#">${fn:substring(boardDto.btitle, 0 ,40)}...</a>
						</c:when>
						
						<c:otherwise>
							<a href="#">${boardDto.btitle}</a>
						</c:otherwise>
					</c:choose>
				</td>
				
				<td>${boardDto.bwriter}</td>
				<td>${boardDto.bdate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>