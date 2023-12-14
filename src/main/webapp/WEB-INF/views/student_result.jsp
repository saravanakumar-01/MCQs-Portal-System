<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mcqs.app.entities.User" %>
<%@ page import="mcqs.app.entities.Exams" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result</title>
 <style>
        .panel {
            position: relative;
            padding: 20px;
            margin-top: 60px;
            margin-left: 10px;
            border-radius: 3px;
            background-color: white;
            box-shadow: 0 1px 4px 0 rgba(0, 0, 0, 0.14);
            max-width: 900px;
            float: left;
        }

        .title {
            position: relative;
            height: 40px;
            padding-top: 17px;
            float: left;
            padding-left: 15px;
            padding-right: 15px;
            font-size: 21px;
            color: white;
            border-radius: 4px;
            margin-left: 15px;
            text-align: center;
            margin-top: -45px;
            background: linear-gradient(60deg, #ffa726, #fb8c00);
            box-shadow: 0 4px 20px 0px rgba(0, 0, 0, 0.14), 0 7px 10px -5px rgba(233, 0, 0, 0.4);
        }

        .profile {
            margin-top: 20px;
        }

        .tag {
            font-weight: bold;
            font-size: 20px;
            margin-right: 10px;
        }

        .val {
            margin-bottom: 10px;
            display: block;
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
 		.view-answers-button {
        display: inline-block;
        padding: 7px 8px;
        font-size: 14px;
        text-decoration: none;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        background-color: blue;
        margin-top: 530px;
        margin-left: -280px;
    }

    .view-answers-button:hover {
        background-color: darkblue;
    }
    </style>
</head>
<body>
	<%  Exams exams = (Exams)request.getAttribute("getResult");
		User user = (User)session.getAttribute("userData");
	    int userId = user.getId(); %>
	    
	    <%  String result;
	    	if(exams.isStatus() == true){
	    	result ="Pass";	}else{
	    		result = "Fail";
	    	}
	    	
	    	%>
<div class="panel">
    <div class="title">Result of Recent Exam</div>
    <div class="profile">
        <span class="tag">Exam Date</span><%= exams.getExamDate() %><span class="val" id="examDate"></span><br/>
        <span class="tag">Exam Time</span><%= exams.getExamTime() %><span class="val" id="examTime"></span><br/>
        <span class="tag">Start Time</span><%= exams.getStartTime() %><span class="val" id="startTime"></span><br/>
        <span class="tag">End Time</span><%= exams.getEndTime() %><span class="val" id="endTime"></span><br/>
        <span class="tag">Course Name</span><%= exams.getExamCourse() %><span class="val" id="courseName"></span><br/>
        <span class="tag">Obtained Marks</span><%= exams.getObtMarks() %><span class="val" id="obtMarks"></span><br/>
        <span class="tag">Total Marks</span><%= exams.getTotalMarks() %><span class="val" id="totalMarks"></span><br/>
        <span class="tag">Result</span><%= result %><span class="val" id="resultStatus"></span>
    </div>
    
    <p></p>
    <p></p>
    <p></p>
    <p></p>
    <p></p>
</div>
<input type="hidden" id="user" name="id" value="<%= userId %>">

<a href="studentLogout" class="logout-button">Logout</a>
<a href="studentViewAnswers" class="view-answers-button">Click here to see Answers</a> 


</body>
</html>