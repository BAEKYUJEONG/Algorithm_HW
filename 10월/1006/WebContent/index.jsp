<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
  <style type="text/css">
    h1,div{
      text-align: center;
    }
  </style>
</head>
<body>
 <h1>메인 페이지</h1>
 <%if(session.getAttribute("login")==null){ %>
 <%@include file="/member/login.jsp" %>
 <%} %>
 <div style="margin-top: 10px">
    <a href="${root}/product.do?act=registForm">상품 등록</a>&nbsp;&nbsp;&nbsp;
    <a href="${root}/product.do?act=list">상품 목록</a>&nbsp;&nbsp;&nbsp;
    <a href="${root}/product.do?act=lastRegist">마지막 등록한 상품</a>
 </div>
</body>
</html>