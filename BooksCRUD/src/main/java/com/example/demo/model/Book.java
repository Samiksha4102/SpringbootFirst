package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String authorName;
	private String publication;
	private float price;
	public Book(String name2, String authorName2, String publication2, float price2) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String authorName, String publication, float price) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.publication = publication;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authorName=" + authorName + ", publication=" + publication
				+ ", price=" + price + "]";
	}
	
	
	
}
