<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="exam09_error.jsp"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam09</title>
</head>
<body>
<h1>JSP 빌트인 객체</h1>
<pre>
JSP엔진이 JSP 파일을 가지고 서블릿 클래스를 만들 때 
반드시 다음 객체들을 지정된 이름을 사용할 수 있도록 정의해야 한다.
HttpServletRequest  => request
HttpServletResponse => response
JspWriter           => out
HttpSession         => session
ServletContext      => application
PageContext         => pageContext
ServletConfig       => config
서블릿 객체 그 자신  => page
오류 객체            => error

오류 객체?
- 다른 서블릿에서 오류가 발생했을 때 그 오류를 처리하는 JSP는
  오류 정보를 담은 객체를 가질 수 있다.
- 바로 그 객체의 변수명이 error이다.

errorPage 속성
- 오류를 발생했을 때 포워딩할 JSP 페이지를 가리킨다.
- 예) 
</pre>

<%
if (request.getParameter("error") != null) {
    throw new Exception("예외발생");
}
%>
</body>
</html>







