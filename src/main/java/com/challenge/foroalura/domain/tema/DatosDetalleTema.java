package com.challenge.foroalura.domain.tema;

public record DatosDetalleTema(
        Long id,
        String usuario,
        String titulo,
        String mensaje,
        String curso
) {
    public DatosDetalleTema(Tema tema){
        this(tema.getId(),tema.getUsuario().getNombre(),
                tema.getTitulo(), tema.getMensaje(), tema.getCurso());
    }
}
