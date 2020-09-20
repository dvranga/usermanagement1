<%@ page import="java.util.List" %>
<%@ page import="com.bridgelabz.usermanagement.model.Location" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top Location</title>
    <style>
        <%@include file="css/usersList.css"%>
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
            <div class="title-name" style="width: 50%">Top Locations</div>
            <div class="title-link" style="margin-left: 10%">
                <i style="margin-left: 50%" class="fa fa-home"></i>
                <a class="home-icon" href="webPages/dashboard.jsp">Home</a>
                <a> / Users</a>
            </div>
        </div>
        <div class="userList-panel">

            <div class="row">
                <select class="form-control" onchange="window.location.href=this.value;">
                    <option>select</option>
                    <option id="users10"  value="">10</option>
                    <option id="users20"  value="">20</option>
                    <option id="users50"  value="">50</option>
                    <option id="users100"  value="">100</option>
                </select>
                <input placeholder="Search..." id="myInput" onkeyup="myFunction()" type="text" class="search-box" title="Type in a name">
            </div>
            <br/>


            <div class="userList-table">
                <table id="users" class="users-table">
                    <tr>
                        <th class="SLNo">SlNo</th>
                        <th class="countryNameCol">Country Name</th>
                        <th class="countryCountCol">Members</th>
                    </tr>
                    <%List<Location> toplocations= (List<Location>) session.getAttribute("toplocations"); %>
                    <% for (int i=0;i<toplocations.size();i++) {%>

                    <tr>
                        <td ><%=i+1%></td>
                        <td ><%=toplocations.get(i).getCountryName()%></td>
                        <td ><%=toplocations.get(i).getUsersCount()%></td>
                    </tr>
                    <%}%>

                </table>
                <br/>
                <%--                <div style="display:flex">--%>
                <%--                    <span class="pagination-recods">Records 1-10 of </span>   --%>
                <%--                    <% int pageId = 10;%>--%>
                <%--                    <div style="display: flex">--%>
                <%--                        <% for (int i = 0; i <= 10 / pageId + 1; i++) { %>--%>
                <%--                        <table class="pagination-table">--%>
                <%--                            <td class="pagination">--%>
                <%--                                <a style="text-decoration: none; color: white" href="userListController?action=pagination&pageId=<%=(i*pageId)%>&pageId2=<%=(i*pageId)+pageId%>"><%=i + 1%>--%>
                <%--                                </a>--%>
                <%--                            </td>--%>
                <%--                        </table>--%>
                <%--                        <% }%>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>

        </div>

    </div>
</div>
</body>
</html>