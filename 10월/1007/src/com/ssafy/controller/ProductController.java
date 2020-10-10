package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dao.ProductDAO;
import com.ssafy.dto.Product;

@WebServlet("/product.do")
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private String root="";
	
    @Override
    protected void service(HttpServletRequest request, 
    		               HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");	
      response.setContentType("text/html;charset=UTF-8");
      root = request.getContextPath();
      
      String act = request.getParameter("act");
      System.out.println("Product act>>>"+act);
      
      if(act.equals("registForm")) {
    	  request.getRequestDispatcher("/product/productForm.jsp").forward(request, response);
      }else if(act.equals("regist")) {
	      productCreate(request, response);
      }else if(act.equals("list")) {
    	  productList(request,response);
      }else if(act.equals("detail")) {
    	  productDetail(request, response);   	  
      }else if(act.equals("lastRegist")) {    	  
    	  productLastRegist(request, response);
      }else if(act.equals("modifyForm")) {
    	  productModifyForm(request, response);
      }else if(act.equals("modify")) {
    	  productModify(request, response);
      }else if(act.equals("remove")) {
    	  productRemove(request, response);
      }
      
    }//service
    
    
    private void productCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String no = request.getParameter("no");
    	String name = request.getParameter("name");
	    String price = request.getParameter("price");
	    String description=request.getParameter("description");
	      
	    Product product = new Product(no, name, 
	    		                      Integer.parseInt(price), description);
	    ProductDAO dao = new ProductDAO();
	    if(dao.insert(product)) {
			Cookie cookies[] = new Cookie[] {new Cookie("no",no),
											 new Cookie("name",name),
											 new Cookie("price",price),
											 new Cookie("desc",description)};
			for(Cookie cookie:cookies) {
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 30);//한달간 저장.
				response.addCookie(cookie);
			}
	    	response.sendRedirect(root+"/product.do?act=list");	    	
	    }
	    else
	      response.getWriter().print("<script>alert('ProductRegisterError.\\nInputConfirm~!!');history.back();</script>");
    }//insertList
    
    private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductDAO dao = new ProductDAO();
         request.setAttribute("list", dao.selectAll());
        request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
    }//productList
   
    private void productDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String no = request.getParameter("no");
    	ProductDAO dao = new ProductDAO();
    	request.setAttribute("product", dao.select(no));
    	
    	request.getRequestDispatcher("/product/productDetail.jsp").forward(request, response);    	  
    }//productDetail

    private void productLastRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getSession().getAttribute("login")==null) {
    		response.setContentType("text/html;charset=UTF-8");	    
    		response.getWriter().print("<script>alert('로그인 후 사용하세요!!');history.back();</script>");
    	}
    	else request.getRequestDispatcher("/product/productLastDetail.jsp").forward(request, response);       
    }//productLastRegist

    private void productModifyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String no = request.getParameter("no");
    	ProductDAO dao = new ProductDAO();
    	request.setAttribute("product",dao.select(no));
    	
    	request.getRequestDispatcher("/product/productUpForm.jsp").forward(request, response);    
    }//productModifyForm
    
    private void productModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String no = request.getParameter("no");
    	String name = request.getParameter("name");
    	String price = request.getParameter("price");
    	String description = request.getParameter("description");
    	
    	ProductDAO dao = new ProductDAO();
    	Product product = new Product(no, name, Integer.parseInt(price), description);
    	dao.update(product);
    	response.sendRedirect(root+"/product.do?act=list");
    }//productModify
    
    private void productRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String no = request.getParameter("no");
    	
    	ProductDAO dao = new ProductDAO();
    	dao.delete(no);
    	response.sendRedirect(root+"/product.do?act=list");
    }//productRemove
}

