<%@page import="mcqs.app.entities.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admins List</title>
<style>
    body {
        background-image: url('https://blog.hackerrank.com/wp-content/uploads/HackerRank_RemoteHiringUpdates.png');
    background-size: cover;
    background-position: center bottom; /* This will position the background at the bottom center */
    background-repeat: no-repeat;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
    }

    h3 {
        text-align: center;
    }

    a {
        display: inline-block;
        margin-bottom:50px;
        padding: 7px 8px;
        background-color: white;
        color: blue;
        text-decoration: none;
        border-radius: 2px;
        transition: background-color 0.3s ease;
    }

    a:hover {
        background-color: #1E90FF;
    }
</style>
</head>
<body>

<h3><a href="displayAdmins">View All Admins</a></h3>

</body>
</html>