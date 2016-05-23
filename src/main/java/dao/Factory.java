package dao;

import java.sql.Connection;

public interface Factory {


	Connection getConnection() throws InterruptedException;

	DaoManager getUserDao(Connection connection);
	DaoManager getCookieDao(Connection connection);

	boolean closePool();


}
