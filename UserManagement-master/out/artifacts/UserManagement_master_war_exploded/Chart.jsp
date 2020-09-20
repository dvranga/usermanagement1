var ctxL = document.getElementById("lineChart").getContext('2d');
<%List registrationDetails = (List) session.getAttribute("registrationDetails");%>
var myLineChart = new Chart(ctxL, {
    type: 'line',
    data: {
        labels: ["September", "October", "November", "December", "January", "February", "March", "April", "May", "June", "July", "August"],
        datasets: [{

            data: <%=registrationDetails%>,
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