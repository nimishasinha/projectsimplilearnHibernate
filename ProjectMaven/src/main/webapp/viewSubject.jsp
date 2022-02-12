<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="org.hibernate.Session"  %>
    <%@ page import="com.simplilearn.FactoryProvider"  %>
     <%@ page import="java.util.*"  %>
      <%@ page import="com.simplilearn.pojo.SubjectPOJO"  %>
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
   Query q=s.createQuery("from SubjectPOJO");
   List<SubjectPOJO> list=q.list();
   
   ServletContext context=getServletContext();  
   context.setAttribute("edit","editSubject"); 
   context.setAttribute("delete","deleteSubject"); 
   %>
   <h1>List of Subjects</h1>
   <table border="1" cellpadding="10">
				<tr>
					<th>Subject Id</th>
					<th>Subject Name</th>
					<th>Operation</th>
				</tr>
   
   <% 
   for(SubjectPOJO subjectlist:list){
	   
	   %>
	   	<tr>
						
						<td><input type="text" name="subjectId"  value=<%=subjectlist.getSubjectId() %>></td>
						<td><input type="text" name="subjectName" value=<%=subjectlist.getSubjectName() %>></td>
						 <td><a href="editSubject.jsp?subject_id=<%=subjectlist.getSubjectId() %>">Edit Subject</a>   <a href="deleteServlet?subject_id=<%=subjectlist.getSubjectId() %>">Delete Subject</a></td>
						
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