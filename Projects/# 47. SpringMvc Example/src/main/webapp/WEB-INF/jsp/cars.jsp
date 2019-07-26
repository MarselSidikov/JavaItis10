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
    <%--Функция JavaScript, которую мы написали --%>
    <%--Принимает на вход идентификатор пользователя, марку автомобиля и ее гос номер--%>
    function sendCar(userId, model, number) {
        // создаем переменную, в которой находится объект для отправки запроса
        let xhr = new XMLHttpRequest();
        // создаем тело запроса в формате JSON
        let body = {
            "model": model,
            "number": number
        };
        // "настраиваем" запрос, какой метод запроса и какой URL
        xhr.open('POST', '/cars?user=' + userId);
        // указываем, что наш запрос будет содержать JSON
        xhr.setRequestHeader('Content-Type', 'application/json');
        // onload - это callback, то есть фунция onload не имеет реализации
        // но внутри xhr она будет вызвана в момент, когда от сервера
        // придет ответ
        xhr.onload = function () {
            // получаем строковое представление JSON-ки из ответа
            let response = JSON.parse(xhr.response);
            // найти на странице элемент, в котором находится список машин
            let carsListHtml = document.getElementById('cars-list');
            // создаем новую HTML-ку с новым списком
            let newCarsList = '<thead class="thead-dark">\n' +
                '        <tr>\n' +
                '            <th>ID</th>\n' +
                '            <th>MODEL</th>\n' +
                '            <th>NUMBER</th>\n' +
                '        </tr>\n' +
                '        </thead>';
            // бежим по всей jSON-ке (новой) со списком машин
            for (let i = 0; i < response.length; i++) {
                // получаем отдельно взятую машину из списка
                let car = response[i];
                // заполняем новую строку
                newCarsList += '<tr>';
                newCarsList += '<td>' + car["id"] + '</td>'
                newCarsList += '<td>' + car["model"] + '</td>';
                newCarsList += '<td>' + car["number"] + '</td>';
                newCarsList += '</tr>';
            }
            // в элемент, который содержит список машин вставляем новую HTML-ку
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
        <%--когда страница только открылась, у нее есть атрибут машины и страница
        заполняется машинами на сервере и отдается пользователю
        HTML + JSP + JSTL --%>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.number}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<c:if test="${user.role == 'ADMIN'}">
    <div>
        <input id="model" name="model" placeholder="Model">
        <input id="number" name="number" placeholder="Number">
        <button onclick="sendCar(${userId}, document.getElementById('model').value,
                document.getElementById('number').value)">Add
        </button>
    </div>
</c:if>
</body>
</html>
