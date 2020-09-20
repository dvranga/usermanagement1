<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<div class="main-container">
    <%@include file="toolBar.jsp"%>
    <div class="container">
        <%@include file="sideNavBar.jsp"%>
        <div class="main-content" id="main-content">
            <div class="content-heading">
                <div class="page-title">
                    Profile<br> <span class="page-description">You last
							logged in on: </span>
                </div>
                <div class="home-link">
                    <a href="dashboard"><i class="ti-home"></i> Home</a> / Profile
                </div>
            </div>







            <div class="content-body">
                <div class="profile-left">
                    <div class="profile-left-image-bg">
                        <div class="profile-img">
                            <div class="image-div"><img src="data:image/jpg;base64" alt="profile-img"></div>
                            <div><h3 class="name"></h3></div>
                        </div>
                    </div>
                    <div class="basic-info">
                        <h4>Basic Info</h4>
                        <div class="user-email">
                            <div>Email</div>
                            <div></div>
                        </div>
                        <div class="user-name">
                            <div>Username</div>
                            <div></div>
                        </div>
                        <div class="edit-anchor">
                            <a href="UserDetails?userId=">Edit Profile</a>
                        </div>
                    </div>
                </div>
                <div class="profile-right">
                    <div class="profile-spans">
                        <span class="general-information-span" >General Information</span>
                        <span class="login-history-span">Login History</span>
                    </div>
                    <div class="general-information">
                        <table>
                            <tr>
                                <td style="width:90%">First Name</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width:90%">Middle Name</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width:90%">Last Name</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width:90%">Date of Birth</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Gender</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width:90%">Country</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width:90%">Phone + Ext</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width:90%">Address</td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                    <div class="login-history" style="display:none;">
                        <div><i class="ti-time"></i>
                            Login history is displayed prior to the last login</div>
                        <div class="login-history-list">
                            <c:forEach items="" var="loginTime">
                                <div><i class="ti-angle-right"></i></div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

















        </div>
    </div>
</div>
<script type="text/javascript" src ="${pageContext.request.contextPath}/scripts/CommonScript.js"></script>

</body>
</html>