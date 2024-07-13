package com.challenge.foroalura.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarRespuesta(
        @NotNull
        Long idUsuario,
        @NotNull
        Long idTema,
        @NotBlank
        String solucion
) {
}
