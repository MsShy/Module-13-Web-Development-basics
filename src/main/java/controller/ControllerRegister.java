package controller;

import dao.ConnectionFactory;
import dao.DaoManager;
import dao.Factory;
import dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet(urlPatterns = {"/register"})
public class ControllerRegister extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ControllerRegister.class);
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Connection connection;


        Factory factory = new ConnectionFactory("jdbc:h2:D:\\homeworks\\Module-13-Web-Development-basics\\test", "sa", "");
        try {

            connection = factory.getConnection();
            DaoManager manager = factory.getUserDao(connection);

            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String email = request.getParameter("email");
            String yearBirth = request.getParameter("yearBirth");
            String password = request.getParameter("pass");

            User user1 = new User(lastName, firstName, email, yearBirth, password);
            int rows = manager.insert(user1);

            factory.closePool();
            if (rows > 0) {
                log.info("register " + rows);
                RequestDispatcher dispatcher = request.getRequestDispatcher("site/index.html");
                dispatcher.forward(request, response);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
