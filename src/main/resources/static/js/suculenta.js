// Comportamiento de la pagina de suculentas
document.addEventListener('DOMContentLoaded', function () {

    // Al abrir el modal se llena con los data-* del boton que lo abrio.
    // El boton "Nueva suculenta" no trae datos, entonces el formulario queda vacio.
    const modal = document.getElementById('modalSuculenta');
    const formulario = document.getElementById('formSuculenta');
    const campos = ['idSuculenta', 'nombreComun', 'nombreCientifico', 'familia',
        'colorPrincipal', 'alturaCm', 'precioEstimado', 'nivelRiego', 'rutaImagen'];

    modal.addEventListener('show.bs.modal', function (evento) {
        const boton = evento.relatedTarget;
        document.getElementById('tituloModal').textContent = boton.dataset.titulo;
        campos.forEach(function (campo) {
            formulario.elements[campo].value = boton.dataset[campo] || '';
        });
    });

    // Antes de eliminar se pregunta al usuario; si cancela no se envia el formulario
    document.querySelectorAll('.form-eliminar').forEach(function (form) {
        form.addEventListener('submit', function (evento) {
            if (!confirm(form.dataset.mensaje)) {
                evento.preventDefault();
            }
        });
    });
});
