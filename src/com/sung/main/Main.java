/**************************************************************************************
 * Name of Challenge: Book Store
 * Type: Console App
 * Technologies: Java, MySQL, JDBC
 * 
 * User Stores
 * 1. User need to register and login first
 * 2. Show Categories like (Technology, Literature, Fiction etc)
 * 3. User can select category to get the list of books belong to that category
 * 4. Display list of book (like title, author, ISBN number)
 * 5. User can choose a book to get more information (like title, author, price, category, description)
 * 6. There should to option (1-buy, 2-cancel)
 * 7. when select buy add book into cart and cancel go back to previous menu
 * 8. View cart and place the order
 **************************************************************************************/
//create table user (first_name varchar(20), last_name varchar(20), username varchar(20) unique, password varchar(20));
//create table book (title varchar(50), author varchar(50), price double, category enum('000', '100', '200', '300', '400', '500', '600', '700', '800', '900'), isbn integer unique, description varchar(1000), count integer);

package com.sung.main;

import com.sung.store.Store;

public class Main {

	public static void main(String[] args) {
		Store store = new Store();
		store.start();
	}

}
