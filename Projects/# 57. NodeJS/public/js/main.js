function getAllUsers() {
    $.ajax({
        url: "http://localhost:8080/users",
        headers: {
            "token": localStorage.getItem("token")
        },
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            let data = response.data;
            let html = '';
            for (let i = 0; i < data.length; i++) {
                let link = 'user.html?user=' + data[i].id;
                html += '<tr>' +
                    '<td>' + data[i].firstName + '</td>' +
                    '<td>' + data[i].lastName + '</td>' +
                    '<td>' +
                    '<a href="communities.html?user=' + data[i].id + '">Сообщества</a>' +
                    '</td>' +
                    '</tr>';
            }
            $('#users_table').first().after(html);
        },
        error: function (response) {
            if (response.status === 403) {
                window.location = '/login.html'
            }
        }
    });
}

function getCommunitiesByUser() {
    let url = $.url(document.location);
    let userId = url.param('user');

    $.get("http://localhost:8080/users/" + userId + "/communities", function (response) {
        let data = response.data;
        let html = '';
        for (let i = 0; i < data.length; i++) {
            html += '<tr>' +
                '<td>' + data[i].name + '</td>' +
                '</tr>';
        }
        $('#communities_table').first().after(html);
    })

}

function login() {
    let email = $("#email").val();
    let password = $("#password").val();

    let body = {
        "email": email,
        "password": password
    };

    $.ajax({
        method: "POST",
        url: "http://localhost:8080/login",
        data: JSON.stringify(body),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
            let token = response.data.token;
            let userId = response.data.id;
            localStorage.setItem("token", token);
            localStorage.setItem("id", userId);
            window.location = "/profile.html";
        },
        error: function (response) {
            window.location = "/login.html"
        }
    });
}

function getProfile() {
    $.ajax({
        url: "http://localhost:8080/users/" + localStorage.getItem("id"),
        headers: {
            "token" : localStorage.getItem("token")
        },
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            $("#first_name").html(response.data.firstName);
            $("#last_name").html(response.data.lastName);
            $("#email").html(response.data.email);
        },
        error: function (response) {
            window.location = "/login.html"
        }
    });
}
