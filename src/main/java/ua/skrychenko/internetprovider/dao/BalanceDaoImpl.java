package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BalanceDaoImpl implements BalanceDao {

    private final String SQL_CREATE_NEW_BALANCE = "INSERT INTO balance (sum, status) VALUES (0, true)";
    private final String SQL_RETURN_MAX_ID_OF_BALANCE = "SELECT MAX(id) FROM balance";

    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;

    @Override
    public int createBalance(UserEntity userEntity) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = 0;

        try {
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_NEW_BALANCE);
            ResultSet rs = statement.executeQuery(SQL_RETURN_MAX_ID_OF_BALANCE);
            while (rs.next()) {
                id = rs.getInt("max");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void topUpBalance(int userId, int sum) {

    }

    @Override
    public void topDownBalance(int userID, int sum) {

    }
}
