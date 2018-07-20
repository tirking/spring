package com.spring4.cache;

public class Book {

	private String ID;
	private String name;

	public Book(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book(ID=" + ID + ",name=" + name + ");";
	}

}
