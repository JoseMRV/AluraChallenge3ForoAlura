package com.challenge.foroalura.domain.tema.validaciones;

import com.challenge.foroalura.domain.tema.DatosRegistrarTema;
import com.challenge.foroalura.domain.tema.TemaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemaRepetido implements ValidadorTema{
    @Autowired
    TemaRepository temaRepository;

    @Override
    public void validar(DatosRegistrarTema datos) {
        var tituloExistente = temaRepository.existsByTitulo(datos.titulo());
        var mensajeExistente = temaRepository.existsByMensaje(datos.mensaje());

        if (tituloExistente && mensajeExistente){
            throw new ValidationException("Este tema ya existe.");
        }
    }
}
