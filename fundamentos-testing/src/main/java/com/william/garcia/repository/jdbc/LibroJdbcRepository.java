package com.william.garcia.repository.jdbc;

import com.william.garcia.domain.Libro;
import com.william.garcia.repository.LibroRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedHashSet;

public class LibroJdbcRepository implements LibroRepository {
    private final DataSource dataSource;
    
    public LibroJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public Libro save(Libro libro) {
        String sql = "INSERT INTO libro(titulo, isbn, edicion, fecha_publicacion, capitulos, paginas)" +
            "VALUES(?,?,?,?,?,?)";
        try (
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getEdicion());
            ps.setDate(4, java.sql.Date.valueOf(libro.getFechaPublicacion()));
            ps.setInt(5, libro.getCapitulos());
            ps.setInt(6, libro.getPaginas());
            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                try (ResultSet rs = ps.getGeneratedKeys();) {
                    while (rs.next()) {
                        libro.setId(rs.getInt(1));
                    }
                }
            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }
    
    @Override
    public Libro findById(int id) {


        Libro libro = null;
        String sql = "SELECT * FROM libro l WHERE l.id = ?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    libro = mapLibro(rs);
                }
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }
    
    @Override
    public Collection<Libro> findAll() {
        Collection<Libro> libros = new LinkedHashSet<>();
        String sql = "SELECT * FROM libro";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                libros.add(mapLibro(rs));
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libros;
    }
    
    @Override
    public long count() {
        long count = 0;
        String sql = "SELECT COUNT(*) FROM libro";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return count;
    }
    
    @Override
    public Libro update(Libro libro) {
        String sql = "UPDATE libro SET titulo=?, isbn=? WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getId());
            int rowcount = ps.executeUpdate();
            if (rowcount != 1) {
                throw new SQLException("El 'update' no ocurrio, valor de: " +
                    rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }
    
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM libro WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            int rowcount = ps.executeUpdate();
            if (rowcount != 1) {
                throw new SQLException("El 'delete' no ocurrio, valor de: " +
                    rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
    }
    
    private Libro mapLibro(ResultSet rs) {
        Libro libro = null;
        try {
            libro = new Libro();
            libro.setId(rs.getInt("id"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setIsbn(rs.getString("isbn"));
            libro.setEdicion(rs.getInt("edicion"));
            libro.setFechaPublicacion(rs.getDate("fecha_publicacion").toLocalDate());
            libro.setCapitulos(rs.getInt("capitulos"));
            libro.setPaginas(rs.getInt("paginas"));
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }
}
