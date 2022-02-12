package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.simplilearn.FactoryProvider;
import com.simplilearn.pojo.ClassRoomPOJO;
import com.simplilearn.pojo.StudentPOJO;


public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
       	  
       	  String studentName= request.getParameter("studentName");
       	String studentEmail= request.getParameter("studentEmail");
       	String studentClass= request.getParameter("studentClass");
       	
       	ClassRoomPOJO c = new ClassRoomPOJO(studentClass);
       	
       	  StudentPOJO student = new StudentPOJO(studentName,studentEmail);
       	   
       	 // c.getclasstId();
       	  student.setClassRoom(c);
       	//  c.setStudent(student);
       	//  c.setClassName(studentClass);
       	   int id= student.getStudentId();
       	System.out.println(id);
       	  System.out.println(student.toString());
       	  
       	  Session s= FactoryProvider.getFactory().openSession();
       	  Transaction tx = s.beginTransaction();
       	  
			/*
			 * Query q=s.createQuery("from ClassRoomPOJO"); List<ClassRoomPOJO>
			 * list=q.list(); for(ClassRoomPOJO classList:list) {
			 * 
			 * }
			 */
        
        
       	
       	  s.save(student);
        s.save(c);
       	  tx.commit();
       	  
       	  s.close();
       	  
       	 System.out.print("Student Successfully added");
       	 
      // 	 response.sendRedirect("createStudent.jsp");
       	  
       	 response.setContentType("text/html");
       	 
       	  PrintWriter out = response.getWriter();
       	  out.println("<h1><a href=\"logout.jsp\">Logout</a> <br></h1>");
       	  out.println("<h1><a href=\"welcome.jsp\">HOME</a> </h1>");
       	  
       	  out.println("<h1>Student Successfully added</h1>");
       	  out.println("<h1><a href='viewStudent.jsp'>VIEW STUDENTS</a></h1>");
       	  
         }catch(Exception e) {
       	  e.printStackTrace();
         }

	}

}
