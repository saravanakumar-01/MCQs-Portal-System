<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses Page</title>
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
    margin: 70px;
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
	<%User user = (User)session.getAttribute("userData");
	  int userId = user.getId();
	%>
	 <nav class="navbar navbar-light bg-white">
        <div class="container-fluid d-flex">
            <span class="mx-auto m-2 h2">Admin Panel</span>
        </div>
    </nav>

    <div class="main">
    
    	<form action="addCourses" method="get">

        <div class="card c3">
            <button class="overlay btn btn-warning">Add New Course</button>

            <div class="mt-5 mx-4 d-flex">
                <p class="form-label mt-1">Course Name:</p>
                <input type="text" name="courseName" class="form-control ans" placeholder="Course Name">
            </div>

            <div class="mx-4 mt-3 d-flex">
                <p class="form-label mt-1">Total Marks:</p>
                <input type="text" name="totalMarks" class="form-control ans" placeholder="Marks">
            </div>

            <div class="mx-4 mt-3 d-flex">
                <p class="form-label mt-1">Exam Time:</p>
                <input type="text" name="time" class="form-control ans" placeholder="MM">
            </div>

            <div class="mt-4 d-flex">
                <input type="submit" value="Add" class="btn show btn-primary mx-auto">
            </div> 
            </form>
            <br>
            <a href="allCourses" class="mt-1 btn show btn-primary mx-auto">Show All Courses</a>
            
     <!--        <form action="allCourses" method="post">
      
              <div class="mt-4 d-flex">
                <input type="submit" value="Show All Courses" class="btn show btn-primary mx-auto">
           </div>
          </form> -->
          <input type="hidden" id="user" name="userId" value="<%= userId %>">
     
            
            
        </div>
        <a href="adminpanel" class="logout-button">Go To Dashboard</a>
        <%@ include file="message.jsp" %>

</body>
</html>
