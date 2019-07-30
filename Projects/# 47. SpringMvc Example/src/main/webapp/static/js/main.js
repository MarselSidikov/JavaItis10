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