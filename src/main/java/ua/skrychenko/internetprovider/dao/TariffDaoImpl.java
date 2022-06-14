package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TariffDaoImpl implements TariffDao {

    private final String SQL_EDIT_NAME_OF_TARIFF = "UPDATE tariff SET name = ? WHERE id = ?";
    private final String SQL_EDIT_PRICE_OF_TARIFF = "UPDATE tariff SET price = ? WHERE id = ?";
    private final String SQL_DELETE_TARIFF = "DELETE FROM tariff WHERE id = ?";

    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;

    @Override
    public void editNameOfTariff(int id, String newName) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_EDIT_NAME_OF_TARIFF);
            ps.setString(1, newName);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editPriceOfTariff(int id, int newPrice) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_EDIT_PRICE_OF_TARIFF);
            ps.setInt(1, newPrice);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException e) {
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
