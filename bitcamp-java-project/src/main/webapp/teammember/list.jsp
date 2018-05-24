<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>팀 보기</title>
<%
String name = (String)request.getAttribute("name");
List<Member> members = (List<Member>)request.getAttribute("members");
%>
</head>
<body>
<h1>팀 보기</h1>
<h2>회원 목록</h2>
<form action='member/add' method='post'>
<input type='text' name='memberId' placeholder='회원아이디'>
<input type='hidden' name='teamName' value='<%=name%>'>
<button>추가</button>
</form>
<table border='1'>
<tr><th>아이디</th><th>이메일></th><th> </th></tr>
<% for (Member member : members) {%>
<tr><td><%=member.getId()%></td>
<td><%=member.getEmail()%></td>
<td><a href='member/delete?teamName=<%=name%>&memberId=<%=member.getId()%>'>삭제</a></td></tr>
<%}%>
</table>
</body>
</html>
    