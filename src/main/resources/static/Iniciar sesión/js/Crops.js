const cropsUrl = 'http://localhost:8080/api/Crops';

async function postCrops(){
    let cropsDto = {};
    
    cropsDto.name = document.getElementById('nombreCultivo');
    cropsDto.seedtime = document.getElementById('siembra');
    cropsDto.areacultivo = document.getElementById('AreaCultivo');
    cropsDto.email = localStorage.email;

    function getHeaders() {
        return {
         'Accept': 'application/json',
         'Content-Type': 'application/json',
         'Authorization': localStorage.token
       };
    }

    await fetch(cropsUrl,{
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(cropsDto)
    });



}