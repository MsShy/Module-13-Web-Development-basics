package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Logger log =LoggerFactory.getLogger(Main.class);

    private Main() {
    }


    public static void main(String[] args) throws InterruptedException, SQLException {


        Factory factory = new ConnectionFactory("jdbc:h2:D:\\homeworks\\Module-13-Web-Development-basics\\test", "sa", "");

        Connection connection = factory.getConnection();
        DaoManager manager = factory.getUserDao(connection);


        User user1 = new User("Yurash", "Yurik", "misterY@mail.com","1990",  "853254dsf");
        int rows = manager.insert(user1);
        //System.out.println(rows);

        //	manager.delete();
            log.info(""+rows);
        List<User> users = manager.selectAll("users");

        for (User user : users) {
            System.out.print(user.toString());
        }

        User user = manager.selectLogin("rich@mail.com");
        if (user.getEmail().equals("rich@mail.com")) {
            System.out.printf(user.getPassword());
        } else {
            System.out.print(user);
        }


        factory.closePool();

    }


}
