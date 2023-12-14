<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="mcqs.app.entities.User" %>
<%@ page import="mcqs.app.entities.Answers" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Answers</title>
<style>
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
        color: white;
    }
</style>
</head>
<body>
    <%  List<Answers> viewAnswers = (List<Answers>)request.getAttribute("getViewAnswers");
        User user = (User)session.getAttribute("userData");
        int userId = user.getId(); 
    %>

    <table>
        <tr>
            <th>sNo</th>
            <th>Answer</th>
            <th>Correct Answer</th>
        </tr>
        <% int sNo = 0; 
           for(int i=0; i < viewAnswers.size(); i++) {
        %>
        <tr>
            <td><%= ++sNo %></td>
            <td><%= viewAnswers.get(i).getAnswer() %></td>
            <td><%= viewAnswers.get(i).getCorrectAnswer() %></td>
        </tr>
        <% } %>
    </table>

    <input type="hidden" id="user" name="id" value="<%= userId %>">
</body>
</html>