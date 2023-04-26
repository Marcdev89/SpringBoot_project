// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function newUser(){
    let data = {};
    data.name= document.getElementById('inputFirstName').value;
    data.surname= document.getElementById('inputLastName').value;
    data.email= document.getElementById('inputEmail').value;
    data.password= document.getElementById('inputPassword').value;

    let repeatPassword = document.getElementById('inputRepeatPassword').value;

    if (repeatPassword !== data.password){
    alert('Is not the same password')
    return;
    }

    const request = await fetch('api/users',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({data})
    });
    console.log(data.email)



}

