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
<h1>EL - 보관소에 값 꺼내기</h1>


<%
pageContext.setAttribute("name", "홍길동");
request.setAttribute("name", "홍길동1");
session.setAttribute("name", "홍길동2");
application.setAttribute("name", "홍길동3");
%>

pageContext 보관소 : ${pageScope.name}<br>
ServletRequest 보관소 : ${requestScope.name}<br>
HttpSession 보관소 : ${sessionScope.name}<br>
ServletContext 보관소 : ${applicationScope.name}
</body>
</html>
