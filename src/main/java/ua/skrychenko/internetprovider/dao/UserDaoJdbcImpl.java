package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private final String SQL_FIND_ALL = "SELECT * FROM users";
    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;

    public UserDaoJdbcImpl() {
    }

    @Override
    public List<UserEntity> findAll() {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<UserEntity> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL_FIND_ALL);
            while (rs.next()) {
                users.add(new UserEntity(rs.getString("username")));
            }

        }
        catch (SQLException s) {
            s.printStackTrace();
        }
        return users;
    }
}

