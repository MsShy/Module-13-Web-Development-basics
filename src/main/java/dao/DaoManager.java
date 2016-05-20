package dao;

import java.util.List;

public interface DaoManager {


	List<User> selectAll(String tableName);

User selectLogin(String email);

	int insert(User user);

	int delete();


}
