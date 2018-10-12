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
<h1>EL 표기법</h1>
<pre>
- EL(Expression Language)은 콤마(.)와 대괄호([]) 등을 사용하여 객체의 
    property, list, set, map 객체의 값을 쉽게 꺼내고 설정하게 도와주는 문법이다.
        특히 값을 꺼낼 때는 OGNL표기법을 사용한다.
- OGNL(Object Graph Navigation Language)?
        객체의 프로퍼티 값을 가리키는 문법이다.
        파일의 경로처럼 객체에 포함된 객체를 탐색하여 값을 쉽게 조회할 수 있다.
- 문법
    $ { 객체명.프로퍼티명.프로퍼티명.프로퍼티명 }
    $ { 객체명["프로퍼티명"]["프로퍼티명"]["프로퍼티명"]}
- EL에서 사용할 수 있는 객체?
    pageContext = JSP의 PageContext객체
    
    servletContext - $ { pageContext.servletContext.프로퍼티명 }
                        자바코드 : pageContext.getservletContext().get프로퍼티()
                        
    session - $ { pageContext.session.프로퍼티명 }
                              예) $ { pageContext.session.name}
                   => pageContext.getSession().getName();
                   
    request - $ { pageContext.request.프로퍼티명 }
    
    response
    
    param - $ { param.프로퍼티명 }
                 => request.getParameter("파라미터명");
                 
    paramValues - $ { paramValues.파라미터명}
                 => request.getParameterValues("파라미터명");
                 
    header - $ { header.헤더명 }
                 => request.getHeader("헤더명");
                 
    headerValues - $ { headerValues.헤더명 }
                 => request.getHeaderㄴ("헤더명");
                 
    cookie - $ { cookie.쿠키명 }
    
    initParam - $ { initParam.파라미터명 }
    
        보관소에서 값을 꺼내기
    
    pageScope - $ { pageScope.객체이름 }
                    => pageContext.getAttribute("객체이름");
                    
    requestScope - $ { requestScope.객체이름 }
                    => request.getAttribute("객체이름");

    sessionScope - $ { sessionScope.객체이름 }
                    => session.getAttribute("객체이름");
                                         예) $ { sessionScope.name }
                         => session.getAttribute("name");

    applicationScope - $ { applicationScope.객체이름 }
                    => application.getAttribute("객체이름");
     

</pre>


</body>
</html>