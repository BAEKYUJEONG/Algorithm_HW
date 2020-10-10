<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품입력</title>
  <style type="text/css">
     span{
       display:inline-block;
       width: 80px
     }
  </style>
</head>
<%-- productForm.jsp --%>
<body>
  <h1>상품을 등록 해 주세요.</h1>
  <form method="post" action="${root}/product.do">
    <input type="hidden" name="act" value="regist">
    <span>상품 번호:</span><input type="text" name="no"><br> 
    <span>상 품 명:</span><input type="text" name="name"><br> 
	<span>상품 가격:</span><input type="text" name="price"><br> 
	<span>상품 설명:</span><input type="text" name="description"><br><br>
    <button type="submit">저장</button>
    <button type="reset">취소</button>
  </form>
  <br>
  <a href='${root}/product.do?act=list'>상품목록보기</a> 
</body>
</html>