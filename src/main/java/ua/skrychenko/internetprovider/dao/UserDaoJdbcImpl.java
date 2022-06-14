package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private final String SQL_FIND_ALL = "SELECT * FROM users";
    private final String SQL_SAVE_USER = "INSERT INTO users(username, password) VALUES (? , ?);";
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

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return users;
    }

    @Override
    public void saveUser(String userName, String password) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(SQL_SAVE_USER);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

