package com.sung.user;

import java.sql.SQLException;

public interface UserDao {

	void addUser(User user) throws SQLException;
//	void updateUser(User user) throws SQLException;
	void removeUser(User user) throws SQLException;
	User getUserByUsername(String username) throws SQLException;

}
