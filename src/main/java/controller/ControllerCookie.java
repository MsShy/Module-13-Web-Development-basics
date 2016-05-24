package controller;


import dao.ConnectionFactory;
import dao.CookieDao;
import dao.Factory;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


@WebServlet(urlPatterns = {"/ControllerCookie"})
public class ControllerCookie extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(ControllerLogin.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection;

        Factory factory = new ConnectionFactory("jdbc:h2:D:\\homeworks\\Module-13-Web-Development-basics\\test", "sa", "");
        try {

            connection = factory.getConnection();
            CookieDao cookieManager = factory.getCookieDao(connection);
            List<Object> cookies = cookieManager.selectAll("cookies");
            int cookiesLength = cookies.size();
            int id = getRandom(cookiesLength);
            Object cookie = cookieManager.selectById(id);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(cookie);
            log.info(jsonString);
            log.info(id+"id");
            log.info(cookiesLength+"size");
            response.getWriter().write(jsonString);

            factory.closePool();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getRandom(int cookiesLength) {



        int id = (int) (Math.random()*cookiesLength+1);

        log.info(id+"idRandom");
        return id;
    }
}