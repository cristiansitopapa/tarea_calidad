function borrar(e, cod, cont) {
    e.preventDefaul();
    console.log(cont);
    Swal.fire({
        title: 'Ojo manito',
        text: "¿Seguro que lo quiere borrar?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Re si',
        cancelButtonText: 'No, me arrepenti'
    }).then((result) => {
        if (result.isConfirmed) {
            ruta = cont + "?accion=eliminar&id=" + cod;
            console.log(ruta);
            window.setTimeout(function() { window.location.href = ruta }, 2000);
            Swal.fire({
                position: 'middle',
                icon: 'success',
                title: 'Lo borraste',
                showConfirmButton: false,
                timer: 1500
            })
        } else {
            swal.fire(
                'Cancelado',
                'Cancelaste la eliminación',
                'error');

        }
    });
};