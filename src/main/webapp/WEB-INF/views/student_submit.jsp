<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Submitted</title>
    <style>
        body {
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            overflow: hidden;
        }

        p {
            background-color: #ffc107;
            color: black;
            padding: 20px;
            border-radius: 5px;
            font-size: 20px;
            text-align: center;
            margin-bottom: 20px; /* Added margin-bottom */
        }
    button {
            display: inline-block;
            padding: 15px 30px;
            font-size: 16px;
            margin: 10px;
            text-align: center;
            text-decoration: none;
            background-color: #4285f4;
            color: #fff;
            border: 1px solid #4285f4;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #3c76c3;
            border-color: #3c76c3;
        }
   
    </style>
</head>

<body>
	<% 
	Course courseTime = (Course)request.getAttribute("getTime");
	%>
    <form action="studentResults" method="get">
        <p>Your Test is Submitted Successfully</p>
        <input type="submit" value="View Result">
    </form>

</body>
</html>