package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;

@SpringBootApplication
public class BooksCrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(BooksCrudApplication.class);

		BookService bs= context.getBean(BookServiceImpl.class);

		String name;
		float price;
		int id = 0;
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("""
					1.Insert
					2.Display
					3.Update
					4.Delete
					5.Search By Author Name
					6.EXIT
					Enter your choice:
					"""
					);
			int ch=sc.nextInt();

			switch(ch) {
			case 1->{
				System.out.println("Enter a book name:");
				name=sc.next();
				System.out.println("Author Name: ");
				String authorName=sc.next();
				System.out.println("Publication: ");
				String publication=sc.next();
				System.out.println("Price: ");
				price=sc.nextFloat();
				
				bs.add(new Book(id, name, authorName, publication, price));
			}
			case 2->{
				bs.display().forEach(System.out::println);
			}
			case 3 -> {
			    System.out.println("Enter ID of the book to update:");
			    id = sc.nextInt();
			    System.out.println("Enter new Book Name:");
			    name = sc.nextLine();
			    System.out.println("Enter new Author Name:");
			    String authorName = sc.nextLine();
			    System.out.println("Enter new Publication:");
			    String publication = sc.nextLine();
			    System.out.println("Enter new Price:");
			    price = sc.nextFloat();

			    Book book = new Book(id, name, authorName, publication, price);
			    bs.update(book, id); 
			}

			case 4->{
				System.out.println("Enter an Id: ");
				id=sc.nextInt();
				bs.delete(id);
			}
			case 5->{
				System.out.println("Enter Author Name to search the book: ");
				name=sc.next();
				bs.search(name).forEach(System.out::println);
			}
			case 6->{
				System.exit(0);
			}
			default->
			System.out.println("Invalid Choice!");

			}
		}

	}
	}


