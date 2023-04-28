// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function login(){
    let data = {};
    data.email= document.getElementById('inputEmail').value;
    data.password= document.getElementById('inputPassword').value;

    const request = await fetch('api/login',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const response = await request.text();
    if (response != 'FAIL'){
    localStorage.setItem('token',response);
    localStorage.setItem('email',data.email);
    window.location.href='users.html'}else{
    alert("Email or Password are not correct")}

}