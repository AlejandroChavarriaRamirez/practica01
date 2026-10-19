document.addEventListener('DOMContentLoaded', function () {

    // Llena el modal con los datos del boton (en Nueva suculenta queda vacio)
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

    // Pide confirmacion antes de eliminar
    document.querySelectorAll('.form-eliminar').forEach(function (form) {
        form.addEventListener('submit', function (evento) {
            if (!confirm(form.dataset.mensaje)) {
                evento.preventDefault();
            }
        });
    });
});
