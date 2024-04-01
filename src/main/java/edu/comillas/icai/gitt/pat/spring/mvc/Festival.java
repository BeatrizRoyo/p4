package edu.comillas.icai.gitt.pat.spring.mvc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Festival {
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ciudad;
    private String rangoEdad;
    private String fecha;
    private String duracion;
    private String tipoMusica;

    // Constructor por defecto requerido por JPA
    public Festival() {
    }

    // Constructor con todos los campos
    public Festival(String nombre, String ciudad, String rangoEdad, String fecha, String duracion, String tipoMusica) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.rangoEdad = rangoEdad;
        this.fecha = fecha;
        this.duracion = duracion;
        this.tipoMusica = tipoMusica;
    }

    public void setId(Long id) {

    }

    // Getters y setters para todos los campos
    // ...
}
