package com.sung.book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

	void addBook(Book book) throws SQLException;
	void updateBook(Book book) throws SQLException;
	void removeBook(Book book) throws SQLException;
	List<Book> getBooksByCategory(String category) throws SQLException;
	Book getBookByISBN(int isbn) throws SQLException;

}
