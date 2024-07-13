package com.challenge.foroalura.controller;

import com.challenge.foroalura.domain.tema.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temas")
@SecurityRequirement(name = "bearer-key")
public class TemaController {
    @Autowired
    TemaRepository temaRepository;
    @Autowired
    TemaService temaService;
    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleTema> registrarTema(
            @RequestBody @Valid DatosRegistrarTema datos){

        var response = temaService.registrarTema(datos);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<Page<DatosDetalleTema>> listaDeTemas(
            @PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(temaRepository.findByStatusTrue(paginacion)
                .map(DatosDetalleTema::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTema> buscarTema(
            @PathVariable Long id) {

        Tema tema = temaRepository.getReferenceById(id);

        var response = new DatosDetalleTema(tema);
        return ResponseEntity.ok(response);
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTema(
            @RequestBody @Valid DatosActualizarTema temaActualizado){

        Tema tema = temaRepository.getReferenceById(temaActualizado.id());
        tema.actualizarDatos(temaActualizado);

        var response = new DatosDetalleTema(tema);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTema(
            @PathVariable Long id){

        Tema tema = temaRepository.getReferenceById(id);
        tema.borrarTema();
        return ResponseEntity.noContent().build();
    }
}
