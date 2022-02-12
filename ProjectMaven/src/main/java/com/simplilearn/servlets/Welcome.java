package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entered servlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("login.jsp").include(request, response);
		
		String name = request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(name);
		System.out.println(password);
		
		//String value = null;
		
		
		if(password.equals("admin@123")){  
	        out.print("Welcome, "+name);  
	        HttpSession session=request.getSession();  
	        session.setAttribute("name",name); 
	        response.sendRedirect("welcome.jsp");
	        }  
	        else{  
	            out.print("Sorry, username or password error!");  
	            request.getRequestDispatcher("login.html").include(request, response);  
	        }  
	        out.close();  
	}

}
