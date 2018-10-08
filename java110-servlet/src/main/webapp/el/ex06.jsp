<%@page import="java.util.ArrayList"%>
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
ArrayList<String> nameList = new ArrayList<>();
nameList.add("김구");
nameList.add("윤봉길");
nameList.add("김종규");
pageContext.setAttribute("names", nameList);

%>

<pre>
보관소가 아닌 로컬 변수는 EL에서 사용할 수 없다.
ex) $ { nameList[0]}
</pre>
${names[0]}<br>
${names[1]}<br>
${names[2]}<br>
${names[3]}<br>
${nameList[0]}<br>
</body>
</html>
