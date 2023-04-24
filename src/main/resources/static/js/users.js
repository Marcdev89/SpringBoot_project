// Call the dataTables jQuery plugin
$(document).ready(function() {
getUsers();
  $('#usersTable').DataTable();
});

async function getUsers(){

    const request = await fetch('users',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const users = await request.json();

    let usersList = '';
    users.map((e) =>{
       usersList += '<tr> <td>#'+ e.id +'1</td><td>'
                        + e.name + ' '
                        + e.surname +'</td><td>'
                        + e.mail + '</td><td>'
                        + e.phone
                        + '</td> <td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>>';

    })

document.querySelector('#usersTable tbody').outerHTML = usersList;

}