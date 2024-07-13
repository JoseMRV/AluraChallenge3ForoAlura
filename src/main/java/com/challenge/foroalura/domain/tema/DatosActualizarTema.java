package com.challenge.foroalura.domain.tema;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTema(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
}
