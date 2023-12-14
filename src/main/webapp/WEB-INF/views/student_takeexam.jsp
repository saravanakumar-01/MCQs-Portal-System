<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.Course" %>
<%@ page import="mcqs.app.entities.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Take Exam</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body{
    background-color: rgb(230, 230, 230);
}

.main{
    display: flex;
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



.overlay{
    font-size: 22px;
    position: absolute;
    top:-25px;
    left: 100px;
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
    </style>
</head>

<body>
	<% 
	List<Course> exams = (List<Course>)request.getAttribute("listOfExams");
	int courseId = exams.get(0).getCourseId();
	User user = (User)session.getAttribute("userData");
	int userId = user.getId();
	%>
	<script type="text/javascript">
     function captureStartTime() {
    	 var courseId = <%= courseId %>;
    	 var userId = <%= userId %>;
         var startTime = new Date().toLocaleTimeString();
         document.getElementById('startTime').value = startTime;
     }
    </script>
    <nav class="navbar navbar-light bg-white">
        <div class="container-fluid d-flex">
            <span class="mx-auto m-2 h2">Student Panel</span>
        </div>
    </nav>

    <div class="main">
    
    	<form action="studentQuestions" method="get" onsubmit="captureStartTime()">

        <div class="card c3">
            <button class="overlay btn btn-warning">Select course to take exam</button>
            <div class="row s-course mx-auto d-inline-flex">
                <h5 class="mx-5">Select Course</h5>
                <select class="w-75 btn btn-light mx-5" name="courseId">
                	<%for(Course course : exams) {%>
                     <option value="<%= course.getCourseId() %>"><%= course.getCourseName() %></option>
                     <% } %>
                </select>
            </div>
            <input type="hidden" id="user" name="userId" value="<%= userId %>">
            <input type="hidden" id="course" name="courseId" value="<%= courseId %>">
			<input type="hidden" id="startTime" name="startTime">
            <div class="mt-5 d-flex">
                <input type="submit" value="Take Exam" class="btn show btn-primary mx-auto" onclick="takeExam()">
            </div>
        </div>

	</form>
    </div>
    <%@ include file="message.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>