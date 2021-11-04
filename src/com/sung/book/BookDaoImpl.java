package com.sung.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sung.factory.ConnectionFactory;

public class BookDaoImpl implements BookDao {

	private Connection connection;

	public BookDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addBook(Book book) throws SQLException {
		String sql = "insert into book values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setDouble(3, book.getPrice());
		statement.setString(4, book.getCategory());
		statement.setInt(5, book.getISBN());
		statement.setString(6, book.getDescription());
		statement.setInt(7, book.getCount());
		statement.executeUpdate();
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		String sql = "update book set count = ? where isbn = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getCount());
		preparedStatement.setInt(2, book.getISBN());
		preparedStatement.executeUpdate();

	}

	@Override
	public void removeBook(Book book) throws SQLException {
		String sql = "delete from book where isbn = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getISBN());
		preparedStatement.executeUpdate();
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws SQLException {
		String sql = "select * from book where category = ? order by isbn";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, category);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (resultSet.next()) {
			Book book = new Book();
			book.setTitle(resultSet.getString(1));
			book.setAuthor(resultSet.getString(2));
			book.setPrice(resultSet.getDouble(3));
			book.setCategory(resultSet.getString(4));
			book.setISBN(resultSet.getInt(5));
			book.setDescription(resultSet.getString(6));
			book.setCount(resultSet.getInt(7));
			list.add(book);
		}
		return list;
	}

	@Override
	public Book getBookByISBN(int isbn) throws SQLException {
		String sql = "select * from book where isbn = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, isbn);
		ResultSet resultSet = preparedStatement.executeQuery();
		Book book = new Book();
		book.setTitle(resultSet.getString(1));
		book.setAuthor(resultSet.getString(2));
		book.setPrice(resultSet.getDouble(3));
		book.setCategory(resultSet.getString(4));
		book.setISBN(resultSet.getInt(5));
		book.setDescription(resultSet.getString(6));
		book.setCount(resultSet.getInt(7));
		return book;
	}

}
