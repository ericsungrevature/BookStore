package com.sung.store;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sung.book.Book;
import com.sung.book.BookDao;
import com.sung.factory.DaoFactory;
import com.sung.user.User;
import com.sung.user.UserDao;

public class Store {

	private Scanner scan = new Scanner(System.in);
	private UserDao udao = DaoFactory.getUserDao();
	private BookDao bdao = DaoFactory.getBookDao();

	public void start() {
		String input;
		User user;
		while(true) {
			System.out.println("You may:\n"
					+ "1) Register\n"
					+ "2) Login\n"
					+ "3) Quit");
			System.out.print("What would you like to do? ");
			input = scan.nextLine();
			switch(input.toLowerCase()) {
			default:
				System.out.println("Invalid Input");
				break;
			case "1":
				System.out.println("Register");
				user = register(scan);
				if (user == null)
					break;
				userMenu(user, scan);
				break;
			case "2":
				System.out.println("Login");
				user = login(scan);
				if (user == null)
					break;
				userMenu(user, scan);
				break;
			case "3":
				System.out.println("Goodbye");
				scan.close();
				return;
			}
		}
	}

	public User register(Scanner scan) {
		try {
			User user = new User();
			String input;
			System.out.print("Enter your first name: ");
			input = scan.nextLine();
			user.setFirstName(input);
			System.out.print("Enter your last name: ");
			input = scan.nextLine();
			user.setLastName(input);
			System.out.print("Enter your username: ");
			input = scan.nextLine();
			user.setUsername(input);
			System.out.print("Enter your password: ");
			input = scan.nextLine();
			user.setPassword(input);
			udao.addUser(user);
			return user;
		} catch (SQLException e) {
			System.out.println("Invalid Register");
			return null;
		}
	}

	public User login(Scanner scan) {
		try {
			String input;
			System.out.print("Enter your username: ");
			input = scan.nextLine();
			User user = udao.getUserByUsername(input);
			System.out.print("Enter your password: ");
			input = scan.nextLine();			
			if (!user.getPassword().equals(input)) {
				System.out.println(user.getPassword());
				System.out.println(input);
				System.out.println("Wrong Password");
				throw new SQLException();
			}
			System.out.println("Welcome " + user.getFirstName());
			return user;
		} catch (SQLException e) {
			System.out.println("Invalid Login");
			return null;
		}
	}

	public void userMenu(User user, Scanner scan) {
		String input;
		while(true) {
			System.out.println("You may: \n"
					+ "1) View Books by Category\n"
					+ "2) View Shopping Cart\n"
					+ "3) Logout");
			System.out.print("What would you like to do? ");
			input = scan.nextLine();
			switch(input) {
			default:
				System.out.println("Invalid Input");
				break;
			case "1":
				System.out.println("View Books by Category");
				bookMenu(user, scan);
				break;
			case "2":
				System.out.println("View Shopping Cart");
				cartMenu(user, scan);
				break;
			case "3":
				System.out.println("Logout");
				return;
			}
		}
	}

