<html>

<head>
    <title>User DashBoard</title>
    <style><%@include file="css/toolBar.css"%></style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%User userDetails = (User) session.getAttribute("user");%>

</head>
<body style="margin: 0">

<div class="container">

    <div class="column-header">User Management</div>

    <h5 class="open-button"  onclick="toggleNav()"><i class="ti-arrow-circle-left"id="toggleId"></i></h5>
    <div class="user-name-container">
        <img   style="border-radius: 30%" class="profile-image" src="data:image/jpg;base64,<%=userDetails.getImage()%>" width="40" height="40"  />

        <h4 class="drop-button"><%=userDetails.getUserName()%>
            <div class="dropdown-content">
                <a href="#"><i class="ti-user"></i>  Profile</a>
                <a href="logoutController?userid=<%=userDetails.getUser_id()%>"><i class="ti-power-off"></i>  Logout</a>
            </div>

        </h4
    </div>
</div>
</div>
<script>
    <%@include file="toggleFunction.jsp" %>
</script>
</div>
</body>
</html>