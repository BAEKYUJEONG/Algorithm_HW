<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
       width: 100px;
       font-weight: bold;
     }
  </style>
</head>
<body>
<%

Cookie cookies[] = request.getCookies();
Map<String,String> map = new HashMap<>();

if(cookies != null) {
	for(Cookie cookie : cookies) {
       map.put(cookie.getName(), cookie.getValue());
	}
}
%>
  <h1>마지막 등록한 상품</h1>
    <span>상품 번호:</span><%=map.get("no") %><br> 
    <span>상 품 명:</span><%=map.get("name") %><br> 
	<span>상품 가격:</span><%=map.get("price") %><br> 
	<span>상품 설명:</span><%=map.get("desc") %><br><br>
    <a href="product.do?act=modifyForm&no=<%=map.get("no") %>">상품 수정</a>
    <a href="product.do?act=remove&no=<%=map.get("no") %>">상품 삭제</a>
    <a href="product.do?act=list">상품 목록</a>
</body>
</html>



