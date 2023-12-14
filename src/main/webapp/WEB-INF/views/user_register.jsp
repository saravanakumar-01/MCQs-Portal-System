<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
  
   <style>
        body {
            font-family: Arial, sans-serif;
        }

        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type=text],
        input[type=email],
        input[type=password],
        input[type=date],
        input[type=radio],
        input[type=submit],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
         h2 {
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group::after {
            content: "";
            display: table;
            clear: both;
        }

        .form-group label,
        .form-group input {
            float: left;
            width: calc(50% - 10px);
        }

        .form-group input[type="radio"],
        .form-group select {
            width: calc(50% - 4px);
        }

        input[type="submit"] {
            background-color: #3498db; /* Blue background color */
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9; /* Darker blue on hover */
        }

        .login-link {
            text-align: center;
            margin-top: 10px;
        }

        .login-link a {
            color: #3498db;
            text-decoration: none;
        }

        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
    
    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            var dob = document.getElementById("dob").value;
            var gender = document.getElementById("gender").value;
            var mobileNumber = document.getElementById("mobileNumber").value;
            var address = document.getElementById("address").value;
            var role = document.getElementById("role").value;
            var errorLabel = document.getElementById("errorLabel");

            if (!name || !email || !password || !confirmPassword || !dob || !gender || !mobileNumber || !address || !role) {
                errorLabel.innerHTML = "Kindly fill all the required fields.";
                return false;
            }
            
            const minLength = 5;
            const maxLength = 15;

            // Use a regular expression to check the email format

            if (email.includes('@')) {
                //console.log("Valid email address");
                return true;
            } else {
                //console.log("Invalid email address. Please enter an email with 5 to 15 characters, including the '@' symbol.");
                document.getElementById('errorMessage').innerText = "Kindly enter correct format of email address";
                return false;
            }

            if (password !== confirmPassword) {
            	document.getElementById('errorMessage').innerText = "Entered password does not matches confirmpassword ";
                return false;
            }
           
            // Validate mobile number
            if (mobileNumber.length !== 10 && !/^\d+$/.test(mobileNumber)) {
                errorLabel.innerHTML = "Mobile number must be a 10-digit numeric value.";
                return false;
            }

            //Validate password
            var passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%?&#])[A-Za-z\d@$!%*?&#]+$/;

			if (!passwordRegex.test(password)) {
				document.getElementById('errorMessage').innerText = "The password must contain 1 uppercase 1 digit and 1 special character";
			    return false;
			}else{
				return true;
			}
            
            // Show success message and "Login" link
            var successLabel = document.getElementById("successLabel");
            successLabel.innerHTML = "Registration successful! Click <a href='/Login_admin.jsp'>here</a> to login.";


            errorLabel.innerHTML = "";
            return true;
        }
        
    </script>
</head>
<body>

 
    
   <div class="form-container">
    <h2>Registration</h2>
        <form id="registrationForm" action="register" method="post" onsubmit="return validateForm()">
           
                <label for="name">Name</label>
                <input type="text" id="name" name="fullName" placeholder="Your name" required>
           
                <label for="email">Email (This will be your username)</label>
                <input type="email" id="email" name="email" placeholder="Your email" required>
           		<span id="errorMessage" style="color: red;"></span>
           		
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Your password" required>
				<span id="errorMessage" style="color: red;"></span>
				
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" required>
                <div id="passwordError"></div>
                
                <label for="dob">Date of Birth</label>
                <input type="date" id="dob" name="dateOfBirth" required>
            
                <label for="gender">Gender</label>
                <select id="gender" name="gender">
                    <option value="" disabled selected>Select your gender</option>
                    <option id="male" name="gender" value="Male" required>Male</option>
                    <option id="female" name="gender" value="Female" required>Female</option>
                    <option id="transgender" name="gender" value="Others" required>Others</option>
                </select><br><br>
           
                <label for="mobile">Mobile Number</label>
                <input type="text" id="mobileNumber" name="mobileNo" placeholder="Your mobile number" required>
           
                <label for="address">Address</label>
                <input type="text" id="address" name="address" placeholder="Your address" required>
            
                <label for="role">Role</label>
                <select id="role" name="role">
                    <option value="" disabled selected>Select your role</option>                       
                    <option id="admin" name="role" value="2" required>Admin</option>
                    <option id="student" name="role" value="3" required>Student</option>
                </select><br><br>
                
            <input type="submit" value="Register">
            <div id="errorLabel"></div>
            <div id="successLabel" class="success-label"></div> 
            
        </form>

        <div class="login-link">
            <p>Already have an account? <a href="user_login">Login here</a></p>
        </div>
    </div> 
</body>
</html>