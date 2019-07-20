<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<script>
    function sendCar(userId, model, number) {
        let xhr = new XMLHttpRequest();
        let body = {
            "model": model,
            "number": number
        };
        xhr.open('POST', '/cars?user=' + userId);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function () {
            let response = JSON.parse(xhr.response);
            let carsListHtml = document.getElementById('cars-list');
            let newCarsList = '<thead class="thead-dark">\n' +
                '        <tr>\n' +
                '            <th>ID</th>\n' +
                '            <th>MODEL</th>\n' +
                '            <th>NUMBER</th>\n' +
                '        </tr>\n' +
                '        </thead>';
            for (let i = 0; i < response.length; i++) {
                let car = response[i];
                newCarsList += '<tr>';
                newCarsList += '<td>' + car["model"] + '</td>';
                newCarsList += '<td>' + car["number"] + '</td>';
                newCarsList += '</tr>';
            }
            carsListHtml.innerHTML = newCarsList;
        };
        xhr.send(JSON.stringify(body));
    }
</script>
<div>
    <table id='cars-list' class="table">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>MODEL</th>
            <th>NUMBER</th>
        </tr>
        </thead>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.number}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <input id="model" name="model" placeholder="Model">
    <input id="number" name="number" placeholder="Number">
    <button onclick="sendCar(${user.id}, document.getElementById('model').value,
            document.getElementById('number').value)">Add
    </button>
</div>
</body>
</html>
