<%@page import="bitcamp.java110.Member"%>
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
<h1>EL - 일반객체에서 값 꺼내기</h1>

<%
Member memb = new Member();
memb.setNo(100);
memb.setName("홍길동");
memb.setEmail("hong@test.com");
memb.setTel("1111-2222");

pageContext.setAttribute("memb", memb);

%>
${memb.no}<br>
${memb["no"]}<br>
${memb['no']}<br>
${memb.getNo()}<br>
</body>
</html>
