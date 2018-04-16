$(document).ready(function() {

    $.ajax({
        type: 'GET',
        url: '/employees',
        dataType: 'json',
        success: function (data) {
            let tbody = $('#table-body');
            let rows = [];
            data.forEach(function (d) {
                let name = `<td>${d.name}</td>`;
                let role = `<td>${d.role}</td>`;
                rows.push(`<tr>${name}${role}</tr>`);
            });
            tbody.html(rows.join(''));
        }
    });
});