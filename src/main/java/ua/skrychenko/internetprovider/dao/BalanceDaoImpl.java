package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.entity.BalanceEntity;
import ua.skrychenko.internetprovider.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BalanceDaoImpl implements BalanceDao {

    private final String SQL_CREATE_NEW_BALANCE = "INSERT INTO balance (sum, status) VALUES (0, true)";
    private final String SQL_RETURN_MAX_ID_OF_BALANCE = "SELECT MAX(id) FROM balance";
    private final String SQL_GET_BALANCE = "SELECT balance.id, balance.sum, balance.status FROM balance  JOIN users ON users.balance_id = balance.id WHERE users.username = ?";
    private final String SQL_TOP_UP = "UPDATE balance SET sum = balance.sum + ? WHERE balance.id = (SELECT users.balance_id FROM users WHERE username = ?)";

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
    public void topUpBalance(String userName, int sum) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_TOP_UP);
            ps.setInt(1, sum);
            ps.setString(2, userName);
            ps.executeQuery();

        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    @Override
    public void topDownBalance(String userName, int sum) {

    }

    @Override
    public List<BalanceEntity> getBalance(String userName) {
        List<BalanceEntity> balanceEntities = new ArrayList<>();
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_GET_BALANCE);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                balanceEntities.add(new BalanceEntity(rs.getInt("id"), rs.getInt("sum"), rs.getBoolean("status")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return balanceEntities;
    }
}
