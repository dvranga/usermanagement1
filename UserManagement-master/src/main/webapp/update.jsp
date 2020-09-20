<%@ page import="com.bridgelabz.usermanagement.model.User" %>
<html>
<head>
    <title>New User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <style><%@include file="css/newUser.css"%>
    </style>
</head>
<body style="margin:0;display: block">
<%
    User editUser=(User)session.getAttribute("editUser");
%>
<form action="updateUserController" method="post" enctype="multipart/form-data">
    <div class="header-panel">
        <%@include file="toolBar.jsp" %>
    </div>
    <div class="body-panel">
        <div class="sidenav-pannel">
            <%@include file="sideNavBar.jsp"%>
        </div>
        <div class="main-content">

            <div class="title">
                <div class="title-name">New User</div>
                <div class="title-link">
                    <i style="margin-left: 50%" class="fa fa-home"></i>
                    <a class="home-icon" href="webPages/dashboard.jsp">Home</a>
                    <a> / NewUser</a>
                </div>
            </div>
            <div class="middle-container">
                <div class="new-user">
                    <div class="new-user-box">
                        <div class="web-page-header">General</div>
                        <div class="general-div">


                            <table class="general-table">
                                <tr class="row1">
                                    <td class="column-1-1">
                                        <div class="first-name">First Name</div>
                                    </td>
                                    <td class="column-1-2">
                                        <div class="middle-name">Middle Name</div>
                                    </td>
                                    <td class="column-1-3">
                                        <div class="last-name">Last Name</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="column-2-1">
                                        <div class="column21">
                                            <input type="text" name="firstName" id="firstName" class="first-name-input" value="<%=editUser.getFirstName()%>">
                                        </div>
                                    </td>
                                    <td class="column-2-2">
                                        <div class="column22">
                                            <input type="text" name="middleName" class="middle-name-input" value="<%=editUser.getMiddleName()%>">
                                        </div>
                                    </td>
                                    <td class="column-2-3">
                                        <div class="column23">
                                            <input type="text" name="lastName" class="last-name-input" value="<%=editUser.getLastName()%>">
                                        </div>
                                    </td>
                                </tr>


                                <tr class="row1">
                                    <td class="column-date-of-birth">
                                        <div >
                                            <div class="date-of-birth">Date of Birth</div>
                                        </div>
                                    </td>
                                    <td class="column-gender">
                                        <div >
                                            <div class="gender">Gender</div>
                                        </div>
                                    </td>
                                    <td class="column-country">
                                        <div >
                                            <div class="country">Country</div>
                                        </div>
                                    </td>
                                </tr>


                                <tr >
                                    <td class="column-date-of-birth-input">
                                        <div class="date-of-birth-input-column21">
                                            <input value="<%=editUser.getDateOfBirth()%>"  name="dateOfBirth" placeholder="dd-mm-yyyy" type="date" id="start" class="date-of-birth-input"  min="1970-01-01" max="2020-12-31" required>
                                        </div>
                                    </td>
                                    <td class="column-middle-name-input">
                                        <div class="middle-name-input-column22">
                                            <%String k= editUser.getGender();%>
                                            <select value=<%=k%> id="gender" class="middle-name-input" onchange="this.value.selected" name="gender">
                                                <option >select</option>
                                                <option value="F">Female</option>
                                                <option value="M">Male</option>
                                            </select>
                                        </div>
                                    </td>
                                    <td class="column-last-name-input">
                                        <div class="last-name-input-column23">
                                            <select id="country" class="last-name-input" name="country" onselect="<%=editUser.getCountry()%>">
                                                <option value="India" selected="selected">India</option>
                                                <option value="Pakistan">Russia</option>
                                                <option value="America">America</option>
                                                <option value="England">England</option>
                                                <option value="Australia">Australia</option>
                                                <option value="Srilanka">Srilanka</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="row1">
                                    <td class="column-1-1">
                                        <div class="phone">Phone</div>
                                    </td>
                                    <td class="column-1-2">
                                        <div class="phoneext">Phone + Ext</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="column-2-1">
                                        <div class="phoneinputcolumn21">
                                            <input type="text"  name="phone" class="phoneinput" value="<%=editUser.getMobileNumber()%>">
                                        </div>
                                    </td>
                                    <td class="column-2-2">
                                        <div class="phonecolumn22">
                                            <input type="text" name="phone_Ext" class="phoneinputcolumn22" value="<%=editUser.getParentNumber()%>">
                                        </div>
                                    </td>
                                </tr>
                                <tr class="row1">
                                    <td class="column-1-1">
                                        <div class="email">Email</div>
                                    </td>
                                    <td class="column-1-2">
                                        <div class="address">Address</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="column-2-1">
                                        <div class="email-column21">
                                            <input type="text"  name="email" class="email-input" value="<%=editUser.getEmail()%>">
                                        </div>
                                    </td>
                                    <td class="column-2-2">
                                        <div class="address-column22">

                        <textarea rows = "5" cols = "50"  class="address-input" name = "address" value="<%=editUser.getAddress()%>">
                            </textarea>
                                        </div>
                                    </td>
                                </tr>

                            </table>
                            <hr>
                            <table class="general-table">
                                <tr class="row1">
                                    <td class="column-1-1">
                                        <div class="user-name">Username</div>
                                    </td>
                                    <td class="column-1-2">
                                        <div class="password">Password</div>
                                    </td>
                                    <td class="column-1-3">
                                        <div class="conform-password">Conform Password</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="column-2-1">
                                        <div class="usernamecolumn21">
                                            <input type="text" name="userName" class="usernamecolumn21input" value="<%=editUser.getUserName()%>">
                                        </div>
                                    </td>
                                    <td class="column-2-2">
                                        <div class="passwordcolumn22">
                                            <input type="password" name="password" class="passwordcolumn22input" value="<%=editUser.getPassword()%>">
                                        </div>
                                    </td>
                                    <td class="column-2-3">
                                        <div class="conformpasswordcolumn23">
                                            <input type="password" name="conformPassword" class="conformpasswordinput">
                                        </div>
                                    </td>
                                </tr>


                                <tr class="row1">
                                    <td class="column-date-of-birth">
                                        <div >
                                            <div class="userrole">User Role</div>
                                        </div>
                                    </td>
                                </tr>

                                <tr >
                                    <td class="column-date-of-birth-input">
                                        <div class="userrolecolumn21">
                                            <select  class="userrolecolumn21input" name="userRole"  onchange="userRolePermissions(this.value)" value="<%=editUser.getRoleId()%>">
                                                <option value="<%=editUser.getRoleId()%>">Select</option>
                                                <option value=1>Admin</option>
                                                <option value=0>User</option>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>

                    </div>

                </div>

                <div class="photo-container">
                    <div class="photo-heading">Photo</div>
                    <div class="acceptance">Acceptable image formats are jpg,jpeg,png & gif.</div>
                    <div class="image-size-title">Maximum image size allowed is 2MB.</div>
                    <div class="photo-input">
                        <label class="custom-file-upload">
                            <input type="file" id="input-file-now" class="dropify" data-show-loader="true"
                                   data-show-remove="true" data-errors-position="inside" name="new-user-profile-image"
                                   data-allowed-file-extensions="png jpeg jpg gif" data-max-file-size="2M"
                                   value="<%=editUser.getImage()%>">
                            <div class="cloud" style="align-items: center;margin-top: -8%;margin-left: 6%;">
                                    <img src="data:image/jpg;base64,<%=editUser.getImage()%>" width="200px" height="120px" />
                            </div>
                            <br/>
                            <div style="display: flex;justify-content: center"> Click on image to Update </div>

                        </label>
                    </div>
                </div>

            </div>
            <div class="permissions">
                <div class="permission-box">
                    <div class="permission-header">Permissions</div>
                    <div class="panel">
                        <table>
                            <tr>
                                <th>Web Page</th>
                                <th> <input type="checkbox" class="check-box" name="add"  id="add" onchange="onCheck('add')"  > Add</th>
                                <th><input type="checkbox" class="check-box" name="delete" id="delete" onchange="onCheck('delete')"> Delete</th>
                                <th><input type="checkbox" class="check-box" name="modify" id="modify" onchange="onCheck('modify')"> Modify</th>
                                <th><input type="checkbox" class="check-box" name="read" id="read" onchange="onCheck('read')"> Read</th>
                            </tr>
                            <tr>
                                <td>Dashboard</td>
                                <td><input name="dashboard_add" id="dashboard_add"  type="checkbox" value="1" class="check-box" onclick="permissionAdd()" onchange="isCheck('addingCheckBoxes')" ></td>
                                <td><input name="dashboard_delete" id="dashboard_delete" type="checkbox"  value="1" class="check-box" onchange="isCheck('deleteCheckBoxes')"></td>
                                <td><input name="dashboard_modify" id="dashboard_modify" type="checkbox" class="check-box" onchange="isCheck('modifyCheckBoxes')"></td>
                                <td><input name="dashboard_read" id="dashboard_read" type="checkbox" class="check-box" onchange="isCheck('readCheckBoxes')"></td>

                            </tr>
                            <tr>
                                <td>Settings</td>
                                <td><input name="settings_add" id="settings_add" type="checkbox" value="1" class="check-box" onclick="permissionAdd()" onchange="isCheck('addingCheckBoxes')"></td>
                                <td><input name="settings_delete" id="settings_delete" type="checkbox" class="check-box" onchange="isCheck('deleteCheckBoxes')"></td>
                                <td><input name="settings_modify" id="settings_modify" type="checkbox" class="check-box" onchange="isCheck('modifyCheckBoxes')"></td>
                                <td><input name="settings_read" id="settings_read" type="checkbox" class="check-box" onchange="isCheck('readCheckBoxes')"></td>

                            </tr>
                            <tr>
                                <td>User Information</td>
                                <td><input  name="user_info_add" id="user_info_add" type="checkbox" class="check-box" onchange="isCheck('addingCheckBoxes')"></td>
                                <td><input name="user_info_delete" id="user_info_delete" type="checkbox" class="check-box" onchange="isCheck('deleteCheckBoxes')"></td>
                                <td><input name="user_info_modify" id="user_info_modify" type="checkbox" class="check-box" onchange="isCheck('modifyCheckBoxes')"></td>
                                <td><input name="user_info_read" id="user_info_read" type="checkbox" class="check-box" onchange="isCheck('readCheckBoxes')"></td>

                            </tr>
                            <tr>
                                <td>Web Page 1</td>
                                <td><input name="w1_add" id="w1_add" type="checkbox" class="check-box" onchange="isCheck('addingCheckBoxes')"></td>
                                <td><input name="w1_delete" id="w1_delete" type="checkbox" class="check-box" onchange="isCheck('deleteCheckBoxes')" ></td>
                                <td><input name="w1_modify" id="w1_modify" type="checkbox" class="check-box" onchange="isCheck('modifyCheckBoxes')"></td>
                                <td><input name="w1_read" id="w1_read" type="checkbox" class="check-box" onchange="isCheck('readCheckBoxes')"></td>

                            </tr>
                            <tr>
                                <td>Web Page 2</td>
                                <td><input name="w2_add" id="w2_add" type="checkbox" class="check-box" onchange="isCheck('addingCheckBoxes')"></td>
                                <td><input name="w2_delete" id="w2_delete" type="checkbox" class="check-box" onchange="isCheck('deleteCheckBoxes')"></td>
                                <td><input name="w2_modify" id="w2_modify" type="checkbox" class="check-box" onchange="isCheck('modifyCheckBoxes')"></td>
                                <td><input name="w2_read" id="w2_read" type="checkbox" class="check-box" onchange="isCheck('readCheckBoxes')"></td>

                            </tr>
                            <tr>
                                <td>Web Page 3</td>
                                <td><input name="w3_add" id="w3_add" type="checkbox" class="check-box" onchange="isCheck('addingCheckBoxes')"></td>
                                <td><input name="w3_delete" id="w3_delete" type="checkbox" class="check-box" onchange="isCheck('deleteCheckBoxes')"></td>
                                <td><input name="w3_modify" id="w3_modify" type="checkbox" class="check-box" onchange="isCheck('modifyCheckBoxes')"></td>
                                <td><input name="w3_read" id="w3_read" type="checkbox" class="check-box" onchange="isCheck('readCheckBoxes')"></td>
                            </tr>
                        </table>

                    </div>

                </div>
            </div>
            <div class="bottom-container">
                <input class="submit-button" type="submit" value="Update">
                <input class="reset-button" type="submit" value="Reset">
            </div>


        </div>
    </div>

    </div>

    </div>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/js/dropify.min.js"></script>
    <script type="text/javascript">
        <%@include file ="UserPermission.js" %>
    </script>
    <script>
        var dashboardpermission=<%=session.getAttribute("dashboardpermission")%>;
        for (var i = 0; i < userDashboardPermission.length; i++) {
            var checkbox = userDashboardPermission[i];
            document.getElementById(checkbox).checked=dashboardpermission[i];
        }
        var settingpermission=<%=session.getAttribute("settingpermission")%>;
        for (var i = 0; i < userSettingPermission.length; i++) {
            var checkbox = userSettingPermission[i];
            document.getElementById(checkbox).checked=settingpermission[i];
        }
        var userpermission=<%=session.getAttribute("userpermission")%>;
        for (var i = 0; i < userInformationPermission.length; i++) {
            var checkbox = userInformationPermission[i];
            document.getElementById(checkbox).checked=userpermission[i];
        }
        var webPage1Permissions=<%=session.getAttribute("webpage1")%>;
        for (var i = 0; i < userW1Permission.length; i++) {
            var checkbox = userW1Permission[i];
            document.getElementById(checkbox).checked=webPage1Permissions[i];
        }
        var webPage2Permissions=<%=session.getAttribute("webpage2")%>;
        for (var i = 0; i < userW2Permission.length; i++) {
            var checkbox = userW2Permission[i];
            document.getElementById(checkbox).checked=webPage2Permissions[i];
        }
        var webPage3Permissions=<%=session.getAttribute("webpage3")%>;
        for (var i = 0; i < userW3Permission.length; i++) {
            var checkbox = userW3Permission[i];
            document.getElementById(checkbox).checked=webPage3Permissions[i];
        }
    </script>
</form>

</body>
</html>