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
            <div class="title-name">WebPage 3
                <p class="tagline">Permissions granted for webpage 3</p>
            </div>
            <div class="title-link">
                <i style="margin-left: 50%" class="fa fa-home"></i>
                <a class="home-icon" href="dashboard">Home</a>
                <a> / webpage 3</a>
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
                                    <input style="height: 15px" class="check-box" id="add-web3" type="checkbox" checked>
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
                                    <input style="height: 15px" class="check-box" id="delete-web3" type="checkbox" checked>
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
                                    <input style="height: 15px" class="check-box" id="modify-web3" type="checkbox" checked>
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
                                    <input style="height: 15px" class="check-box" id="read-web3" type="checkbox" checked>
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
    var webPage3Permissions=<%=session.getAttribute("webpage3")%>;

    (webPage3Permissions[0])?
        document.getElementById("add-web3").checked=true :
        document.getElementById("add-web3").checked=false;

    (webPage3Permissions[1])?
        document.getElementById("delete-web3").checked=true :
        document.getElementById("delete-web3").checked=false;


    (webPage3Permissions[2])?
        document.getElementById("modify-web3").checked=true:
        document.getElementById("modify-web3").checked=false;

    (webPage3Permissions[3])?
        document.getElementById("read-web3").checked=true:
        document.getElementById("read-web3").checked=false;


</script>

</body>
</html>