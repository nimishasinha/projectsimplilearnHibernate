package com.simplilearn.servlets;

import java.io.IOException;

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
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void deleteClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int calssId = Integer.parseInt(request.getParameter("class_id"));

			Session s = FactoryProvider.getFactory().openSession();
			ClassRoomPOJO classRoom = s.get(ClassRoomPOJO.class, calssId);
			Transaction tx = s.beginTransaction();
			s.delete(classRoom);

			tx.commit();
			s.close();

			response.sendRedirect("viewClass.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			int teacherId = Integer.parseInt(request.getParameter("teacher_id"));

			Session s = FactoryProvider.getFactory().openSession();
			TeacherPOJO teacher = s.get(TeacherPOJO.class, teacherId);
			Transaction tx = s.beginTransaction();
			s.delete(teacher);

			tx.commit();
			s.close();

			response.sendRedirect("viewTeacher.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int studentId = Integer.parseInt(request.getParameter("student_id"));

			Session s = FactoryProvider.getFactory().openSession();
			StudentPOJO classRoom = s.get(StudentPOJO.class, studentId);
			Transaction tx = s.beginTransaction();
			s.delete(classRoom);

			tx.commit();
			s.close();

			response.sendRedirect("viewStudent.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int subjectId = Integer.parseInt(request.getParameter("subject_id"));

			Session s = FactoryProvider.getFactory().openSession();
			SubjectPOJO subject = s.get(SubjectPOJO.class, subjectId);
			Transaction tx = s.beginTransaction();
			s.delete(subject);

			tx.commit();
			s.close();

			response.sendRedirect("viewSubject.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext context=getServletContext();  
			String n=(String)context.getAttribute("delete"); 
			
			if(n=="deleteClass") {
				deleteClass(request,response);
			}
			else if(n=="deleteStudent") {
				deleteStudent(request,response);
			}
			else if(n=="deleteTeacher") {
				deleteTeacher(request,response);
			}
			else if(n=="deleteSubject") {
				deleteSubject(request,response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
