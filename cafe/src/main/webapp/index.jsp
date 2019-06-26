<%@page import="com.kitri.cafe.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
response.sendRedirect(request.getContextPath()+"/boardadmin/boardmenu");
MemberDto memberDto = new MemberDto();
memberDto.setId("hth0893");
memberDto.setName("형태희");
memberDto.setEmail("hth0893@naver.com");

session.setAttribute("userInfo", memberDto);
%>

