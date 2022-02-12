package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.FactoryProvider;
import com.simplilearn.pojo.ClassRoomPOJO;
import com.simplilearn.pojo.SubjectPOJO;

public class ClassRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClassRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	          try {
	        	  
	        	  String classRoomName = request.getParameter("classRoomName");
	        	  
	        	  ClassRoomPOJO classroom = new ClassRoomPOJO(classRoomName);
	        	  
	        	  SubjectPOJO subject=new SubjectPOJO();
	        	  classroom.getSubjects().add(subject);
	        	 // classroom.setSubjects((List<SubjectPOJO>) subject);
	        	 // subject.setClassRoom((List<ClassRoomPOJO>) classroom);
	        	  System.out.println(classroom.toString());
	        	  
	        	  Session s= FactoryProvider.getFactory().openSession();
	        	  Transaction tx = s.beginTransaction();
	        	  
	        	
	        	  s.save(classroom);
	        	  s.save(subject);
	        	  tx.commit();
	        	  
	        	  s.close();
	        	  
	        	 System.out.print("ClassRoom Successfully added");
	        	 
	        	// response.sendRedirect("createClass.jsp");
	        	  
	        	 response.setContentType("text/html");
	        	 
	        	  PrintWriter out = response.getWriter();
	        	  out.println("<h1><a href=\"logout.jsp\">Logout</a> <br></h1>");
	        	  out.println("<h1><a href=\"welcome.jsp\">HOME</a> </h1>");
	        	  
	        	  out.println("<h1>ClassRoom Successfully added</h1>");
	        	  out.println("<h1><a href='viewClass.jsp'>VIEW CLASSROOM</a></h1>");
	        	  
	          }catch(Exception e) {
	        	  e.printStackTrace();
	          }
	
	}

}
