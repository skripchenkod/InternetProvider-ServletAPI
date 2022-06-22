package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TariffDaoImpl implements TariffDao {

    private final String SQL_EDIT_TARIFF = "UPDATE tariff SET";
    private final String SUB_SQL_EDIT_TARIFF = " WHERE id = ?";
    private final String SQL_DELETE_TARIFF = "DELETE FROM tariff WHERE id = ?";

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE_TARIFF);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}