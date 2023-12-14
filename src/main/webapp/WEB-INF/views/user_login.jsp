<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:#f0f8ff; ; /* Light silver background */
            text-align: center;
            margin: 100px;
        }

        form {
            max-width: 300px;
            margin: 0 auto;
            background-color:##f5f5f5; /* White background for the form */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px #888888;
            text-align: left; /* Align form elements to the left */
        }

        input {
            width: calc(100% - 22px); /* Adjusted width for input elements */
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        button {
            background-color: #4285f4;
            color: white;
            padding: 10px 15px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
        }

        .register-container {
            margin-top: 10px;
            display: flex;
            align-items: center;
            justify-content: flex-start;
        }

        .register-text {
            margin-right: 10px;
        }

        .register-link {
            display: block;
        }

        .error-message {
            color: red;
        }
    </style>
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;

            if (username.trim() === "" || password.trim() === "") {
                document.getElementById("error-message").innerHTML = "Please fill in all required fields.";
                return false;
            } else {
                document.getElementById("error-message").innerHTML = "";
                sessionStorage.setItem('loggedInUser', username);
                return true;
            }
        }
    </script>
</head>
<body>
    <form action="login" method="post" onsubmit="return validateForm()">
        <h2>Login</h2>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <button type="submit">Login</button>
        <div class="register-container">
            <span class="register-text">Don't have an account ?</span>
            <a href="user_register" class="register-link">Create new</a>
        </div>
        <div id="error-message" class="error-message"></div>
        
    </form>
   <%@include file="message.jsp" %>
</body>
</html>