package com.cfs.LibraryManagementSystem.controller;

import com.cfs.LibraryManagementSystem.entity.Book;
import com.cfs.LibraryManagementSystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
@CrossOrigin(origins = "*")
public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //correct working
    @PostMapping("save")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    //correct working
    @GetMapping("findAll")
    public List<Book> findall(){
        return bookService.ListOfAllBook();
    }

    //correct working
    @GetMapping("findById")
    public Optional<Book> findByID(@RequestParam Long id){
        return bookService.findByBookId(id);
    }


    //correct working
    @GetMapping("findByTitle")
    public List<Book> findByName(@RequestParam String name){
        return bookService.findName(name);
    }


    //correct working
    @GetMapping("findByAuthor")
    public List<Book> findByAuthorname(@RequestParam String name){
        return bookService.findByAuthor_name(name);
    }

    //correct working
    @DeleteMapping("deleteById")
    public void deleteById(@RequestParam  Long id){
       bookService.deleteByBook_id(id);
    }


    //correct working
    @DeleteMapping("deleteAll")
    public void delete(){
        bookService.delete();
    }

    //correct working
    @DeleteMapping("deleteByTitle")
    public void deleteByTitle(@RequestParam  String title){
        bookService.deleteByTitle(title);
    }

    //correct working
    @DeleteMapping("deleteByAuthor")
    public void deleteByAuthor_name(@RequestParam  String author_name){
        bookService.deleteByAuthor_name(author_name);
    }

    @GetMapping("countBook")
    public Long countBook(@RequestParam Long id){
        return bookService.numberOfBook(id);
    }

    @PutMapping("update/byId")
    public void updateNumberOfBook(@RequestParam  Long id){
        bookService.updatenumberOfBook(id);
    }

    @PutMapping("add/number/of/book")
    public void addNumberOfBook(@RequestParam  Long id){
        bookService.addBookNumber(id);
    }

    @PutMapping("update/byName")
    public void updateNumberOfBook(@RequestParam  String title){
        bookService.updatenumberOfBook(title);
    }


    @PutMapping("add/number/of/book/title")
    public void addNumberOfBook(@RequestParam  String title){
        bookService.addBookNumber(title);
    }

}
