package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.BooksCrudApplication;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BooksCrudApplication bookCrudApplication;

	@Autowired
	private BookRepository br;


    BookServiceImpl(BooksCrudApplication bookCrudApplication) {
        this.bookCrudApplication = bookCrudApplication;
    }
	
	
	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
		br.save(b);
	}

	@Override
	public List<Book> display() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		br.deleteById(id);
	}

	@Override
	public void update(Book b, Integer id) {
		 Optional<Book> idFound = br.findById(id);

		    if (idFound.isPresent()) {
		        b.setId(id); 
		        br.save(b);
		        System.out.println("Book updated successfully.");
		    } else {
		        System.out.println("Book not found with ID: " + id);
		    }
	}

	@Override
	public List<Book> search(String authorName) {
		// TODO Auto-generated method stub
		var bookArray= new ArrayList<Book>();
		for(Book book: br.findAll()) {
			if(book.getAuthorName().equalsIgnoreCase(authorName));
			bookArray.add(book);
		}
		return bookArray;
	}

}
