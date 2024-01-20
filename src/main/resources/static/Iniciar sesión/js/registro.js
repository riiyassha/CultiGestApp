const postUser = 'http://localhost:8080/api/User';
 async function RegistrarUsuarios(){
    let datos = {};

    datos.name = document.getElementById('txtnombre').value;
    datos.password = document.getElementById('txtlastname').value;
    datos.email = document.getElementById('txtemail').value;
    datos.password = document.getElementById('txtcontraseña').value;

    let repetirpassword = document.getElementById('repetirPassword').value;

    if(repetirpassword != datos.password){
        alert('la contraseña es diferente');
        return null;
    }

    await fetch(postUser, {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body : JSON.stringify(datos)
    });

    alert('la cuenta fue creada con exito');
    window.location.href = "/Iniciar sesión.html"
 }