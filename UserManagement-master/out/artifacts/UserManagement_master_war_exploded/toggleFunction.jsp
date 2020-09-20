<head>
    <title>Toggle Function</title>
</head>
<body>

<script>
    function toggleNav(){
        navSize = document.getElementById("mySidenav")
        if (navSize.style.display==="block") {
            return closeNav();
        }
        return openNav();
    }
    function openNav() {
        document.getElementById("mySidenav").style.display = "block";
        document.getElementById("toggleId").className="ti-arrow-circle-left"
        document.getElementsByClassName("main-content").style.width="20%"
    }

    function closeNav() {
        document.getElementById("mySidenav").style.display="none";
        document.getElementById("toggleId").className="ti-arrow-circle-right"
        document.getElementsByClassName("main-content").style.width="0%"
    }

</script>
</body>
</html>