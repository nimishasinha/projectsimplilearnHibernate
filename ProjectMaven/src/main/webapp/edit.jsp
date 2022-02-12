<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.hibernate.Session"  %>
    <%@ page import="com.simplilearn.FactoryProvider"  %>
     <%@ page import="java.util.*"  %>
      <%@ page import="com.simplilearn.pojo.ClassRoomPOJO"  %>
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
 int calssId= Integer.parseInt(request.getParameter("class_id"));
	
 Session s= FactoryProvider.getFactory().openSession();
 ClassRoomPOJO classRoom=   s.get(ClassRoomPOJO.class, calssId);
 Transaction tx= s.beginTransaction();
 
 %>
 <form action="editServlet" method="post">
  <h1>List of Classes</h1>
   <table border="1" cellpadding="10">
				<tr>
					<th> </th>
					<th>Class Name</th>
					<th>Operation</th>
				</tr>
					<tr>
						
						<td><input type="hidden" name="classlistid"  value=<%=classRoom.getclasstId() %>></td>
						<td><input type="text" name="classlistname" value=<%=classRoom.getClassName() %>></td>
						 <td><button type="submit">SAVE</button>   </td>
						
					</tr>
				
 </form>
</body>
</html>