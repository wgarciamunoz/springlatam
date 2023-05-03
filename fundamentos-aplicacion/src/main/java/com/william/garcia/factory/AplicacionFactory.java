package com.william.garcia.factory;

import com.william.garcia.config.InfrastructureConfig;
import com.william.garcia.repository.LibroRepository;
import com.william.garcia.repository.jdbc.LibroJdbcRepository;
import com.william.garcia.service.LibroService;
import com.william.garcia.service.impl.LibroServiceImpl;

public class AplicacionFactory {
    private static InfrastructureConfig createInfrastructureConfig() {
        return new InfrastructureConfig();
    }
    
    private static LibroRepository createLibroRepository() {
        return new LibroJdbcRepository(createInfrastructureConfig().createDataSourceMysql());
    }
    
    private static LibroService createLibroService() {
        return new LibroServiceImpl(createLibroRepository());
    }
    
    public static void createAplicacion() {

    }
    
    public static LibroService getLibroService() {
        return createLibroService();
    }
}
