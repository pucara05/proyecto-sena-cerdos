$(document).ready(function() {
    var select = $('#selectHembra');
    var url = '/hembra-dni';

    // Llenar el select con datos obtenidos mediante AJAX
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            data.forEach(function(animal) {
                var optionText = 'DNI: ' + animal.dni + ', Sexo: ' + animal.sexo;
                var option = '<option value="' + animal.dni + '" data-sexo="' + animal.sexo + '">' + optionText + '</option>';
                select.append(option);
            });
        },
        error: function() {
            console.log('Error al obtener los datos de cerdos hembras');
        }
    });

    // Manejar el evento de cambio en el select
    select.change(function() {
        var selectedOption = $(this).find('option:selected');
        var selectedSexo = selectedOption.data('sexo');
        $('#sexoSeleccionado').val(selectedSexo);
    });

    // Validación antes de enviar el formulario
    $('#myForm').submit(function(event) {
        var selectedOption = select.val();
        if (selectedOption === "") {
            event.preventDefault();
            alert("Por favor, seleccione un cerdo hembra válido.");
        }
    });
});
