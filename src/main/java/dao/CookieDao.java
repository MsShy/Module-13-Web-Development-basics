package dao;


import dao.substance.Cookie;
import dao.substance.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CookieDao implements DaoManager {
    Cookie cookie;
    private Connection connection;
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public CookieDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Object> selectAll(String tableName) {

        LinkedList<Object> cookies = new LinkedList<>();

        String select = String.format("SELECT * FROM %s ", tableName);
        try (PreparedStatement statement = connection.prepareStatement(select);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                cookies.add(new Cookie(resultSet.getInt("id"), resultSet.getString("cookie")));
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        return cookies;


    }

    @Override
    public User selectLogin(String email) {
        return null;
    }

    @Override
    public Object selectById(int id) {

        String select = String.format("SELECT * FROM COOKIES WHERE ID ='%s'", id);
        try (PreparedStatement statement = connection.prepareStatement(select);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                cookie = (new Cookie(resultSet.getInt("id"),resultSet.getString("cookie")));
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        return cookie;

    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
