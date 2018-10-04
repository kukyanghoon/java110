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
	<h1>JSP:setProperty - 객체의 셋터 호출하기</h1>
	<jsp:useBean scope="request" id="m1"
		class="bitcamp.java110.Member"/>
    <jsp:setProperty name="m1" property="no" value="100"/>
    <jsp:setProperty name="m1" property="name" value="홍길동"/>
    <jsp:setProperty name="m1" property="email" value="hong@gil.dong"/>
    <jsp:setProperty name="m1" property="tel" value="010-1111-1112"/>	
	<p>번호 : <%=m1.getNo() %>, ${m1.no}</p>
	<p>이름 : <%=m1.getName() %>, ${m1.name}</p>
	<p>이메일 : <%=m1.getEmail() %>, ${m1.email}</p>
	<p>전화 : <%=m1.getTel()%>, ${m1.tel}</p>
</body>
</html>