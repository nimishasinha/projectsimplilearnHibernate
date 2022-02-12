package com.simplilearn.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.FactoryProvider;
import com.simplilearn.pojo.ClassRoomPOJO;
import com.simplilearn.pojo.StudentPOJO;
import com.simplilearn.pojo.SubjectPOJO;
import com.simplilearn.pojo.TeacherPOJO;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void editClass(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
    	
try {
			
			int classID= Integer.parseInt(request.getParameter("classlistid"));
			String className= request.getParameter("classlistname");
			
			System.out.println(classID);
			System.out.println(className);
			
			 Session s= FactoryProvider.getFactory().openSession();
			 ClassRoomPOJO classRoom=   s.get(ClassRoomPOJO.class, classID);
			 Transaction tx= s.beginTransaction();
			 classRoom.setClassName(className);
			 
			 tx.commit();
			 
			 s.close();
			 response.sendRedirect("viewClass.jsp");
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
    	
    }
    
    public void editStudent(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
    	
    	try {    System.out.println( "in edit student servlet ");
    				
    			//	int studentId= Integer.parseInt(request.getParameter("classlistid"));
    				int studentId = Integer.parseInt(request.getParameter("studentId"));
    				String studentName= request.getParameter("studentName");
    				String studentEmail= request.getParameter("studentEmail");
    				
    				System.out.println(studentId +"in edit ");
    				//System.out.println(className);
    				
    				 Session s= FactoryProvider.getFactory().openSession();
    				 StudentPOJO student=   s.get(StudentPOJO.class, studentId);
    				 Transaction tx= s.beginTransaction();
    				 student.setStudentName(studentName);
    				 student.setStudentEmail(studentEmail);
    				 System.out.println(studentName +"name in edit ");
    				 System.out.println(studentEmail +"email in edit ");
    				 tx.commit();
    				 
    				 s.close();
    				 response.sendRedirect("viewStudent.jsp");
    				
    			}catch(Exception e) {
    				 e.printStackTrace();
    			}
    	    	
    	    }
    
    
    public void editTeacher(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
    	
    	try {
    		System.out.println("enterd edit teacher servlet");
    				int teacherId= Integer.parseInt(request.getParameter("teacherId"));
    				String teachername= request.getParameter("teacherName");
    				
    				System.out.println(teacherId);
    				System.out.println(teachername);
    				
    				 Session s= FactoryProvider.getFactory().openSession();
    				 TeacherPOJO teacher=   s.get(TeacherPOJO.class, teacherId);
    				 Transaction tx= s.beginTransaction();
    				 teacher.setTeacherName(teachername);
    				 
    				 tx.commit();
    				 
    				 s.close();
    				 response.sendRedirect("viewTeacher.jsp");
    				
    			}catch(Exception e) {
    				 e.printStackTrace();
    			}
    	    	
    	    }
    
    public void editSubject(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
    	
    	try {
    		System.out.println("entered edit subject");
    				int subjectId= Integer.parseInt(request.getParameter("subjectId"));
    				String subjectName= request.getParameter("subjectName");
    				
    				System.out.println(subjectId);
    				System.out.println(subjectName);
    				
    				 Session s= FactoryProvider.getFactory().openSession();
    				 SubjectPOJO subject =   s.get(SubjectPOJO.class, subjectId);
    				 Transaction tx= s.beginTransaction();
    				 subject.setSubjectName(subjectName);;
    				 
    				 tx.commit();
    				 
    				 s.close();
    				 response.sendRedirect("viewSubject.jsp");
    				
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
			
			ServletContext context=getServletContext();  
			String n=(String)context.getAttribute("edit");  
			System.out.println(n + " the value of context");
			if(n=="editClass") {
				editClass(request,response);
			}
			else if(n=="editStudent") {
				editStudent(request,response);
			}
			else if(n=="editTeacher") {
				editTeacher(request,response);
			}
			else if(n=="editSubject") {
				editSubject(request,response);
			}
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

}
