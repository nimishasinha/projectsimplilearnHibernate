<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
         <h1>Teacher Management</h1>
		<h2>
			 
			<a href="viewTeacher.jsp">List All Teachers</a>
			<form action="addServlet" method="post">
				<table border="1" cellpadding="10">
					<h1>Add New Teacher</h1>
					<tr>
						<th>Teacher Name</th>
						<td><input type="text" name="teacherName"></td>
					</tr>
					<tr>
						<th>Teacher Subject</th>
						<td><input type="text" name="teacherSubject"></td>
					</tr>
					<tr>
						<th>Teacher ClassName</th>
						<td><input type="text" name="teacherClass"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="hidden"  name="action" value="new"/>
						<input type="submit" value="Add Teacher" /></td>
						
					</tr>
				</table>
				
			</form>
			 <%
  
   
   ServletContext context=getServletContext();  
   context.setAttribute("add","addTeacher"); 
  
   %>
		</h2>

   
</body>
</html>