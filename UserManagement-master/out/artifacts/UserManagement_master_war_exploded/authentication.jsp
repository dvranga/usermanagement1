<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
    <style>
        <%@include file="css/authentication.css"%>
    </style>
</head>
<jsp:include page="toolBar.jsp"></jsp:include>
<body class="body">
<div class="main" id="main-content">
<div class="title">
    <div class="title-name">Authentication</div>
</div>
<div class="home">
    <div class="home-icon">
        <a><i class="fa fa-home"></i><span class="color">Home</span>&nbsp;/&nbsp;Authentication</a>
    </div>
</div>
<div class="authentication">
    <div class="authentication-box">
        <div class="authentication-header">General</div>
    </div>
    <div class="reminder">
        <label class="switch1">
            <input style="height: 15px" class="check-box" type="checkbox" checked>
            <span class="slider round"></span>
        </label>
        <div class="remind-text"> Allow "Remember Me"</div>
        <div class="helper-text">should "Rememner Me" checkbox be displayed on login form ?</div>
    </div>

    <div class="reminder2">
        <label class="switch1">
            <input style="height: 15px" class="check-box" type="checkbox" checked>
            <span class="slider round"></span>
        </label>
        <div class="remind-text"> Forgot Password</div>
        <div class="helper-text">Enable/Disable forgot password feature</div>
    </div>
    <div class="name">
        Name
    </div>
    <div class="row1">
        <div class="text-center1">
            <input type="text" class="reset1" value="User Management" >

        </div>
    </div>
    <br/>
    <div class="row">
        <div class="text-center">
            <input type="submit"  style="margin-top: -1%" name=submit" value="Update Setting"  class="submit">
        </div>
    </div>

</div>


<div class="authentication1">
    <div class="authentication-box">
        <div class="authentication-header1">Authentication Throttling</div>
    </div>
    <div class="reminder3">
        <label class="switch1">
            <input style="height: 15px" class="check-box" type="checkbox" checked>
            <span class="slider round"></span>
        </label>
        <div class="remind-text1"> Throttle Authentication</div>
        <div class="helper-text1">should the system throttle authentication attempts</div>
    </div>

    <div class="name1">
        Maximum Number of Attempts
    </div>
    <div class="row">
        <div class="text-center22">
            <input type="text" class="reset2" value="3">

        </div>
    </div>
    <div class="helper-text2">Maximum number of incorrect login attempts before lockout</div>
    <div class="name2">
        Lockout Time
    </div>
    <div class="row">
        <div class="text-center33">
            <input type="text" class="reset3" value="3">
        </div>
    </div>
    <div class="helper-text3">Number of minutes to lock out for after specified maximum number</div>
    <div class="row">
        <div class="text-center">
            <input type="submit"  style="margin-top: 1%" name=submit" value="Update Setting"  class="submit2">
        </div>
    </div>

</div>
</div>
</body>
</html>
