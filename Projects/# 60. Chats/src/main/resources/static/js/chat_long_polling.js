function sendMessage(from, text) {
    let message = {
        "from": from,
        "text": text
    };

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/chat",
        data: JSON.stringify(message),
        dataType: "json",
        contentType: "application/json"
    });
}

function receiveMessage(from) {
    $.ajax({
        type: "GET",
        url: "/chat?for=" + from,
        success: function (response) {
            $('#messagesList').first().after("<li>" + response[0]['from'] + " " +  response[0]["text"] + "</li>")
            receiveMessage(from);
        }
    })
}

function enterChat(id) {
    let message = {
        "from": id,
        "text": "enter"
    };

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/chat",
        data: JSON.stringify(message),
        dataType: "json",
        contentType: "application/json",
        complete: function () {
            receiveMessage(id)
        }
    });
}