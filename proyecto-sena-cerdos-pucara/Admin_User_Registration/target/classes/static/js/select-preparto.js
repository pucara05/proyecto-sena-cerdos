$(document).ready(function() {
    var select = $('#selectPreparto');
    var url = '/parto-dni'; // La URL para obtener los datos de preparto

    // Llenar el select con datos obtenidos mediante AJAX al cargar la página
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            data.forEach(function(animal) {
                var optionText = 'DNI: ' + animal.dni + ', Estado Salud: ' + animal.estadoSalud;
                var option = '<option value="' + animal.dni + '">' + optionText + '</option>';
                select.append(option);
            });
        },
        error: function() {
            console.log('Error al obtener los datos de preparto');
        }
    });
});
