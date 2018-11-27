package com.wang.mvc.demo.services;

import com.wang.mvc.demo.respositories.BookRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;
import com.wang.mvc.demo.models.Book;

import java.security.Key;
import java.util.*;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ArrayList<HashMap<String, String>> allBooks() {
        List<Book> bookList = bookRepository.findAll();
        ArrayList<HashMap<String , String>> myMap  = new ArrayList<HashMap<String,String>>();
        for(int i=1; i<bookList.size()+1; i++) {
            Book book = findBook(Long.valueOf(i));
            if (book != null) {
                HashMap bookMap = book.showBook();
                myMap.add(bookMap);
            }
            else {
                continue;
            }
        }
        return myMap;
    }

    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public HashMap showBook(Long id) {
        Book book = findBook(id);
        HashMap bookMap = book.showBook();
        return bookMap;
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Book book = findBook(id);
        book.update(title,desc,lang,numOfPages);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}