<%@ page import="com.bridgelabz.usermanagement.model.Location" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bridgelabz.usermanagement.dao.RegistrationGraphDetails" %>
<html>

<head>
    <title>User Dashboard</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="HandheldFriendly" content="true">
    <style>
        <%@include file="css/dashboard.css"%></style>

</head>
<body style="background-color: #F5F6F9;margin: 0">
<%User user=(User)session.getAttribute("user");%>

<div class="header-panel">
    <%@include file="toolBar.jsp" %>
</div>
<div class="body-panel">
    <div class="sidenav-pannel">
        <%@include file="sideNavBar.jsp"%>
    </div>
    <div class="main-content">
        <div class="title">
            <div class="title-name"> Welcome <%=user.getFirstName()+" "+user.getLastName()%>
                <p class="tagline">You last logged in on:<%=session.getAttribute("lastLoginDetails")%> </p>
            </div>
            <div class="title-link">
                <i style="margin-left: 50%" class="fa fa-home"></i>
                <a class="home-icon" href="dashboard">Home</a>
                <a> / Dashboard</a>
            </div>
        </div>
        <div class="widgets">
            <div class="widget1">
                <div class="widget-container">
                    <div class="widget-left">
                    <span style="background-color: #0E9BE2" class="icon-wrapper">
                        <i class="ti-user"></i>
                    </span>
                    </div>
                    <div class="widget-right">
                        <div class="status">TOTAL</div>
                        <div class="status-value"><%=session.getAttribute("totalUsers")%></div>
                    </div>
                </div>
            </div>
            <div class="widget1">
                <div class="widget-container">
                    <div class="widget-left">
                    <span style="background-color: #1DBB8E" class="icon-wrapper">
                        <i class="ti-check"></i>
                    </span>
                    </div>
                    <div class="widget-right">
                        <div class="status">ACTIVE</div>
                        <div class="status-value"><%=session.getAttribute("activeusers")%></div>
                    </div>
                </div>

            </div>
            <div class="widget1">
                <div class="widget-container">
                    <div class="widget-left">
                    <span style="background-color: #ff4402" class="icon-wrapper">
                        <i class="ti-na"></i>

                    </span>
                    </div>
                    <div class="widget-right">
                        <div class="status">INACTIVE</div>
                        <div class="status-value"><%=session.getAttribute("inactiveUsers")%></div>
                    </div>
                </div>

            </div>
            <div class="widget1">
                <div class="widget-container">
                    <div class="widget-left">
                    <span style="background-color: #F3BB23" class="icon-wrapper">
                        <i class="ti-eye"></i>
                    </span>
                    </div>
                    <div class="widget-right">
                        <div class="status">ONLINE</div>
                        <div class="status-value">1</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-container">
            <div class="graphic-container">
                <div class="graphic-header-pannel">
                    All Time Registration History
                </div>
                <div class="graphic-body" style="display:flex;">
                    <div class="graphic-left">
                        <table class="alltimebuttons">
                            <tr>
                                <td>
                                    <button class="button-alltime">
                                        <a onclick="getDetails(<%=session.getAttribute("registrationDetails")%>, 1)"> All Time</a>
                                    </button>
                                </td>
                                <td>
                                    <button class="button-2020" >
                                        <a onclick="getDetails(<%=session.getAttribute("registerMonthDetails")%>, 2)">2020</a>
                                    </button>
                                </td>
                                <td>
                                    <button class="button-month" >
                                        <a onclick="getDetails(<%=session.getAttribute("registerYearDetails")%>, 3)">September</a>
                                    </button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="enlarge-graph">
                    <div class="canvas">
                        <canvas  style=" display: block; height: 380px; width: 540px; margin-left: 2%; margin-top: 9%"  id="lineChart" />
                    </div>
                </div>

                    <div class="graphic-right">
                        <div class="location-section">
                            <div class="section-heading">
                                Top Location
                            </div>
                            <div class="location-table-container">
                                <% List<Location> toplocations = (List<Location>) session.getAttribute("toplocations");%>
                                <%for (int k = 1; k <= 3; k++) {%>
                                <table class="location-table" >
                                    <tr>
                                        <td style="width: 10px"><%=k%></td>
                                        <td style="width: 500px"><%=toplocations.get(k-1).getCountryName()%></td>
                                        <td style="width: 50px"><%=toplocations.get(k-1).getUsersCount()%></td>
                                    </tr>
                                </table>
                                <%}%>
                                <div class="locations-link">
                                    <a href="topLocations" style="text-underline-position: under;">See All Locations</a>
                                </div>
                            </div>
                        </div>
                        <div class="gender-section">
                            <div class="section-heading">
                                Gender
                            </div>
                            <div class="gender-table">
                                <table style="margin-top: -5%">
                                    <tr>
                                        <td class="gender">Male</td>
                                        <td><%=session.getAttribute("malePercentage")%>%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="malepercent">
                                                <div class="maleprogressbar malehtmlstyle" id="male"></div>
                                                <script>
                                                    document.getElementById("male").style.width=<%=session.getAttribute("malePercentage")%>*2
                                                </script>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="gender">Female</td>
                                        <td><%=session.getAttribute("femalePercentage")%>%</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="femalepercent">
                                                <div class="femaleprogressbar femalehtmlstyle" id="female"></div>
                                                <script>
                                                    document.getElementById("female").style.width=<%=session.getAttribute("femalePercentage")%>*2
                                                </script>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="age-section">
                            <div class="section-heading">
                                Age Group
                            </div>
                        </div>
                        <div>
                            <table class="age-group">
                                <% List ageList = (List) session.getAttribute("ageGroup");%>
                                <tr >
                                    <td style="width: 10px">
                                        18-22
                                    </td>
                                    <td style="width: 50px">
                                        <div id="18" class="age-18"><span class="hover-age-18"> 18-22 users : <%=ageList.get(0)%></span></div>
                                        <script>
                                            document.getElementById("18").style.width=<%=ageList.get(0)%>*5
                                        </script>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        23-27
                                    </td>
                                    <td style="width: 50px">
                                        <div  id=23 class="age-23"><span class="hover-age-23"> 23-27 users : <%=ageList.get(1)%></span></div>
                                        <script>
                                            document.getElementById("23").style.width=<%=ageList.get(1)%>*5
                                        </script>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        28-32
                                    </td>
                                    <td style="width: 50px">
                                        <div  id=28 class="age-28"><span class="hover-age-28"> 28-32 users : <%=ageList.get(2)%></span></div>
                                        <script>
                                            document.getElementById("28").style.width=<%=ageList.get(2)%>*5
                                        </script>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        33-37
                                    </td>
                                    <td style="width: 50px">
                                        <div id=33 class="age-33"><span class="hover-age-33"> 33-37 users : <%=ageList.get(3)%></span></div>
                                            <script>
                                                document.getElementById("33").style.width=<%=ageList.get(3)%>*5
                                            </script>
                                    </td>
                                </tr>
                                </tr>
                                <tr>
                                    <td>
                                        38-42
                                    </td>
                                    <td style="width: 50px">
                                        <div id=38 class="age-38"><span class="hover-age-38"> 38-42 users : <%=ageList.get(4)%></span></div>
                                        <script>
                                            document.getElementById("38").style.width=<%=ageList.get(4)%>*5
                                        </script>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        over 42
                                    </td>
                                    <td style="width: 50px">
                                        <div id=42 class="age-42"><span class="hover-age-42"> over 42 users : <%=ageList.get(5)%></span></div>
                                    </td>
                                    <script>
                                        document.getElementById("42").style.width=<%=ageList.get(5) %>*5
                                    </script>
                                </tr>
                                <tr>
                                    <td>
                                        under 18
                                    </td>
                                    <td style="width: 50px">
                                        <div id=17 class="age-under-18"><span class="hover-age-under-18"> under 18 users : <%=ageList.get(6)%></span></div>
                                    </td>
                                    <script>
                                        document.getElementById("17").style.width=<%=ageList.get(6)%>*5
                                    </script>
                                </tr>
                            </table>
                        </div>

                    </div>
            </div>
        </div>
            <div class="registration-container">
                <div class="registration-header-pannel">
                    <div class="Latest">Latest registration</div>
                    <div style="text-align: right; margin-left: 25%; margin-top: 1%"><a class="load-more">Load More</a></div>

                </div>
                <div class="overflow" >
                    <%List<User> latestRegistartion=(List<User>)session.getAttribute("listOfUsers"); %>
                    <%for (int i = latestRegistartion.size()-1; i >0; i--) {%>

                    <table style="border-collapse: collapse;border-bottom: 1px solid #efeef2" class="latest-registation-table">
                        <tr>
                            <td >
                                <div style="display: flex;">
                                    <div class="size-controller">
                                        <div class="latest-user-wrapper">
                                            <img src="data:images/jpg;base64,<%=latestRegistartion.get(i).getImage()%>" style="width: 65px;margin-left: -32px;margin-top: -30px;">
                                        </div>
                                    </div>
                                    <div class="latest-user-name">
                                        <div class="latest-userName"><a><%=latestRegistartion.get(i).getUserName()%></a></div>
                                        <div class="latest-userName-status"><h><%=latestRegistartion.get(i).getCreator_stamp()%></h></div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <%}%>
                </div>
            </div>
        </div>
        <div class="footer">
        </div>
    </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script type="text/javascript" src="jscript/graph.js"></script>
