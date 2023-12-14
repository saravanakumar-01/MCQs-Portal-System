<%@page import="mcqs.app.entities.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Student Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        header {
            background-color: #008080;
            color: white;
            padding: 10px;
            text-align: center;
        }

        section {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        section p {
            margin: 0 0 10px;
        }
           .image{
        text-align:center;
        justify:centre;
        
        }

        .edit-button {
            background-color: red;
            color: #fff;
            border: none;
            padding: 10px 20px;
            margin-left:480px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .edit-button:hover {
            background-color: #B22222;
        }
    </style>
</head>
<body>

<%
    User studentProfile = (User) session.getAttribute("updatedStudent");
%>

<header>
    <h1>Student Profile</h1>
</header>

<section>
    <div class="image">
    	<img  alt="person" src="https://t4.ftcdn.net/jpg/00/65/77/27/360_F_65772719_A1UV5kLi5nCEWI0BNLLiFaBPEkUbv5Fv.jpg" width=100px height=100px><br>
        <p><strong>Name :</strong> <%=studentProfile.getFullName() %></p>
        <p><strong>EmailId :</strong> <%=studentProfile.getEmail() %></p>
        <p><strong>MobileNo :</strong> <%=studentProfile.getMobileNo() %></p>
        <p><strong>DateOfBirth :</strong> <%=studentProfile.getDateOfBirth() %></p>
        <p><strong>Gender :</strong> <%=studentProfile.getGender() %></p>
        <p><strong>Address :</strong> <%=studentProfile.getAddress()%></p>
    </div>
    
   
</section>
 <p><a href="updateStudent?email=<%=studentProfile.getEmail() %>" class="edit-button">Edit Profile</a></p>

</body>
</html>