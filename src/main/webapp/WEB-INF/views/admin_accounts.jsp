<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.Accounts" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
    <style>
    
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: blue;
            color: white;
        }
        
        .edit-link, .delete-link {
        background-color: red;
        color: white;
        padding: 6px 10px;
        text-decoration: none;
        border-radius: 4px;
        }
    </style> 
</head>
<body>

<% List<Accounts> studentsResults = (List<Accounts>)request.getAttribute("listOfStudentsResults");%>

<h2>Student Details</h2>

<table>
    <thead>
        <tr>
            <th>Serial No.</th>
            <th>Name</th>
            <th>Email</th>
            <th>Date</th>
            <th>Course</th>
            <th>Marks</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
    <%  int sNo = 0;
    	String result = "";
    	for(int i=0;i<studentsResults.size();i++) { 
    	if(studentsResults.get(i).isStatus() == true){
    		result = "Pass";
    	}else{
    		result="Fail";
    	}
    	%>
    	
        <tr>
            <td><%= ++sNo %></td>
            <td><%= studentsResults.get(i).getName() %></td>
            <td><%= studentsResults.get(i).getEmail() %></td>
            <td><%= studentsResults.get(i).getDate() %>
            <td><%= studentsResults.get(i).getCourseName() %></td>
            <td><%= studentsResults.get(i).getMarks() %></td>
            <td><%= result %></td>
        </tr>
        <% } %>
   
    </tbody>
</table>
</body>
</html>