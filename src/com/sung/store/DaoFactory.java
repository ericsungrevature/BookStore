package com.sung.store;

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