	public void bookMenu(User user, Scanner scan) {
		String input;
		while(true) {
			System.out.println("Book Categories: \n"
					+ "0) Computer science, information and general works\n"
					+ "1) Philosophy and psychology\n"
					+ "2) Religion\n"
					+ "3) Social sciences\n"
					+ "4) Language\n"
					+ "5) Pure Science\n"
					+ "6) Technology\n"
					+ "7) Arts and recreation\n"
					+ "8) Literature\n"
					+ "9) History and geography\n"
					+ "10) Exit");
			System.out.print("Which category would you like to view? ");
			input = scan.nextLine();
			List<Book> list;
			switch(input.toLowerCase()) {
			default:
				System.out.println("Invalid Input");
				break;
			case "0":
				System.out.println("Computer Science, Information and General Works");
				try {
					list = bdao.getBooksByCategory("000");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "1":
				System.out.println("Philosophy and Psychology");
				try {
					list = bdao.getBooksByCategory("100");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "2":
				System.out.println("Religion");
				try {
					list = bdao.getBooksByCategory("200");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "3":
				System.out.println("Social Sciences");
				try {
					list = bdao.getBooksByCategory("300");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "4":
				System.out.println("Language");
				try {
					list = bdao.getBooksByCategory("400");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "5":
				System.out.println("Pure Science");
				try {
					list = bdao.getBooksByCategory("500");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "6":
				System.out.println("Technology");
				try {
					list = bdao.getBooksByCategory("600");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "7":
				System.out.println("Arts and Recreation");
				try {
					list = bdao.getBooksByCategory("700");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "8":
				System.out.println("Literature");
				try {
					list = bdao.getBooksByCategory("800");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "9":
				System.out.println("History and Geography");
				try {
					list = bdao.getBooksByCategory("900");
					categoryMenu(user, list, scan);
				} catch (SQLException e) {
					System.out.println("SQLDatabase Error");
				}
				break;
			case "10":
				System.out.println("Exit");
				return;
			}
		}
	}

	public void cartMenu(User user, Scanner scan) {
		String input;
		while(true) {
			if (user.cart.isEmpty()) {
				System.out.println("There are not items in your shopping cart");
				return;
			}
			for (Book book : user.cart) {
				System.out.printf("\"%s\" by %s $%.2f\n",
						book.getTitle(),
						book.getAuthor(),
						book.getPrice());
			}
			System.out.println("You may:\n"
				+ "1) Place Your Order\n"
				+ "2) Cancel Your Order\n"
				+ "3) Continue Shopping");
			System.out.print("What would you like to do? ");
			input = scan.nextLine();
			switch(input) {
			default:
				System.out.println("Invalid Input");
				break;
			case "1":
				System.out.println("Order Confirmed");
				for (Book book : user.cart) {
					try {
						if (book.getCount() == 0)
							bdao.removeBook(book);
						else
							bdao.updateBook(book);
					} catch (SQLException e) {
						System.out.println("SQLDatabase Error");
					}
				}
				user.cart.clear();
				return;
			case "2":
				System.out.println("Order Cancelled");
				user.cart.clear();
				return;
			case "3":
				System.out.println("Continue Shopping");
				return;
			}
		}
	}

	public void categoryMenu(User user, List<Book> list, Scanner scan) {
		String input;
		while(true) {
			if (list.isEmpty()) {
				System.out.println("There are not books available in this category");
				return;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCount() == 0)
					continue;
				System.out.printf("%d) \"%s\" by %s #%013d\n", i,
					list.get(i).getTitle(),
					list.get(i).getAuthor(),
					list.get(i).getISBN());
			}
			System.out.print("Select a book for a description or type 'exit' to leave menu: ");
			input = scan.nextLine();
			try {
				if (input.equalsIgnoreCase("exit")) {
					System.out.println("Exit");
					return;
				} else {
					int index = Integer.parseInt(input);
					Book book = list.get(index);
					if (book.getCount() == 0)
						throw new IndexOutOfBoundsException();
					descriptionMenu(user, book, scan);
				}
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.out.println("Invalid Input");
			}
		}
	}

	public int descriptionMenu(User user, Book book, Scanner scan) {
		String input;
		while(true) {
			System.out.printf("Title: %s\n"
					+ "Author: %s\n"
					+ "Price: $%.2f\n"
					+ "Category: %s\n"
					+ "Description: %s\n"
					+ "Count: %d\n",
					book.getTitle(), book.getAuthor(), book.getPrice(),
					book.getCategory(), book.getDescription(), book.getCount());
				System.out.println("You may:\n"
					+ "1) Buy\n"
					+ "2) Cancel");
			System.out.print("What would you like to do? ");
			input = scan.nextLine();
			switch(input) {
			default:
				System.out.println("Invalid Input");
				break;
			case "1":
				if (book.getCount() == 0) {
					System.out.println("Sold Out");
				} else {
					book.setCount(book.getCount() - 1);
					System.out.println("Buy");
					user.cart.add(book);
				}
				return 1;
			case "2":
				System.out.println("Cancel");
				return 0;
			}
		}
	}

}
