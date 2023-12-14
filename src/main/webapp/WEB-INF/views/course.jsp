<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="<c:url value ='/resources/css/style.css'/>" rel="stylesheet">
    
    <style>
    body{
    background-color: rgb(230, 230, 230);
}

.main{
	background-color: red;
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
	 <nav class="navbar navbar-light bg-white">
        <div class="container-fluid d-flex">
            <span class="mx-auto m-2 h2">Admin Panel</span>
        </div>
    </nav>

    <div class="main">

        <div class="card c3">
            <button class="overlay btn btn-warning">Add New Course</button>

            <div class="mt-5 mx-4 d-flex">
                <p class="form-label mt-1">Course Name:</p>
                <input type="text" class="form-control ans" placeholder="Course Name">
            </div>

            <div class="mx-4 mt-3 d-flex">
                <p class="form-label mt-1">Total Marks:</p>
                <input type="text" class="form-control ans" placeholder="Marks">
            </div>

            <div class="mx-4 mt-3 d-flex">
                <p class="form-label mt-1">Exam Time:</p>
                <input type="text" class="form-control ans" placeholder="MM">
            </div>

            <div class="mt-4 d-flex">
                <button class="btn show btn-primary mx-auto">Add</button>
            </div>
        </div>

        <div class="card c4 p-3">
            <button class="overlay-2 btn btn-warning">All Courses</button>

            <div class="mt-5 table-responsive w-75">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Courses</th>
                            <th scope="col">T.Marks</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                </table>
            </div>

        </div>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
