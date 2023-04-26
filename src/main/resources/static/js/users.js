// Call the dataTables jQuery plugin
$(document).ready(function() {
getUsers();
  $('#usersTable').DataTable();
});

async function getUsers(){

    const request = await fetch('api/users',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const users = await request.json();

    let usersList = '';
    users.map((e) =>{
     let btnDelete = '<a href="#" onclick="deleteUser('+ e.id +')"class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

       usersList += '<tr> <td>#'+ e.id +'</td><td>'
                        + e.name + ' '
                        + e.surname +'</td><td>'
                        + e.email + '</td><td>'
                        + e.phone
                        + '</td> <td>' + btnDelete + '</td></tr>>';

    })

document.querySelector('#usersTable tbody').outerHTML = usersList;

}

async function deleteUser(id){

    if(!confirm('Really want to delete this user?')){
        return;
    }

    const request = await fetch('api/users/' + id,{
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    location.reload();
}