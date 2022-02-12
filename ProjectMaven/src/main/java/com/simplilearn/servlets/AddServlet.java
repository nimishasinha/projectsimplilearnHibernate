package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.FactoryProvider;
import com.simplilearn.pojo.ClassRoomPOJO;
import com.simplilearn.pojo.SubjectPOJO;
import com.simplilearn.pojo.TeacherPOJO;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
      	  
      	  String teacherName = request.getParameter("teacherName");
      	  String teacherSubject = request.getParameter("teacherSubject");
      	String teacherClass = request.getParameter("teacherClass");
      	
      	
      	SubjectPOJO sub = new SubjectPOJO(teacherSubject);
      	 ArrayList<SubjectPOJO> list1=new ArrayList<SubjectPOJO>();  
      	 
      	//  ClassRoomPOJO classroom = new ClassRoomPOJO();
       ClassRoomPOJO classroom = new ClassRoomPOJO(teacherClass);
      	  TeacherPOJO teacher = new TeacherPOJO(teacherName);
      	
       teacher.getClassRoom().add(classroom);
    //  	teacher.getClassRoom().add(classroom);
          list1.add(sub);
          teacher.setSubject(list1);
      	  
      	teacher.setSubject(list1);
         sub.setTeacher(teacher);
      	  System.out.println(teacher.toString());

      	  Session s= FactoryProvider.getFactory().openSession();
      	  Transaction tx = s.beginTransaction();
      	  
      	
      	  s.save(teacher);
      	//  s.save(classroom);
      	  s.save(sub);
      	  tx.commit();
      	  
      	  s.close();
      	  
      	 System.out.print("Teacher Successfully added");
      	 
      	// response.sendRedirect("createClass.jsp");
      	  
      	 response.setContentType("text/html");
      	 
      	  PrintWriter out = response.getWriter();
      	  out.println("<h1><a href=\"logout.jsp\">Logout</a> <br></h1>");
      	  out.println("<h1><a href=\"welcome.jsp\">HOME</a> </h1>");
      	  
      	  out.println("<h1>Teacher Successfully added</h1>");
      	  out.println("<h1><a href='viewTeacher.jsp'>VIEW TEACHER</a></h1>");
      	  
        }catch(Exception e) {
      	  e.printStackTrace();
        }

		 
	}
	
public void addSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
      	  
      	  String subjectName = request.getParameter("subjectName");
      	  
      	  SubjectPOJO subject = new SubjectPOJO(subjectName);
      	  
      	  System.out.println(subject.toString());
      	
      	  Session s= FactoryProvider.getFactory().openSession();
      	  Transaction tx = s.beginTransaction();
      	
      	
      	  s.save(subject);
      	  tx.commit();
      	  
      	  s.close();
      	  
      	 System.out.print("Subject Successfully added");
      	 
      	// response.sendRedirect("createClass.jsp");
      	  
      	 response.setContentType("text/html");
      	 
      	  PrintWriter out = response.getWriter();
      	  out.println("<h1><a href=\"logout.jsp\">Logout</a> <br></h1>");
      	  out.println("<h1><a href=\"welcome.jsp\">HOME</a> </h1>");
      	  
      	  out.println("<h1>Subject Successfully added</h1>");
      	  out.println("<h1><a href='viewSubject.jsp'>VIEW SUBJECT</a></h1>");
      	  
        }catch(Exception e) {
      	  e.printStackTrace();
        }

		 
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("entered Add servlet");
			
			ServletContext context=getServletContext();  
			String n=(String)context.getAttribute("add"); 
			System.out.println("entered Add servlet and value is "  +  n);
			
			if(n=="addTeacher") {
				System.out.println("before add teacher");
				addTeacher(request,response);
			}
			else if(n=="addSubject") {
				System.out.println("before add subject");
				addSubject(request,response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
