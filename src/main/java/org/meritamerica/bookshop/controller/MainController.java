package org.meritamerica.bookshop.controller;


import org.meritamerica.bookshop.dao.BookDao;
import org.meritamerica.bookshop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MainController {

    @Autowired()
    private BookDao bookDao;

    @GetMapping("/")
    public String home(){
        return "Hello from home";
    }


    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookDao.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookDao.getBookById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/books")
    public Book addBook(@Valid @RequestBody Book book){
        return bookDao.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@Valid @RequestBody Book book, @PathVariable int id){
        bookDao.updateBook(book, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable int id){
        bookDao.deleteBook(id);
    }
}
