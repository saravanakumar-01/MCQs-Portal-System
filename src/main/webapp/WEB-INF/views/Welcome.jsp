<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
      <title>MCQ Portal System</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }

        header {
            background-color: #008080;
            color: #fff;
            padding: 10px;
        }

        .main-content {
            margin-top: 50px;
        }

           .quote-container {
            color: #000;
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .quote {
            font-style: italic;
            font-size: 28px;
            line-height: 1.5;
        }

        .button-container {
            display: flex;
            justify-content: center;
        }

        .login-button {
            padding: 15px 30px;
            margin: 0 10px;
            font-size: 18px;
            background-color: #008080;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-button:hover {
            background-color: #20B2AA;
    </style>
</head>
<body>
    <header>
        <h1>MCQ Portal System</h1>
    </header>

    <div class="main-content">
        <div class="quote-container">
            <p class="quote">"Knowledge is power. Acquire it, master it, and succeed in every challenge."</p>
        </div>

        <div class="button-container">
            <button class="login-button" onclick="redirectToUserLogin()">Get Started</button>
        </div>
    </div>

    <script>
        function redirectToUserLogin() {
            window.location.href = "user_login";
        }
    </script>
</body>
</html>