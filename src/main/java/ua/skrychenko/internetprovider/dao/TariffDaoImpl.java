package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.TariffEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TariffDaoImpl implements TariffDao {

    private final String SQL_EDIT_TARIFF = "UPDATE tariff SET";
    private final String SUB_SQL_EDIT_TARIFF = " WHERE id = ?";
    private final String SQL_DELETE_TARIFF = "DELETE FROM tariff WHERE id = ?";
    private final String SQL_GET_TARIFF = "SELECT tariff.id, tariff.name, tariff.price FROM tariff  JOIN service ON tariff.service_id = service.id WHERE service.name = ?";

    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;

    @Override
    public void editTariff(String id, String newName, String newPrice) {
        try {
            this.connection = dataSource.getConnection();

            String nameSql = null;
            String priceSql = null;

            if (newName != null) {
                nameSql = " name = ?";
            }
            if (newPrice != null) {
                priceSql = " price = ?";
            }
            String result = Stream.of(nameSql, priceSql).filter(Objects::nonNull).collect(Collectors.joining(","));

            PreparedStatement ps = connection.prepareStatement(SQL_EDIT_TARIFF + result + SUB_SQL_EDIT_TARIFF);
            if (nameSql != null && priceSql == null) {
                ps.setString(1, newName);
                ps.setInt(2, Integer.parseInt(id));
                ps.execute();
            }
            if (nameSql == null && priceSql != null) {
                ps.setInt(1, Integer.parseInt(newPrice));
                ps.setInt(2, Integer.parseInt(id));
            } else {
                ps.setString(1, newName);
                ps.setInt(2, Integer.parseInt(newPrice));
                ps.setInt(3, Integer.parseInt(id));
            }
            ps.execute();

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteTariff(int id) {
        try {
            this.connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_TARIFF);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TariffEntity> getTariff(String service) {
        List<TariffEntity> tariffEntities = new ArrayList<>();
        try {
            this.connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_GET_TARIFF);
            ps.setString(1, service);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tariffEntities.add(new TariffEntity(rs.getInt("id"), rs.getString("name"), rs.getString("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tariffEntities;
    }
}