<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	<%
	
		String sid = (String) session.getAttribute("sid");
	
	%>
	--%>
	
	<%
	
		if(session.getAttribute("sid") == null) {
			response.sendRedirect("login.jsp");
		}
	
	%>
	
	<h2>로그인 성공</h2>
	<hr>
	<a href="freeboard.do">게시판 바로가기</a><br><br>
	<a href="member.do">회원 정보 바로보기</a><br>
	<h3>${sessionScope.sid}님 환영합니다</h3>
	<a href="logout.do">로그아웃</a>
</body>
</html>