package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dao.MemberDAO;

@WebServlet("/main.do")
public class MainController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private String root="";
    
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		root = request.getContextPath();
		
		String act = request.getParameter("act"); //2.
		System.out.println("Main act>>>"+ act);
    	
    	if(act==null || act.equals("loginForm")) {//1. 로그인폼 요청시
    	   	request.getRequestDispatcher("/index.jsp").forward(request, response);//5.
    	}else if(act.equals("login")) {//1.
    		String id = request.getParameter("id");    	//2.	
    		String pw = request.getParameter("pw");
    		MemberDAO dao = new MemberDAO();//3.
    		if(dao.selectLogin(id,pw)) {//로그인이 잘되었다면
    			request.getSession().setAttribute("login", id);
    		}    		
    	   response.sendRedirect(root+"/main.do?act=loginForm");    		
    	}else if(act.equals("logout")) {
//    	    HttpSession session = request.getSession();
//    	    session.invalidate();
    		request.getSession().invalidate();
    	   response.sendRedirect(root+"/main.do?act=loginForm");    		
    	}
    }//service
}






