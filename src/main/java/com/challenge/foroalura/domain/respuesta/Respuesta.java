package com.challenge.foroalura.domain.respuesta;

import com.challenge.foroalura.domain.tema.Tema;
import com.challenge.foroalura.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String solucion;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Tema tema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Respuesta(String mensaje, Tema tema, Usuario usuario) {
        this.solucion = mensaje;
        this.fechaCreacion = LocalDateTime.now();
        this.tema = tema;
        this.autor = usuario;
    }

    public void actualizarDatos(DatosActualizarRespuesta datos){
        if(datos.solucion() != null){
            this.solucion = datos.solucion();
            this.fechaCreacion = LocalDateTime.now();
        }
    }
    public Long getId() {
        return id;
    }

    public String getSolucion() {
        return solucion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Tema getTema() {
        return tema;
    }

    public Usuario getAutor() {
        return autor;
    }
}
