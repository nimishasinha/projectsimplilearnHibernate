<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="org.hibernate.Session"  %>
    <%@ page import="com.simplilearn.FactoryProvider"  %>
     <%@ page import="java.util.*"  %>
      <%@ page import="com.simplilearn.pojo.StudentPOJO"  %>
      <%@ page import="org.hibernate.Query"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>
			<a href="logout.jsp">Logout</a> <br>
			<a href="welcome.jsp">HOME</a> 
		</h2>
  
   <%
   Session s= FactoryProvider.getFactory().openSession(); 
   Query q=s.createQuery("from StudentPOJO");
   List<StudentPOJO> list=q.list();
   ServletContext context=getServletContext();  
   context.setAttribute("edit","editStudent");  
   context.setAttribute("delete", "deleteStudent");
   %>
   <h1>List of Classes</h1>
   <table border="1" cellpadding="10">
				<tr>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>Student Email</th>
					
					<th>Operation</th>
				</tr>
   
   <% 
   for(StudentPOJO studentlist:list){
	   
	   %>
	   	<tr>
						
						<td><input type="text" name="studentlistId"  value=<%=studentlist.getStudentId() %>></td>
						<td><input type="text" name="studentlistName" value=<%=studentlist.getStudentName() %>></td>
						<td><input type="text" name="studentlistEmail" value=<%=studentlist.getStudentEmail() %>></td>
						
						 <td><a href="editstudent.jsp?student_id=<%=studentlist.getStudentId() %>">Edit Student</a>   <a href="deleteServlet?student_id=<%=studentlist.getStudentId() %>">Delete Student</a></td>
						
					</tr>
		
	  <% 
   }
   %>
   </table>
   <% 
   s.close();
   %>
  

</body>
</html>