package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.config.PostgresConfig;
import ua.skrychenko.internetprovider.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private final String SQL_FIND_ALL = "SELECT * FROM users";
    private final String SQL_SAVE_USER = "INSERT INTO users(username, password, balance_id, role_id) VALUES (?, ?, ?, ?);";
    private final String SQL_FIND_USER_BY_NAME = "SELECT * FROM users WHERE username = ?";
    private final String SQL_LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
    private final String SQL_SELECT_ROLE = "SELECT name  FROM role WHERE id = (SELECT  users.role_id FROM users WHERE username = ?)";
    private final DataSource dataSource = PostgresConfig.getInstance();
    private Connection connection;

    public UserDaoJdbcImpl() {
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        try {
            this.connection = dataSource.getConnection();

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
    public void saveUser(UserEntity userEntity) {
        BalanceDaoImpl balanceDao = new BalanceDaoImpl();
        try {
            this.connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_SAVE_USER);
            ps.setString(1, userEntity.getUserName());
            ps.setString(2, userEntity.getPassword());
            ps.setInt(3, balanceDao.createBalance(userEntity));
            ps.setInt(4, userEntity.getRole().getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExistUser(String userName) {
        String name = null;
        try {
            this.connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_FIND_USER_BY_NAME);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString("username");
            }

            if (name == null) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean chekUser(UserEntity userEntity) {
        String name = null;
        try {
            this.connection = dataSource.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_LOGIN);
            ps.setString(1, userEntity.getUserName());
            ps.setString(2, userEntity.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("username");
            }

            if (name != null) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String selectRole(UserEntity userEntity) {
        String unKnownRole = "unKnown";
        if (chekUser(userEntity)) {
            try {
                this.connection = dataSource.getConnection();

                String role = null;
                PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ROLE);
                ps.setString(1, userEntity.getUserName());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    role = rs.getString("name");
                }
                return role;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return unKnownRole;
    }
}

