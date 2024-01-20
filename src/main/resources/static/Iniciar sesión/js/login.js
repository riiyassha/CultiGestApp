const LoginUrl = 'http://localhost:8080/api/Login';

async function Login(){
    let loginDto = {};

    loginDto.email = document.getElementById('username').value;
    loginDto.password = document.getElementById('password').value;

        const request = await fetch(LoginUrl, {
        method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body : JSON.stringify(loginDto)
    });

    const respuesta = await request.text();
    if(respuesta != 'FAIL'){
        localStorage.token = respuesta;
        localStorage.email = loginDto.email;
        window.location.href = "Proceso/Gestión de Cultivo.html"
    }else{
        alert('las credenciales son incorrectas intente nuevamente');
    }
}