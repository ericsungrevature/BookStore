package com.sung.user;

import java.util.ArrayList;
import java.util.List;

import com.sung.book.Book;

public class User {

	private String first_name;
	private String last_name;
	private String username;
	private String password;
	public List<Book> cart = new ArrayList<Book>();

	public String getFirstName() {return first_name;}
	public void setFirstName(String first_name) {this.first_name = first_name;}
	public String getLastName() {return last_name;}
	public void setLastName(String last_name) {this.last_name = last_name;}
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

}
