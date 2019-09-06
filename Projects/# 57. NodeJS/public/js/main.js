function getAllUsers() {
    $.get("http://localhost:8080/users", function(response) {
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
    })
}
function getCommunitiesByUser() {
    let url = $.url(document.location);
    let userId = url.param('user');

    $.get("http://localhost:8080/users/" + userId + "/communities", function(response) {
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
