package com.william.garcia.service.impl;

import com.william.garcia.domain.Libro;
import com.william.garcia.repository.LibroRepository;
import com.william.garcia.service.LibroService;

import java.util.Collection;

public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;
    
    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    
    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
    
    @Override
    public Libro findById(int id) {
        return libroRepository.findById(id);
    }
    
    @Override
    public Collection<Libro> findAll() {
        return libroRepository.findAll();
    }
    
    @Override
    public long count() {
        return libroRepository.count();
    }
    
    @Override
    public Libro update(Libro libro) {
        return libroRepository.update(libro);
    }
    
    @Override
    public void delete(int id) {
        libroRepository.delete(id);
    }
    
    @Override
    public void reporte(Libro libro) {
        System.out.println("Reporte Libro");
        System.out.println(libro.toString());
    }
    
    @Override
    public void reporte(Collection<Libro> libros) {
        System.out.println("Reporte Libros...");
        for (Libro libro : libros) {
            reporte(libro);
        }
    }
    
    @Override
    public void reporte(long count) {
        System.out.println("Reporte Cantidad Libros: " + count);
    }
}
