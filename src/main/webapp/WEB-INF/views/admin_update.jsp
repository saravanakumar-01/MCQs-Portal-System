<%@page import="mcqs.app.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
      <title>Update Profile</title>
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
            width: 100%;
        }

        section {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
        }

        section p {
            margin: 0 0 10px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        form {
            margin-top: 20px;
        }

        form input[type="text"],
        form input[type="email"],
        form input[type="tel"],
        form input[type="date"],
        form select {
            width: calc(100% - 16px);
            padding: 8px;
            margin-top: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        form input[type="radio"] {
            margin-top: 10px;
            margin-bottom: 10px;
        }
      button {
        background-color: #007BFF; /* Blue color */
        color: #fff;
        border: none;
        padding: 10px 20px;
        margin-left:475px;
        cursor: pointer;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
	String ctx = application.getContextPath();
	//out.print(ctx);
	String targetUrl = ctx + "/admin_update";
	%>
    <form:form modelAttribute="admin" action="<%=targetUrl%>" method="get">
        <header>
            <h1>Update profile</h1>
        </header>
        <form:hidden path="id" />
        <br/>
        <br/>
        <section>
            <label for="name">Name:</label>
            <form:input path="fullName" />
            <br />
            <br/>
            <label for="email">Email:</label>
            <form:input path="email" />
            <br />
            <br/>
            <label for="mobile">Mobile:</label>
            <form:input path="mobileNo" />
            <br />
            <br/>
            <label for="dob">Date of Birth:</label>
            <form:input path="dateOfBirth" />
            <br />
            <br/>
            <label for="gender">Gender:</label>
            <form:radiobutton path="gender" value="Male"/>male
            <form:radiobutton path="gender" value="Female"/>female
            <form:radiobutton path="gender" value="Others"/>other
            <br />
            <br/>
            <label for="address">Address:</label>
            <form:input path="address" /><br />
            <br/>
        </section>

        <button type="submit">Update</button>
    </form:form>
</body>
</html>