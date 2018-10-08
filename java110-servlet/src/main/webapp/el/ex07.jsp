<%@page import="java.util.HashMap"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
<h1>EL - 배열에서 값 꺼내기</h1>

<%
HashMap<String, Object> map = new HashMap<>();
map.put("s01", "김구");
map.put("s02", "윤봉길");
map.put("s03", "유관순");
pageContext.setAttribute("map", map);

%>
${map["s01"]}<br>
${map['s02']}<br>
${map.s03}<br>
</body>
</html>
