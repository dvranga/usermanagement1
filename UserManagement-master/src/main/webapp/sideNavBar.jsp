<%@ page import="com.bridgelabz.usermanagement.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="css/sideNavBar.css"%>
    </style>
</head>
<body>
<div id="mySidenav" class="sidenav">
    <a href="dashboardController" id="dashboard-id"><i class="ti-dashboard"> </i>Dashboard</a>
    <button class="dropdown-user"><i class="ti-files"></i>  WebPages
        <i class="fa fa-caret-left"></i>
    </button>
    <div class="user-container">
        <a href="webpage1">WebPage  1</a>
        <a href="webpage2">WebPage  2</a>
        <a href="webpage3">WebPage  3</a>

    </div>
    <button class="dropdown-user" id="user-id"><i class="ti-user"> </i>Users
        <i class="fa fa-caret-left"></i>
    </button>
    <div class="user-container">
        <a href="newUser">New  User</a>
        <a href="userListController?action=showUsers&pageId=10">Users  List</a>
    </div>
    <a href="userProfile"><i class="ti-id-badge"> </i>Profile</a>
    <button class="dropdown-user" id="settings-id"><i class="ti-settings"> </i>Settings
        <i class="fa fa-caret-left"></i>
    </button>
    <div class="user-container">
        <a href="authentication">Authentication</a>
        <a href="#">Email SMTP</a>
        <a href="#">Database Connection</a>
    </div>
    <a href="logoutController"><i class="ti-power-off"> </i> Logout</a>
    <div class="tab-close-button">
        <i style="color:white; margin-left: 50px; cursor: pointer"
           class="ti-arrows-horizontal" onclick="toggleNav()"> </i>
    </div>
</div>

<script>

    var dropdown = document.getElementsByClassName("dropdown-user");
    var i;

    for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var dropdownContent = this.nextElementSibling;
            if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
            } else {
                dropdownContent.style.display = "block";
            }
        });
    }

    var userRole=${userRole}
        console.log(userRole, "userRole")

    if(userRole==="Admin"){
        document.getElementById("dashboard-id").style.display="block"
        document.getElementById("user-id").style.display="block"
        document.getElementById("settings-id").style.display="block"

    }
    else if (userRole==="User"){
        document.getElementById("dashboard-id").style.display="none"
        document.getElementById("user-id").style.display="none"
        document.getElementById("settings-id").style.display="none"

    }
    else {
        document.getElementById("dashboard-id").style.display="block"
        document.getElementById("user-id").style.display="block"
        document.getElementById("settings-id").style.display="block"

    }
</script>
</body>
</html>