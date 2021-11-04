package com.sung.factory;

import com.sung.book.BookDao;
import com.sung.book.BookDaoImpl;
import com.sung.user.UserDao;
import com.sung.user.UserDaoImpl;

public class DaoFactory {

	private static UserDao userDao;
	private static BookDao bookDao;

	private DaoFactory() {}

	public static UserDao getUserDao() {
		if (userDao == null)
			userDao = new UserDaoImpl();
		return userDao;
	}

	public static BookDao getBookDao() {
		if (bookDao == null)
			bookDao = new BookDaoImpl();
		return bookDao;
	}

}
