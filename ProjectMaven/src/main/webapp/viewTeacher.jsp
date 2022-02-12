<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="org.hibernate.Session"  %>
    <%@ page import="com.simplilearn.FactoryProvider"  %>
     <%@ page import="java.util.*"  %>
      <%@ page import="com.simplilearn.pojo.TeacherPOJO"  %>
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
   Query q=s.createQuery("from TeacherPOJO");
   List<TeacherPOJO> list=q.list();
   
   ServletContext context=getServletContext();  
   context.setAttribute("edit","editTeacher"); 
   context.setAttribute("delete","deleteTeacher"); 
   %>
   <h1>List of Classes</h1>
   <table border="1" cellpadding="10">
				<tr>
					<th>Teacher Id</th>
					<th>Teacher Name</th>
					<th>Operation</th>
				</tr>
   
   <% 
   for(TeacherPOJO teacherlist:list){
	   
	   %>
	   	<tr>
						
						<td><input type="text" name="teacherId"  value=<%=teacherlist.getTeacherId() %>></td>
						<td><input type="text" name="teacherName" value=<%=teacherlist.getTeacherName() %>></td>
						 <td><a href="editTeacher.jsp?teacher_id=<%=teacherlist.getTeacherId() %>">Edit Teacher</a>   <a href="deleteServlet?teacher_id=<%=teacherlist.getTeacherId() %>">Delete Teacher</a></td>
						
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