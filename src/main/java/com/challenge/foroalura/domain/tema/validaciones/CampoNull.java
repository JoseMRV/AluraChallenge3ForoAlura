package com.challenge.foroalura.domain.tema.validaciones;

import com.challenge.foroalura.domain.tema.DatosRegistrarTema;
import com.challenge.foroalura.infra.errores.ValidacionIntegridad;
import org.springframework.stereotype.Component;

@Component
public class CampoNull implements ValidadorTema{
    @Override
    public void validar(DatosRegistrarTema datos){
        if(datos.idUsuario() == null){
            throw new ValidacionIntegridad("idUsuario no puede ser null");
        }
        if(datos.titulo() == null){
            throw new ValidacionIntegridad("Titulo no puede ser null");
        }
        if(datos.mensaje() == null){
            throw new ValidacionIntegridad("Mensaje no puede ser null");
        }
        if(datos.curso() == null){
            throw new ValidacionIntegridad("Curso no puede ser null");
        }
    }
}