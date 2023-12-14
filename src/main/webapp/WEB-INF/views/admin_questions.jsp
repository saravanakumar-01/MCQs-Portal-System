<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.Course" %>
<%@ page import="mcqs.app.entities.Questions" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Questions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<c:url value ='/resources/css/style.css'/>" rel="stylesheet">
<style>
body{
    background-color: rgb(230, 230, 230);
}

.main{
    display: flex;
}

.c1{
    margin: 150px;
    height: 300px;
    width: 500px;
}

.c3{
    margin: 70px;
    height: 350px;
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
height:550px;
    margin: 70px;
    width: 750px;
}

.c4{
    margin: 70px;
    width: 750px;
}

.overlay{
    font-size: 22px;
    position: absolute;
    top:-25px;
    left: 120px;
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

.add-btn{
height:45px;}

@media screen and (width<1350px) {
    .options{
        display: block;
    }
}

@media screen and (max-width:1200px) {
    .main{
        display: block;
    }
}</style>
</head>

<body>
	<% 
	List<Course> courses = (List<Course>)request.getAttribute("listOfCourses");
	%>
	
    <nav class="navbar navbar-light bg-white">
        <div class="container-fluid d-flex">
            <span class="mx-auto m-2 h2">Admin Panel</span>
        </div>
    </nav>

    <div class="main">
    
    <form action="addQuestions" class="d-flex" method="post"> 

        <div class="card c2 p-3">
            <div class="card-body">
                <button class="overlay-2 btn btn-warning">Add New Question</button>
            </div>

            <div class="row d-inline-flex">
                <span class="m-3">Course Name
                <select class="mx-4 w-75 btn-light p-2" name="courseId">
                <%for(Course course : courses ) {%>
                        <option value="<%= course.getCourseId() %>"><%= course.getCourseName() %></option>
                    
                    <% } %>
                  </select>
                </span>

                <div class="m-3 d-flex">
                    <p class="form-label mt-1">Question:</p>
                    <input type="text" name="questionName" class="form-control ques" placeholder="Type your question here">
                </div>

                <div class="options m-3">
                    <p class="form-label mt-1">Options:</p>
                    <input type="text" name="opt1" class="form-control opt" placeholder="First Option">
                    <input type="text" name="opt2" class="form-control opt" placeholder="Second Option">
                    <input type="text" name="opt3" class="form-control opt" placeholder="Third Option">
                    <input type="text" name="opt4" class="form-control opt" placeholder="Fourth Option">
                </div>

                <div class="m-3 d-flex">
                    <p class="form-label mt-1">Correct Answer:</p>
                    <input type="text" name="correct" class="form-control ans" placeholder="Correct Answer">
                </div>

            </div>


            <div class="card-body mt-5 d-flex">
                <button class="btn w-75 add-btn btn-primary mx-auto">Add</button>
            </div>
        </div>
		</form>
		<form action="viewQuestions" method="get">
			<div class="card c1">
            <button class="overlay btn btn-warning">Show All Questions for</button>

            <div class="row s-course mx-auto d-inline-flex">
                <h5 class="mx-3">Select Course</h5>
                <select class="mx-4 w-75 btn-light p-2" name="courseId">
                <%for(Course course : courses ) {%>
                    <option value="<%= course.getCourseId() %>"><%= course.getCourseName() %></option>
                <% } %>
               </select>
            </div>

            <div class="mt-5 d-flex">
                <input type="submit" value="show" class="btn show btn-primary mx-auto">
            </div>
        </div>
		</form>
    </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>