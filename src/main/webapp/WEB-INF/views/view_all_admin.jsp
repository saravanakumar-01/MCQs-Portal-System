<%@page import="mcqs.app.entities.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Admin List</title>
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
        margin-top: 0px;
        background-color: #ffc107;
        padding: 20px;
        width: 100%; /* Set width to 100% */
        box-sizing: border-box; /* Include padding and border in the element's total width and height */
    }

    table {
        border-collapse: collapse;
        width: 80%;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: blue;
        color: #fff;
    }

    .revoke-link, .grant-link {
        background-color: red;
        color: white;
        padding: 6px 10px;
        text-decoration: none;
        border-radius: 4px;
    }
    
    .logout-button {
            display: block;
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 15px;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            background-color: #d32f2f;
        }

        .logout-button:hover {
            background-color: #b71c1c;
        }
</style>
</head>
<body>
<%
    List<User> displayAdminsList = (List<User>) session.getAttribute("allAdminList");
%>
<h1>Admins</h1>
<table>
    <tr>
        <th>id</th> 
        <th>Full Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>DOB</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Access</th>
        <th>Revoke Access</th>
        <th>Grant Access</th>
    </tr>
    <%    
        for(int i = 0; i < displayAdminsList.size(); i++){
        	String active = "";
        	if(displayAdminsList.get(i).isStatus() == true){
        		active = "A";
        	}else{
        		active = "N";
        	}
    %>
        <tr>
            <td><%= i+1 %></td>
            <td><%= displayAdminsList.get(i).getFullName()%></td>
            <td><%= displayAdminsList.get(i).getEmail()%></td>
            <td><%= displayAdminsList.get(i).getMobileNo() %></td>
            <td><%= displayAdminsList.get(i).getDateOfBirth() %></td>
            <td><%= displayAdminsList.get(i).getGender()%></td>
            <td><%= displayAdminsList.get(i).getAddress() %></td>
            <td><%= active %>
            <td><a href="revokeAccess?email=<%= displayAdminsList.get(i).getEmail()%>" class="revoke-link">Revoke</a></td>
            <td><a href="grantAccess?email=<%= displayAdminsList.get(i).getEmail()%>" class="grant-link">Grant</a></td>
        </tr>
    <%
        }
    %>
</table>

<a href="superadminLogout" class="logout-button">Logout</a>
</body>
</html>