<%@page import="mcqs.app.entities.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Admin Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        header {
            background-color: #ffc107;
            color: #1a0f0f;
            padding: 10px;
            text-align: center;
        }

        section {
        	
            max-width: 500px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        section p {
            margin: 50 0 10px;
        }
        .image{
        text-align:center;
        justify:center;
        
        }

        .edit-button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 6px 10px;
            margin-left:530px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
            width: 100%;
        }

        .edit-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
    User adminProfile = (User) session.getAttribute("updatedAdmin");
%>

<header>
    <h1>Admin Profile</h1>
</header>

<section>
    <div class="image">
    	<img  alt="person" src="https://i.pinimg.com/564x/8a/01/cc/8a01cc0579be056ecc8dfa2f07bd42aa.jpg" width=100px height=100px><br><br>
    	<p><strong>Name :</strong> <%=adminProfile.getFullName() %></p>
        <p><strong>EmailId :</strong> <%=adminProfile.getEmail() %></p>
        <p><strong>MobileNo :</strong> <%=adminProfile.getMobileNo() %></p>
        <p><strong>DateOfBirth :</strong> <%=adminProfile.getDateOfBirth() %></p>
        <p><strong>Gender :</strong> <%=adminProfile.getGender() %></p>
        <p><strong>Address :</strong> <%=adminProfile.getAddress()%></p>
    </div>
 
 
</section>
 <p><a href="updateAdmin?email=<%=adminProfile.getEmail() %>" class="edit-button">Edit Profile</a></p>

</body>
</html>