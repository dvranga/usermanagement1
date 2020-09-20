<html>
<head>
    <title>WebPage</title>
    <style>
        <%@include file="css/webapps.css"%>
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
            <div class="title-name">WebPage 1
                <p class="tagline">Permissions granted for webpage 1</p>
            </div>
            <div class="title-link">
                <i style="margin-left: 50%" class="fa fa-home"></i>
                <a class="home-icon" href="dashboard">Home</a>
                <a> / webpage 1</a>
            </div>
        </div>


        <div class="permissions">
            <div class="permission-box">
                <div class="web-page-header">Webpage Permissions</div>
                <table class="table-no-border">
                    <tbody>
                    <tr>
                        <td style="width: 60%">
                            <span class="inputLabel">Add Permission</span>
                        </td>
                        <td>
                            <div class="reminder">
                                <label class="switch1">
                                    <input style="height: 15px" id="add-permission" class="check-box" type="checkbox" checked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td style="width: 60%">
                            <span class="inputLabel">Delete Permission</span>
                        </td>
                        <td>
                            <div class="reminder">
                                <label class="switch1">
                                    <input style="height: 15px" id="delete-permission" class="check-box" type="checkbox" checked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </td>
                    </tr>
                    <tr></tr>

                    <tr>
                        <td style="width: 60%">
                            <span class="inputLabel">Modify Permission</span>
                        </td>
                        <td>
                            <div class="reminder">
                                <label class="switch1">
                                    <input style="height: 15px" id="modify-permission" class="check-box" type="checkbox" checked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </td>
                    </tr>
                    <tr></tr>

                    <tr>
                        <td style="width: 60%">
                            <span class="inputLabel">Read Permission</span>
                        </td>
                        <td>
                            <div class="reminder">
                                <label class="switch1">
                                    <input style="height: 15px" id="read-permission" class="check-box" type="checkbox" checked>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</div>
</div>
<script>
    var webPage1Permissions=<%=session.getAttribute("webpage1")%>;
    console.log(webPage1Permissions[1]);

    (webPage1Permissions[0])?
        document.getElementById("add-permission").checked=true :
        document.getElementById("add-permission").checked=false;

    (webPage1Permissions[1])?
        document.getElementById("delete-permission").checked=true :
        document.getElementById("delete-permission").checked=false;

    (webPage1Permissions[2])?
        document.getElementById("modify-permission").checked=true:
        document.getElementById("modify-permission").checked=false;

    (webPage1Permissions[3])?
        document.getElementById("read-permission").checked=true:
        document.getElementById("read-permission").checked=false;
</script>

</body>
</html>