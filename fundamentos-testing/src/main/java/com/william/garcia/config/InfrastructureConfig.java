package com.william.garcia.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class InfrastructureConfig {
    public DataSource createDataSourceMysql() {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/springlatam_laboratory_v1?allowPublicKeyRetrieval=true&useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("Cucuta.2023$");
            dataSource.setServerTimezone("UTC");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }
}