</div>
<script>
    window.onload = function() {
        getDetails(<%=session.getAttribute("registrationDetails")%>, 1);
    };
</script>

<script>
    function getDetails(value, k) {
        var newVar=null;
         if (k === 2) {
             newVar =["Sep.2020", "Aug.2020", "July.2020", "June.2020", "may.2020", "April.2020"," Mar.2020", "Feb.2020"]  ;
        }
        else if (k === 1) {
             newVar =["Sep.2020", "Aug.2020", "July.2020", "June.2020", "may.2020", "April.2020"," Mar.2020", "Feb.2020", "Jan.2020", "Sep.2019"]  ;
        }
        else {
             newVar =["0-5.Sep", "6-10.Sep", "11-15.Sep", "16-20.Sep", "21-25.Sep", "26-30.Sep"]  ;
        }
        var ctxL = document.getElementById("lineChart").getContext('2d');
        var myLineChart = new Chart(ctxL, {
            type: 'line',
            data: {
                labels:newVar ,
                datasets: [{
                    data:value ,
                    borderColor: [
                        '#007bff',
                    ],
                    backgroundColor: 'transparent',
                    borderWidth: 2,
                },]
            },
            options: {
                responsive: true,
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                },
                legend: {
                    display: false
                }
            }
        });
    }
</script>
</body>
</html>