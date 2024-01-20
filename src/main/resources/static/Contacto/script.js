document.getElementById('formulario').addEventListener('submit', function(event) {
    event.preventDefault();

    var nombre = document.getElementById('nombre').value;
    var telefono = document.getElementById('telefono').value;
    var email = document.getElementById('email').value;
    var consulta = document.getElementById('consulta').value;
    var mensaje = document.getElementById('mensaje').value;

    // Aquí puedes realizar acciones con los datos del formulario, como enviarlos a un servidor o mostrarlos en la consola
    console.log('Nombre:', nombre);
    console.log('Teléfono:', telefono);
    console.log('Correo Electrónico:', email);
    console.log('Tipo de Consulta:', consulta);
    console.log('Mensaje:', mensaje);

    // Puedes añadir lógica adicional aquí, como enviar los datos a un servidor a través de una solicitud AJAX
});

document.getElementById('helpButton').addEventListener('click', function() {
    alert('¡Ayuda en camino! Por favor, espera a nuestro equipo de soporte.');
});

// Inicializar el mapa
function initMap() {
    var myLatLng = {lat: -34.397, lng: 150.644}; // Coordenadas para el centro del mapa
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 14,
        center: myLatLng
    });
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Empresa XYZ'
    });
}
