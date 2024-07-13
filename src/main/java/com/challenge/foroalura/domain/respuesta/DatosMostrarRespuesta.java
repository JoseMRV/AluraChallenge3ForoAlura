package com.challenge.foroalura.domain.respuesta;

import java.time.LocalDateTime;

public record DatosMostrarRespuesta(
        Long id,
        String autor,
        String tituloTema,
        LocalDateTime fechaCreacion,
        String solucion
) {
    public DatosMostrarRespuesta(Respuesta respuesta){
        this(respuesta.getId(),respuesta.getAutor().getNombre(),
                respuesta.getTema().getTitulo(), respuesta.getFechaCreacion(),
                respuesta.getSolucion());
    }
}
