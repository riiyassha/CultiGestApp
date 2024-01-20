document.getElementById('cultivo-form').addEventListener('submit', function(event) {
    event.preventDefault();

    var nombre = document.getElementById('nombre').value;
    var siembra = document.getElementById('siembra').value;
    var agua = document.getElementById('agua').value;

    var resultadoDiv = document.getElementById('resultado');
    resultadoDiv.innerHTML = `Cultivo: ${nombre}<br>Fecha de Siembra: ${siembra}<br>Cantidad de Agua: ${agua} litros por semana`;
});


document.getElementById('calcular').addEventListener('click', function() {
    var tipoCultivo = document.getElementById('tipo-cultivo').value;
    var cantidadComprar = parseFloat(document.getElementById('cantidad-comprar').value);
    var costoUnidad = parseFloat(document.getElementById('costo-unidad').value);
    var cantidadCosecha = parseFloat(document.getElementById('cantidad-cosecha').value);

    var costoTotal = cantidadComprar * costoUnidad;
    var gananciaPerdida = (cantidadCosecha * costoUnidad) - costoTotal;

    var resultadoDiv = document.getElementById('resultado');
    resultadoDiv.innerHTML = '';

    var resultadoP = document.createElement('p');
    resultadoP.textContent = 'Resultado:';
    resultadoDiv.appendChild(resultadoP);

    var ul = document.createElement('ul');

    var li1 = document.createElement('li');
    li1.textContent = 'Costo total de compra: ' + costoTotal.toFixed(2);
    ul.appendChild(li1);

    var li2 = document.createElement('li');
    li2.textContent = 'Ganancia/Perdida: ' + gananciaPerdida.toFixed(2);
    ul.appendChild(li2);

    resultadoDiv.appendChild(ul);
});