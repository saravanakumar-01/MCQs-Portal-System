<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>MCQ Examination System</title>
    <style>
        body {
        	background-image: url('https://cutewallpaper.org/27/blog-wallpaper-hd/2116022171.jpg');
            background-size: cover;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }

       h1 {
            color: #333;
            margin-top: 50px;
            background-color: #ffc107;
            padding: 20px; 
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
    <div class="button-container">
    <a href="adminProfile" class="button">Profile</a>
    </div>
    <div class="button-container">
    	<form action="adminCourses" id="courseForm">
            <input type="submit" value="Courses" class="button">
    	</form>
    </div>
    <div class="button-container">
    <a href="adminQuestions" class="button">Questions</a>
    </div>
    <div class="button-container">
    <a href="adminAccounts" class="button">Accounts</a>
    </div>
     <div class="button-container">
        <a href="adminLogout" class="logout-button">Logout</a>
    </div>
    

</body>
</html>