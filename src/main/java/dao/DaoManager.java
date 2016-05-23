package dao;

import dao.substance.Cookie;
import dao.substance.User;

import java.util.List;

public interface DaoManager {


    List<Object> selectAll(String tableName);

    User selectLogin(String email);

    Object selectById(int id);

    int insert(User user);

    int delete();


}
