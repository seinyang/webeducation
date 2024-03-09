<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--패키지 임포트도 해줌--%>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024-03-09
  Time: 오후 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //여기안에 자바코드도 넣을수있음
    MemberRepository memberRepository= MemberRepository.getInstance();
//파라미터를 만들고 데이터를 불러와서 저장
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username,age);
    memberRepository.save(member);
%>
<%--퍼센트 표시가 없는거는 리스폰스에 저 바디가 다담긴다고 생각하면됨--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="<c:url value="/index.html"/>">메인</a>
</body>
</html>
