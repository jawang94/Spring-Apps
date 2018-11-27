package com.wang.mvc.demo.controllers;

import com.wang.mvc.demo.models.Book;
import com.wang.mvc.demo.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String index(Model model) {
        ArrayList books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }

    @RequestMapping(value = "/books/new")
    public String newBook(Model model, @ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }

    @RequestMapping(value="/books", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "id") Long id) {
        HashMap book = bookService.showBook(id);
        model.addAttribute("book", book);
        return "/books/show.jsp";
    }
}
