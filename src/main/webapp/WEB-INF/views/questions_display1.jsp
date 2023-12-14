<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.Questions" %>
<%@ page import="mcqs.app.entities.Course" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Question</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            body{
        background-color: rgb(230, 230, 230);
    }
    
    .main{
        display: flex;
    }
    
    .c1{
        margin: 70px;
        height: 300px;
        width: 500px;
    }
    
    .c3{
        margin: 70px;
        height: 300px;
        width: 450px;
    }
    
    .s-course{
        margin-top: 60px;
    }
    
    .show{
        width: 350px;
        height: 40px;
    }
    
    .c2{
        margin: 70px;
        width: 950px;
    }
    
    .c4{
        margin: 70px;
        width: 750px;
    }
    
    .overlay{
        font-size: 22px;
        position: absolute;
        top:-25px;
        left: 100px;
    }
    
    .overlay-2{
        font-size: 26px;
        position: absolute;
        top:-28px;
        left: 240px;
    }
    
    .ques{
        margin-left: 20px;
        width: 300px;
    }
    
    .options{
        display: flex;
    }
    
    .opt{
        margin-left: 20px;
        width: 130px;
    }
    
    .ans{
        margin-left: 20px;
        width: 240px;
    }
    
    .table-responsive{
        margin-left: 60px;
    }
    
    @media screen and (width<1350px) {
        .options{
            display: block;
        }
    }
    
    @media screen and (max-width:1200px) {
        .main{
            display: block;
        }
    }
            .delete-button {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: red; /* Background color */
            border: none;
            color: white;
            padding: 5px 10px;
            cursor: pointer;
            transition: background-color 0.3s ease; /* Hover effect */
        }

        .delete-button:hover {
            background-color: darkred; /* Hover color */
        }
        </style></head>

<body>
	<% 
	List<Questions> questions = (List<Questions>)request.getAttribute("listOfQuestions");
	%>
    <nav class="navbar navbar-light bg-white">
        <div class="container-fluid d-flex">
            <span class="mx-auto m-2 h2">Exam Panel</span>
        </div>
    </nav>
    <% int sNo = 0; 
		   for(Questions question : questions) { %>
        
            <!-- Delete button for each question -->
            
    <div class="main">
		
        <div class="card c2 p-3">
       <%--  <a href= "deleteQuestions?id=<%= question.getQuestionId() %>" name="questionId" class="delete-button btn btn-danger">Delete</a> --%>
            <div class="card-body">
                <button class="overlay btn btn-warning"><%= ++sNo %></button>
            </div>

            <div class="row d-inline-flex">
                <span class="m-3">
                    Question - <%= question.getQuestionName() %>
                </span>

                <hr>

                <div class="options m-3">
                    <p class="form-label mt-1">Options:</p>
                    <button type="button" class="mx-3 btn btn-outline-dark"><%= question.getOpt1() %></button>    
                    <button type="button" class="mx-3 btn btn-outline-dark"><%= question.getOpt2() %></button>    
                    <button type="button" class="mx-3 btn btn-outline-dark"><%= question.getOpt3() %></button>    
                    <button type="button" class="mx-3 btn btn-outline-dark"><%= question.getOpt4() %></button>
                    <p class="form-label mt-1">Correct Answer:</p>
                    <button type="button" class="mx-3 btn btn-primary"><%= question.getCorrect() %></button>    
                    
                </div>


            </div>
        </div><br>

    </div>
    <% } %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>