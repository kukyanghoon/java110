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
	<h1>JSTL - c:choose</h1>
	<pre>
	- 다중 조건문을 만든다.
	- java의 switch와 유사하다
	</pre>

<c:set var="name" value="김구"/>
<c:set var="age" value="65"/>

<c:choose>
    <c:when test="${age lt 19 }">
        <p>미셩년입니다.</p>
    </c:when>
    <c:when test="${age ge 19 and age lt 65 }">
        <p>성년입니다.</p>
    </c:when>
    <c:otherwise>
        <p>노인입니다</p>
    </c:otherwise>
</c:choose>
${pageScope.r1}
</body>
</html>
