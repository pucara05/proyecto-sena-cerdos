$(document).ready(function() {
    var select = $('#selectHembra');

    // URL del endpoint que devuelve los cerdos hembra
    var url = '/api/animals/hembra';

    // Realizar petición GET al backend para obtener los datos de cerdos hembra
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            data.forEach(function(animal) {
                var optionText = 'DNI: ' + animal.dni + ', Sexo: ' + animal.sexo; // Texto personalizado para mostrar en el select
                var option = '<option value="' + animal.id + '">' + optionText + '</option>';
                select.append(option);
            });
        },
        error: function() {
            console.log('Error al obtener los datos de cerdos hembras');
        }
    });
});
