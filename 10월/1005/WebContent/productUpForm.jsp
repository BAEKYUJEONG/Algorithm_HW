<%@page import="com.ssafy.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
  <style type="text/css">
     span{
       display:inline-block;
       width: 80px
     }
  </style>
</head>
<%-- productForm.jsp --%>
<body>
  <%
     Product product = (Product)request.getAttribute("product");     
  %>  
  <h1>상품을 수정 해 주세요.</h1>
  <form method="post" action="product.do">
    <input type="hidden" name="act" value="modify">
    <span>상품 번호:</span><input type="text" name="no" value="<%=product.getNo()%>" readonly><br> 
    <span>상 품 명:</span><input type="text" name="name" value="<%=product.getName()%>"><br> 
	<span>상품 가격:</span><input type="text" name="price" value="<%=product.getPrice()%>"><br> 
	<span>상품 설명:</span><input type="text" name="description" value="<%=product.getDescription()%>"><br><br>
    <button type="submit">저장</button>
    <button type="reset">취소</button>
  </form>
  <br>
  <a href='product.do?act=list'>상품목록보기</a> 
</body>
</html>