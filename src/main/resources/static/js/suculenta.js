document.addEventListener('DOMContentLoaded', function () {

    // Llena el modal del formulario segun el boton (Nueva suculenta o Editar)
    const modalSuculenta = document.getElementById('modalSuculenta');
    modalSuculenta.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        const modo = button.getAttribute('data-modo');

        document.getElementById('formSuculenta').reset();
        document.getElementById('tituloModal').textContent = button.getAttribute('data-titulo');
        document.getElementById('idSuculenta').value = '';

        if (modo === 'editar') {
            document.getElementById('idSuculenta').value = button.getAttribute('data-id');
            document.getElementById('nombreComun').value = button.getAttribute('data-nombrecomun');
            document.getElementById('nombreCientifico').value = button.getAttribute('data-nombrecientifico');
            document.getElementById('familia').value = button.getAttribute('data-familia') || '';
            document.getElementById('colorPrincipal').value = button.getAttribute('data-colorprincipal') || '';
            document.getElementById('alturaCm').value = button.getAttribute('data-alturacm') || '';
            document.getElementById('precioEstimado').value = button.getAttribute('data-precioestimado') || '';
            document.getElementById('nivelRiego').value = button.getAttribute('data-nivelriego') || '';
            document.getElementById('rutaImagen').value = button.getAttribute('data-rutaimagen') || '';
        }
    });

    // Pasa el id y el nombre al modal de eliminar
    const modalEliminar = document.getElementById('modalEliminar');
    modalEliminar.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        document.getElementById('idEliminar').value = button.getAttribute('data-id');
        document.getElementById('nombreEliminar').textContent = button.getAttribute('data-nombre');
    });

    // Oculta los mensajes despues de unos segundos
    setTimeout(function () {
        document.querySelectorAll('.toast').forEach(function (toast) {
            toast.classList.remove('show');
        });
    }, 4000);
});
