package com.challenge.foroalura.domain.respuesta;

import com.challenge.foroalura.domain.tema.Tema;
import com.challenge.foroalura.domain.tema.TemaRepository;
import com.challenge.foroalura.domain.usuario.Usuario;
import com.challenge.foroalura.domain.usuario.UsuarioRepository;
import com.challenge.foroalura.infra.errores.ValidacionIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TemaRepository temaRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    public DatosMostrarRespuesta registrarRespuesta(DatosRegistrarRespuesta datos){
        if (!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionIntegridad("Usuario no encontrado");
        }
        if (!temaRepository.existsById(datos.idTema())){
            throw new ValidacionIntegridad("Tema no encontrado");
        }
        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        Tema tema = temaRepository.getReferenceById(datos.idTema());

        Respuesta nuevaRespuesta = new Respuesta(datos.solucion(), tema, usuario);
        respuestaRepository.save(nuevaRespuesta);

        return new DatosMostrarRespuesta(nuevaRespuesta);
    }
}
