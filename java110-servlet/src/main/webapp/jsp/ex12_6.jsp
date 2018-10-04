<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>JSP:useBean - 사용자 정의 객체 생성 테스트</h1>

	<jsp:useBean scope="request" id="m1"
		class="bitcamp.java110.Member" />


	<p>번호 : <%=m1.getNo() %></p>
	<p>이름 : <%=m1.getName() %></p>
	<p>이메일 : <%=m1.getEmail() %></p>
	<p>전화 : <%=m1.getTel()%></p>
	

</body>
</html>