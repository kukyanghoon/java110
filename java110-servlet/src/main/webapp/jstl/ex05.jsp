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
	<h1>JSTL - c:if</h1>
	<pre>
	- 조건문을 만든다.
	</pre>

<c:set var="name" value="김구"/>
<c:set var="age" value="16"/>
<c:set var="gender" value="woman"/>

<c:if test="${not empty name}">
<p>${name}님 환영합니다</p>
</c:if>
<c:if test="${age lt 19}">
<p>미성년자입니다</p>
</c:if>
<c:if test="${age ge 19}">
<p>성인입니다.</p>
</c:if>


<h2>조건문의 결과를 보관소에 저장하기</h2>

<c:if test="${gender == 'woman'}" var="r1">
var에 변수를 지정하기되면 변수에 값이 저장된다.
    <p>여성입니다.</p>
</c:if>

${pageScope.r1 ? "여성":"남성"}
</body>
</html>
