package dao;

import dao.substance.Cookie;
import dao.substance.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private Main() {
    }


    public static void main(String[] args) throws InterruptedException, SQLException {


        Factory factory = new ConnectionFactory("jdbc:h2:D:\\homeworks\\Module-13-Web-Development-basics\\test", "sa", "");

        Connection connection = factory.getConnection();
        UserDao manager = factory.getUserDao(connection);
        CookieDao cookieManager = factory.getCookieDao(connection);


        //User user1 = new User("Yurash", "Yurik", "misterY@mail.com", "1990", "853254dsf");

       // int rows = manager.insert(user1);
        //System.out.println(rows);
        User user = new User();//lastName, firstName, email, yearBirth, password);
        user.setLastName("Tr");
        user.setFirtsName("fff");
        user.setEmail("fffjfj@jj.com");
        user.setYearBirth("1990");
        user.setPassword("fjdjdjdd");
        int rows = manager.insert(user);

        //manager.delete();
       log.info("" + rows);
        List<Object> users = manager.selectAll("users");

        for (Object use : users) {
            System.out.print(use.toString());
        }


        List<Object> cookies = cookieManager.selectAll("cookies");
        for (Object cookie : cookies) {
            System.out.println(cookie.toString());
        }

        Object cookie = cookieManager.selectById(3);
        System.out.println(cookie);

         User user1=manager.selectLogin("rich@mail.com");
        if (user1.getEmail().equals("rich@mail.com")) {
            System.out.printf(user1.getPassword());
        } else {
            System.out.print(user1);
        }


        factory.closePool();

    }


}
