function eliminarUsuario(userId) {
    if (confirm('¿Estás seguro que deseas eliminar este usuario?')) {
        fetch('/eliminar/' + userId, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                // Eliminar la fila de la tabla
                const userRow = document.getElementById('userRow-' + userId);
                if (userRow) {
                    userRow.remove();
                }
            } else {
                alert('Hubo un error al eliminar el usuario.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Hubo un error al eliminar el usuario.');
        });
    }
}
