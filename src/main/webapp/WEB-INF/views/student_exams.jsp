<%@page import="mcqs.app.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.Course" %>
<%@ page import="mcqs.app.entities.Questions" %>
<%@ page import="mcqs.app.entities.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Questions</title>
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
height: flex;
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
}
	  .button-container {
      display: flex;
      justify-content: center;
    }
   /* Style for the submit button */
    input[type="submit"]
    ,input[type="radio"],
    input[type="text"] {
      background-color: #3498db; /* Blue color */
      color: #fff; /* White text color */
      /* margin-left:350px;
      margin-bottom:30px; */
      padding: 10px 20px; /* Optional: Add padding for better appearance */
      font-size: 16px; /* Optional: Set font size */
      cursor: pointer;
    }
</style>
<span id="remainingTime" style="position: fixed;top:90px;right: 200px;width: 200px;font-size: 50px;background: rgb(255,255,255);border-radius: 5px;padding: 3px;box-shadow: 5px -2px 5px 0px;">
        </span>
<script>
	<% 
	Course courseTime = (Course)request.getAttribute("getTime");
	%>
    var time = <%= courseTime.getTime() %>;
    time--;
    var sec=60;                    
    document.getElementById("remainingTime").innerHTML =  time+" : "+sec;
       //it calls fuction after specific time again and again                  
    var x= window.setInterval(timerFunction, 1000);

function timerFunction(){
        sec--;
  // Display the result in the element with id="demo"
  
 
  if (time < 0) {
    clearInterval(x);
    document.getElementById("remainingTime").innerHTML = "00 : 00";
    var currentDate = new Date();
	   // Extract the date portion
	var currentDateWithoutTime = currentDate.toISOString().split('T')[0];
	document.getElementById('examDate').value = currentDateWithoutTime;
    var endTime = new Date().toLocaleTimeString();
    document.getElementById('endTime').value = endTime;
    document.getElementById("myform").submit();
  }
  document.getElementById("remainingTime").innerHTML =  time+" : "+sec;
if(sec==0){
    sec=60;
    time--;
    
}
}
</script>
   <script type="text/javascript">

	   function captureEndTime() {
		// Get the current date with the time component
		   var currentDate = new Date();
		   // Extract the date portion
		   var currentDateWithoutTime = currentDate.toISOString().split('T')[0];
			document.getElementById('examDate').value = currentDateWithoutTime;
	        var endTime = new Date().toLocaleTimeString();
	        document.getElementById('endTime').value = endTime;
	       
	    }
   </script>
</head>

<body>
	<% 
	List<Questions> questions = (List<Questions>)request.getAttribute("listOfQuestions");
	User user = (User)session.getAttribute("userData");
	int userId = user.getId();
	int courseId = questions.get(0).getCourseId();
	%>
	<form action="examSubmit" id="myform" method="get" onsubmit="captureEndTime()">
	
    <nav class="navbar navbar-light bg-white">
        <div class="container-fluid d-flex">
            <span class="mx-auto m-2 h2">Exam Panel</span>
        </div>
    </nav>
    
    <% int sNo = 0; 
		   for(int i=0;i<questions.size();i++) { %>
    <div class="main" name="courseId">
        <div class="card c2 p-3">
            <div class="card-body">
                <button class="overlay btn btn-warning"><%= ++sNo %></button>
            </div>

            <div class="row d-inline-flex">
                <span class="m-3">
                    Question - <%= questions.get(i).getQuestionName() %>
                </span>

                <hr>
				
                <div class="options m-3">
                    <p class="form-label mt-1">Options:</p>
                    <%-- <input type="hidden" id="questions" name='<%="question"+i%>' value="<%= questionId %>"> --%>
                    <input type="radio" class="mx-3 btn btn-outline-dark" name='<%="ques"+questions.get(i).getQuestionId()%>' value="<%=questions.get(i).getOpt1() %>"><%= questions.get(i).getOpt1() %></button>    
                    <input type="radio" class="mx-3 btn btn-outline-dark" name='<%="ques"+questions.get(i).getQuestionId()%>' value="<%=questions.get(i).getOpt2() %>"><%= questions.get(i).getOpt2() %></button>    
                    <input type="radio" class="mx-3 btn btn-outline-dark" name='<%="ques"+questions.get(i).getQuestionId()%>' value="<%=questions.get(i).getOpt3() %>"><%= questions.get(i).getOpt3() %></button>    
                    <input type="radio" class="mx-3 btn btn-outline-dark" name='<%="ques"+questions.get(i).getQuestionId()%>' value="<%=questions.get(i).getOpt4() %>"><%= questions.get(i).getOpt4() %></button>
                    
                </div>
                <%-- //name='<%="option"+i%>' --%>
	
            </div><br>
         </div>
    </div>
    <% } %>
    <input type="hidden" id="courses" name="courseId" value="<%= courseId %>">
    <input type="hidden" id="user" name="id" value="<%= userId %>">
    <input type="hidden" id="examDate" name="examDate" >
    <input type="hidden" id="endTime" name="endTime">
    <input type="submit" value="Submit" >
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>