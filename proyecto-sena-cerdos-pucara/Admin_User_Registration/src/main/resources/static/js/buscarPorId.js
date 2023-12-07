function buscarPorId() {
    var id = document.getElementById("buscarPorId").value;
    
    // Verificar si el ID es válido (puede que quieras hacer una validación aquí)
    if (id.trim() === "") {
        alert("Por favor, ingresa un ID antes de buscar.");
        return;
    }

    
    if (isNaN(id)) {
        alert("El ID debe ser un número.");
        return;
    }

    
    if (parseInt(id) <= 0) {
        alert("El ID debe ser un número positivo.");
        return;
    }

    
    
    // Realizar la búsqueda
    window.location.href = "/animal/" + id; // Esto redirige a la ruta de búsqueda con el ID
}
