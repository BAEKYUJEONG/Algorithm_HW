<%@page import="com.ssafy.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세보기</title>
  <style type="text/css">
     span{
       display:inline-block;
       width: 80px;
       font-weight: bold;
     }
  </style>
</head>
<body> 
  <h1>상품정보</h1>
    <%
       Product product = (Product)request.getAttribute("product");
    %>
    <span>상품 번호:</span><%=product.getNo() %><br> 
    <span>상 품 명:</span><%=product.getName() %><br> 
	<span>상품 가격:</span><%=product.getPrice() %><br> 
	<span>상품 설명:</span><%=product.getDescription() %><br><br>
    <a href="product.do?act=modifyForm&no=<%=product.getNo() %>">상품 수정</a>
    <a href="product.do?act=remove&no=<%=product.getNo() %>">상품 삭제</a>
    <a href="product.do?act=list">상품 목록</a>
</body>
</html>



