<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세보기</title>
  <style type="text/css">
     span{
       display:inline-block;
       width: 100px;
       font-weight: bold;
     }
  </style>
</head>
<body>
  <h1>마지막 등록한 상품</h1>
    <span>상품 번호:</span>${cookie["no"].value}<br> 
    <span>상 품 명:</span>${cookie.name.value}<br> 
	<span>상품 가격:</span>${cookie.price.value}<br> 
	<span>상품 설명:</span>${cookie.desc.value}<br><br>
    <a href="${root}/product.do?act=modifyForm&no=${cookie.no.value}">상품 수정</a>
    <a href="${root}/product.do?act=remove&no=${cookie.no.value}">상품 삭제</a>
    <a href="${root}/product.do?act=list">상품 목록</a>
</body>
</html>



