package com.challenge.foroalura.domain.tema;

import com.challenge.foroalura.domain.tema.validaciones.ValidadorTema;
import com.challenge.foroalura.domain.usuario.Usuario;
import com.challenge.foroalura.domain.usuario.UsuarioRepository;
import com.challenge.foroalura.infra.errores.ValidacionIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TemaRepository temaRepository;

    @Autowired
    List<ValidadorTema> validador;


    public DatosDetalleTema registrarTema(DatosRegistrarTema datos) {
        if (!usuarioRepository.existsById(datos.idUsuario())) {
            throw new ValidacionIntegridad("Usuario no encontrado");
        }

        validador.forEach(v->v.validar(datos));

        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        var temaNuevo = new Tema(datos.titulo(), datos.mensaje(), usuario, datos.curso());

        temaRepository.save(temaNuevo);

        return new DatosDetalleTema(temaNuevo);
    }
}
