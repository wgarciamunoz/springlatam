package com.william.garcia.repository;

import com.william.garcia.domain.Libro;

import java.util.Collection;

public interface LibroRepository {
    Libro save(Libro libro);
    
    Libro findById(int id);
    
    Collection<Libro> findAll();
    
    long count();
    
    Libro update(Libro libro);
    
    void delete(int id);
}
