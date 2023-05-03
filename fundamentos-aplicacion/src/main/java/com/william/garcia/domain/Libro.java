package com.william.garcia.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String titulo;
    private String isbn;
    private int edicion;
    private LocalDate fechaPublicacion;
    private int capitulos;
    private int paginas;
    
    public Libro() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getEdicion() {
        return edicion;
    }
    
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public int getCapitulos() {
        return capitulos;
    }
    
    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }
    
    public int getPaginas() {
        return paginas;
    }
    
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return id == libro.id && edicion == libro.edicion && capitulos == libro.capitulos && paginas == libro.paginas && Objects.equals(titulo, libro.titulo) && Objects.equals(isbn, libro.isbn) && Objects.equals(fechaPublicacion, libro.fechaPublicacion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, isbn, edicion, fechaPublicacion, capitulos, paginas);
    }
    
    @Override
    public String toString() {
        return "Libro{" +
            "id=" + id +
            ", titulo='" + titulo + '\'' +
            ", isbn='" + isbn + '\'' +
            ", edicion=" + edicion +
            ", fechaPublicacion=" + fechaPublicacion +
            ", capitulos=" + capitulos +
            ", paginas=" + paginas +
            '}';
    }
}
