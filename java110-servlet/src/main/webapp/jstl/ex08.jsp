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
	<h1>JSTL - c:forTokens</h1>
	<pre>
	- 반복문을 만든다.
	- 구분자를 지정가능 
	</pre>

    <h2>CSV(Comma Seperated value)</h2>
<%
pageContext.setAttribute("names4", "홍길동,임꺽정,유관순,김구");
%>
    
    
<ul>
<c:forTokens items="${pageScope.names4}" var="n3" delims=",">
    <li>${n3}</li>    
</c:forTokens>
</ul>

    <h2>Query String 문자열</h2>
<%
pageContext.setAttribute("qs", "name=홍길동&age=20");
%>
    
    
<ul>
<c:forTokens items="${pageScope.qs}" var="qs" delims="&">
    <li>${qs}</li>    
</c:forTokens>
</ul>

</body>
</html>
