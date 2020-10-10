<%@page import="com.ssafy.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style type="text/css">
   table{
    border-collapse:collapse;
   }
   table td,th{
	border: 1px solid black;
	padding: 5px 0px;
   }
   table th {
	text-align: center;
	background-color: lightgray;
   }
  </style>
<title>상품목록</title>
</head>
<%-- productList.jsp --%>
<body>
 <h3>상품목록</h3>
 <table>
   <tr>
      <th>상품번호</th>
      <th>상품명</th>
      <th>상품가격</th>
   </tr>
   <%
     List<Product> list = (List<Product>)request.getAttribute("list");
     for(int i=0; i<list.size(); i++){
    	 Product p = list.get(i);
   %> 
   <tr>
      <td><%=p.getNo()%></td>
      <td><a href="product.do?act=detail&no=<%=p.getNo()%>"><%=p.getName()%></a></td>
      <td><%=p.getPrice()%></td>
   </tr>
    	
   <%}%>
 </table>
   <br>
   <a href='product.do?act=registForm'>상품입력하기</a>  
</body>
</html>



