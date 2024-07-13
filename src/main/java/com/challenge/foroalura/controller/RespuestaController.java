package com.challenge.foroalura.controller;

import com.challenge.foroalura.domain.respuesta.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    RespuestaService respuestaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosMostrarRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistrarRespuesta datos){
        var response = respuestaService.registrarRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosMostrarRespuesta>> listadoRespuestas(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosMostrarRespuesta::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosMostrarRespuesta> buscarRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);

        var response = new DatosMostrarRespuesta(respuesta);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta rtaActualizada) {
        Respuesta respuesta = respuestaRepository.getReferenceById(rtaActualizada.id());
        respuesta.actualizarDatos(rtaActualizada);

        var response = new DatosMostrarRespuesta(respuesta);
        return ResponseEntity.ok(response);
    }
    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        respuestaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}