<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style>
        <%@include file="css/profile.css"%>
    </style>
</head>
<body>

<div class="header-panel">
    <%@include file="toolBar.jsp" %>
</div>
<div class="body-panel">
    <div class="sidenav-pannel">
        <%@include file="sideNavBar.jsp"%>
    </div>
    <div class="main-content">

        <div class="title">
            <div class="title-name">Profile
                <p class="tagline">You are logged in on: Aug 30 2020 12:12pm</p>
            </div>
            <div class="title-link">
                <i style="margin-left: 50%" class="fa fa-home"></i>
                <a class="home-icon" href="dashboard">Home</a>
                <a> / profile</a>
            </div>
        </div>

        <div class="profile-pannel">
            <div class="profile-left">
                <div class="profile-main">
                </div>
            </div>
            <div class="profile-right">

            </div>
        </div>


    </div>
</div>
<script>

</script>
</body>
</html>
