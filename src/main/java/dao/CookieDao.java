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

public class CookieDao  {
    Cookie cookie;
    private Connection connection;
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public CookieDao(Connection connection) {
        this.connection = connection;
    }


    public List<Object> selectAll(String tableName) {

        LinkedList<Object> cookies = new LinkedList<>();

        String select = String.format("SELECT * FROM %s ", tableName);
        try (PreparedStatement statement = connection.prepareStatement(select);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                cookie=new Cookie();
                cookie.setId(resultSet.getInt("id"));
                cookie.setCookie(resultSet.getString("cookie"));

                cookies.add(cookie);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        return cookies;


    }


    public Object selectById(int id) {

        String select = String.format("SELECT * FROM COOKIES WHERE ID ='%s'", id);
        try (PreparedStatement statement = connection.prepareStatement(select);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {

                cookie=new Cookie();
                cookie.setId(resultSet.getInt("id"));
                cookie.setCookie(resultSet.getString("cookie"));

            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }

        return cookie;

    }



}
