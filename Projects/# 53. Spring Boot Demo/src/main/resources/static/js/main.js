function sendCar(csrf, userId, model, number) {
    let body = {
        "model": model,
        "number": number
    };

    $.ajax({
        url: '/cars?user=' + userId,
        contentType: 'application/json',
        type: 'post',
        headers : {
            'X-CSRF-TOKEN': csrf
        },
        dataType: 'json',
        data: JSON.stringify(body),
        success: function (response) {
            reloadTableByResponse(response);
        }
    })
}

function reloadTableByResponse(response) {
    let newCarsListHtml = '<thead class="thead-dark">\n' +
        '        <tr>\n' +
        '            <th>ID</th>\n' +
        '            <th>MODEL</th>\n' +
        '            <th>NUMBER</th>\n' +
        '        </tr>\n' +
        '        </thead>';
    for (let i = 0; i < response.length; i++) {
        let car = response[i];
        newCarsListHtml += '<tr>';
        newCarsListHtml += '<td>' + car["id"] + '</td>';
        newCarsListHtml += '<td>' + car["model"] + '</td>';
        newCarsListHtml += '<td>' + car["number"] + '</td>';
        newCarsListHtml += '</tr>';
    }
    $("#cars-list").html(newCarsListHtml);
}

function searchCar(query) {
    $.ajax({
        // отправляем запрос по урлу вместе с тем, что вписал пользователь (query)
        url: '/cars/search?q=' + query,
        contentType: 'application/json',
        type: 'get',
        dataType: 'json',
        success: function (response) {
            // если запрос прошел успешно
            // то ответ на этот запрос необходимо вывести на страницу
            fillDataListWithCarModels(response)
        }
    })
}
function fillDataListWithCarModels(response) {
    let newCarsListHtml;
    for (let i = 0; i < response.length; i++) {
        newCarsListHtml += '<option value="' + response[i]['model'] + '">' + response[i]['model'] + '</option>';
    }
    $("#modelsList").html(newCarsListHtml);
}