package com.example.springmodels.controllers;

import com.example.springmodels.models.Book;
import com.example.springmodels.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;



@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN','MANAGER')")
public class userController {
@Autowired
private BookRepository bookRepository;

    @GetMapping("book")
    public String bookMain(Model model)
    {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-main";
    }
}
