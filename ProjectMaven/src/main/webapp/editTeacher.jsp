<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="org.hibernate.Session"  %>
    <%@ page import="com.simplilearn.FactoryProvider"  %>
     <%@ page import="java.util.*"  %>
      <%@ page import="com.simplilearn.pojo.TeacherPOJO"  %>
      <%@ page import="org.hibernate.Query"  %>
      <%@ page import="org.hibernate.Transaction" %>
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

 <h1>Edit the Class Details</h1>
 
 <%
 int teacherId= Integer.parseInt(request.getParameter("teacher_id"));
	
 Session s= FactoryProvider.getFactory().openSession();
 TeacherPOJO teacher=   s.get(TeacherPOJO.class, teacherId);
 Transaction tx= s.beginTransaction();
 
 %>
 <form action="editServlet" method="post">
  <h1>List of Teachers</h1>
   <table border="1" cellpadding="10">
				<tr>
					<th> </th>
					<th>Teacher Name</th>
					<th>Operation</th>
				</tr>
					<tr>
						
						<td><input type="hidden" name="teacherId"  value=<%=teacher.getTeacherId() %>></td>
						<td><input type="text" name="teacherName" value=<%=teacher.getTeacherName() %>></td>
						 <td><button type="submit">SAVE</button>   </td>
						
					</tr>
				
 </form>
</body>
</html>