package ua.skrychenko.internetprovider.config;

import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;

public class PostgresConfig {

    private static PGPoolingDataSource instance;

    private PostgresConfig() {

    }

    public static DataSource getInstance() {
        if (instance == null) {
            synchronized (PostgresConfig.class) {
                if (instance == null) {
                    instance = new PGPoolingDataSource();
                    instance.setUser("postgres");
                    instance.setPassword("postgres");
                    instance.setUrl("jdbc:postgresql://localhost:5432/Internet-provider");
                 }
            }
        }

        return instance;
    }
}