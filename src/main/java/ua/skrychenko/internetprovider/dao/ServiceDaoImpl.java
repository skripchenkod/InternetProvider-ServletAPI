package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.ServiceEntity;
import ua.skrychenko.internetprovider.entity.TariffEntity;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDaoImpl implements ServiceDao {

    private final String SQL_GET_ALL_SERVICE = "SELECT service.name as service_name, tariff.name as tariff_name, tariff.price FROM service, tariff WHERE service.id = tariff.service_id";
    private final String SQL_GET_SERVICE_BY_NAME = "SELECT service.name as service_name, tariff.name as tariff_name FROM users_services, users, service, tariff WHERE users_services.user_id = users.id AND users_services.service_id = service.id AND users_services.tariff_id = tariff.id AND users.username = ?";

    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;


    @Override
    public Map<ServiceEntity, List<TariffEntity>> getAll() {
        Map<ServiceEntity, List<TariffEntity>> map = new HashMap<>();
        try {
            this.connection = dataSource.getConnection();

            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(SQL_GET_ALL_SERVICE);


            while (rs.next()) {
                ServiceEntity serviceEntity = new ServiceEntity(rs.getString("service_name"));
                TariffEntity tariffEntity = new TariffEntity(rs.getString("tariff_name"), rs.getString("price"));

                if (map.containsKey(serviceEntity)) {
                    map.get(serviceEntity).add(tariffEntity);
                } else {
                    List<TariffEntity> tariffEntities = new ArrayList<>();
                    tariffEntities.add(tariffEntity);
                    map.put(serviceEntity, tariffEntities);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public String getServiceByName(String userName) {
        String information = "";

        try {
            this.connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_GET_SERVICE_BY_NAME);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                information += rs.getString("service_name") + " " + rs.getString("tariff_name") + "\n";

            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return information;
    }
}
