function currentDate() {
    var currentDate = new Date();
    var date = currentDate.getDate();
    var month = currentDate.getMonth() + 1;
    var year = currentDate.getFullYear();

    if (date < 10) {
        date = '0' + date;
    }
    if (month < 10) {
        month = '0' + month;
    }

    var today = year + '-' + month + '-' + date;
    console.log(today, " today from current day")
    document.getElementById("start").setAttribute("max", today);
}