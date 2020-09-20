<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <style><%@include file="css/login.css"%>
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script>
        function validateForm() {
            var userName = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var returnValue = true;
            if (userName == "") {
                document.getElementById('username-empty').innerHTML="Username is required.";
                document.getElementById('username').className = 'username-null';
                returnValue = false;
            } else {
                document.getElementById('username-empty').innerHTML="";
                document.getElementById('username').className = 'username-not-null';
            }
            if(password == "" ){
                document.getElementById('password-empty').innerHTML="The password is required.";
                document.getElementById('password').className = 'password-null';
                returnValue = false;
            } else {
                document.getElementById('password-empty').innerHTML="";
                document.getElementById('password').className = 'password-not-null';
            }
            return returnValue;
        }
    </script>
</head>
<body>


<div class="container">
    <div class="login-form">
        <div>
            <img src="images/mi.jpeg">
            <p>Login to your account</p>
        </div>
        <form action="AdminController" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="   Username" name="username" id="username" required="required"
                pattern="^[A-Z].{6,}$">
                <span class="error-username" id="username-empty"></span>
            </div><br/>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="  Password" name="password" id="password" required="required"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
                <span class="error-password" id="password-empty"></span>
            </div><br/>
            <div class="reminder">
                <label class="switch1">
                    <input style="height: 15px" class="check-box" type="checkbox" checked>
                    <span class="slider round"></span>
                </label>
                <span>Remember Me</span>
            </div>
            <input type="submit" name="login" value="LOGIN" class="btn btn-primary btn-lg btn-block" onclick="return validateForm()">
        </form>
        <i class="fa fa-lock" style="margin-left: -140px"></i>
        <a  style="margin-top: -15px" href="forgotPassword">Forgot Password?</a>
    </div>
    <div class="app-name">
        <div class="bg-color">
            <div class="app-text">
                User Management
                <p>Version 2.2</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>





