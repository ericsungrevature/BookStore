package com.sung.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addUser(User user) throws SQLException {
		String sql = "insert into user values (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getUsername());
		statement.setString(4, user.getPassword());
		statement.executeUpdate();
	}

//	@Override
//	public void updateUser(User user) throws SQLException {}

	@Override
	public void removeUser(User user) throws SQLException {
		String sql = "delete from user where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.executeUpdate();
	}

	@Override
	public User getUserByUsername(String username) throws SQLException {
		User user = new User();
		String sql = "select * from user where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		user.setFirstName(resultSet.getString(1));
		user.setLastName(resultSet.getString(2));
		user.setUsername(resultSet.getString(3));
		user.setPassword(resultSet.getString(4));
		return user;
	}

}
