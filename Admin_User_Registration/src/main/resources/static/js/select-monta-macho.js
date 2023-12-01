$(document).ready(function() {
    var selectMacho = $('#selectMacho');
    var urlMacho = '/macho-dni'; // Endpoint para obtener cerdos macho

    // Llenar el select con datos de cerdos macho mediante AJAX
    $.ajax({
        url: urlMacho,
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            data.forEach(function(animal) {
                var optionText = 'DNI: ' + animal.dni + ', Sexo: ' + animal.sexo;
                var option = '<option value="' + animal.dni + '" data-sexo="' + animal.sexo + '">' + optionText + '</option>';
                selectMacho.append(option);
            });
        },
        error: function() {
            console.log('Error al obtener los datos de cerdos macho');
        }
    });

    // Manejar el evento de cambio en el select de cerdos macho
    selectMacho.change(function() {
        var selectedOption = $(this).find('option:selected');
        var selectedSexo = selectedOption.data('sexo');
        $('#sexoSeleccionadoMacho').val(selectedSexo);
    });

    // Validación antes de enviar el formulario
    $('#myForm').submit(function(event) {
        var selectedOption = selectMacho.val();
        if (selectedOption === "") {
            event.preventDefault();
            alert("Por favor, seleccione un cerdo macho válido.");
        }
    });
});
