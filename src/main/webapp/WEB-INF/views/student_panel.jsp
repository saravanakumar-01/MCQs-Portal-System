<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MCQ Examination System</title>
    <style>
        body { 
        	background-image: url('https://wallpapercrafter.com/sizes/3840x2160/278781-an-open-empty-notebook-on-a-white-desk-next-to-an-.jpg');
    background-size: cover;
    /*background-position: center; *//* This will position the background at the bottom center */
    /*background-repeat: no-repeat;*/
		  
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
  h1 {
            color: white;
            margin-top: 50px;
            background-color: #008080;
            padding: 20px; 
        }
         .quotes {
            font-style: italic;
            color: black;
            margin-top: 80px;
        }
                            
        .button-container {
            margin-top: 20px;
        }

        .button {
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

        .button:hover {
            background-color: #3c76c3;
            border-color: #3c76c3;
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
    </style>
</head>
<body>
    <h1>MCQ Examination Portal</h1>
        <div class="quotes">
        <p>Unlock your potential with knowledge. Answer wisely, succeed brilliantly!</p>
    </div>
    <div class="button-container">
    <a href="studentProfile" class="button">Profile</a>
    </div>
    <div class="button-container">
    	<form action="studentExams" id="courseForm">
            <input type="submit" value="Exams" class="button">
    	</form>
    </div>
     <div class="button-container">
    <a href="studentLogout" class="logout-button">Logout</a>
    </div>
    </body>
    </html>