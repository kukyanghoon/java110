<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h1>JSTL - c:import</h1>
	<pre>
	- HTTP 요청을 수행하는 코드를 만든다.
	
	</pre>

	<h2>네이버 검색 URL 만들기</h2>
	<c:url value="http://localhost:8888/jstl/ex05.jsp" var="url1">
		<c:param name="name" value="홍길동" />
		<c:param name="age" value="19" />
		<c:param name="gender" value="woman" />
	</c:url>

	<%-- 지정된 url을 요청하고 서버로부터 받은 콘텐트를 contents라는 이름으로
         PageContext보관소에 저장한다.
     --%>
	<c:import url="${url1}" var="contents"></c:import>
	<textarea rows="20" cols="120">${pageScope.contents}</textarea>


</body>
</html>
