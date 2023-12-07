function guardarCambios() {
    const dniCelo = document.getElementById('dni').value;
    const fechaCelo = document.getElementById('fechaCelo').value;
    const animalId = document.getElementById('animalId').value;

    actualizarAnimal(animalId, dniCelo, fechaCelo);
}

function actualizarAnimal(animalId, dniCelo, fechaCelo) {
    fetch(`/animal_celo/modificar/${animalId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            dniCelo: dniCelo,
            fechaCelo: fechaCelo
            // Agrega aquí otros campos si es necesario
        })
    })
    .then(response => {
        if (response.ok) {
            console.log('Animal actualizado correctamente');
            // Aquí podrías redirigir a otra página o realizar alguna acción adicional después de la actualización exitosa
        } else {
            console.error('Error al actualizar el animal');
        }
    })
    .catch(error => {
        console.error('Error de red:', error);
    });
}
