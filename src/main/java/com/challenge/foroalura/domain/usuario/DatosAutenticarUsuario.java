package com.challenge.foroalura.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticarUsuario(
        @NotBlank
        String email,
        @NotBlank
        String password) {
}