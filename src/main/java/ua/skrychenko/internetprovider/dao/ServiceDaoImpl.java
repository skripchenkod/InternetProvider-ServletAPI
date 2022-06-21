package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.ServiceEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao{

    private String SQL_GET_ALL_SERVICE = "SELECT name FROM service";

    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;

    @Override
    public List<String> getAll() {
        List<String> nameOfService= new ArrayList<>();
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_GET_ALL_SERVICE);

            while (rs.next()){
                String name = rs.getString("name");
                nameOfService.add(name);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return nameOfService;
    }
}
