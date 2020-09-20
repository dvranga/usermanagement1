<html>
<head>
    <title>Recover Password</title>
    <style><%@include file="css/forgotPassword.css"%></style>
</head>
<body style="background-color: lavender">
<div class="container">

    <div class="container1">
        <div><img src="images/mi.jpeg"></div>
        <div/>
        <div class="container2">
            <div class="recover">Recover Password</div>
            <div class="sub-container">
                <div/>
                <p class="para">Please enter your email address below to receive the password at your<br/>registered
                    email</p>
                <div/>
                <form action="forgotPasswordController" method="post">
                    <input class="emailInput" type="text" name="email" placeholder="  Enter your email" />
                    <br/>
                    <input type="submit" name="email" value="RECOVER PASSWORD"
                           class="btn btn-primary btn-lg btn-block">
                </form>
                <div class="endTag">Know your password? &nbsp;<a href="login" >Login</a></div>&nbsp;
            </div>
        </div>
    </div>
</div>
</body>
</html>