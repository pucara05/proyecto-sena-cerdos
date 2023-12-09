document.querySelectorAll('.eliminar-btn').forEach(button => {
    button.addEventListener('click', function() {
        let userId = this.getAttribute('data-user-id');
        eliminarUsuario(userId);
    });
});

function eliminarUsuario(userId) {
    if (confirm('¿Estás seguro que deseas eliminar este usuario?')) {
        fetch('/eliminar/' + userId, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                // Eliminar la fila de la tabla
                let rowId = 'user-' + userId;
                let rowToRemove = document.getElementById(rowId);
                if (rowToRemove) {
                    rowToRemove.remove();
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
