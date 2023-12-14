<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" %>
<%@ page import="mcqs.app.entities.Course" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin All Courses</title>
<style>
 body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
 h1 {
            color: #333;
            margin-top: 50px;
            background-color: #ffc107;
            text-align:centre;
            padding: 20px; 
        }
        
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    
    th, td {
      border: 1px solid black;
      padding: 12px;
      text-align: centre;
    }
    th {
      background-color: blue;
      color: white;
    }
	.back-button {
	  display: inline-block;
	  padding: 10px 20px;
	  background-color: black;
	  color: white;
	  text-decoration: none;
	  border-radius: 5px;
	  margin-top: 20px;
	}
	.back-button:hover {
	  background-color: green;
	}
    .delete-button {
    display: inline-block;
    padding: 8px 15px;
    background-color: red;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    margin-top: 5px;
}

.delete-button:hover {
    background-color: darkred;
}

/* Add this style if you want to align the buttons to the center */
.table-actions {
    text-align: center;
    margin-top: 20px;
}
  </style>
</head>
<body>

	<% 
	List<Course> courseList = (List<Course>)request.getAttribute("listOfCourses");
	%>


	        <div class="card c4 p-3">
            <h1 class="overlay-2 btn btn-warning">All Courses</h1>

            <div class="mt-5 table-responsive w-75">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Courses</th>
                            <th scope="col">Total Marks</th>
                            <th scope="col">Time</th>
                        </tr>
                    </thead>
                        	<%for(Course allcourse : courseList) {%>
                        <tr>
                        	<td><%= allcourse.getCourseName() %></td>
                        	<td><%= allcourse.getTotalMarks() %></td>
                        	<td><%= allcourse.getTime() %></td>
                        </tr>
                        
                  <% } %>
                        
                </table>
            </div>
        </div>
        

</body>
</html>