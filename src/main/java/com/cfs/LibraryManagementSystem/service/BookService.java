package com.cfs.LibraryManagementSystem.service;

import com.cfs.LibraryManagementSystem.entity.Book;
import com.cfs.LibraryManagementSystem.repositry.BookRepositry;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepositry bookRepositry;

    public BookService(BookRepositry bookRepositry) {
        this.bookRepositry = bookRepositry;
    }

    public Book addBook(Book book){

        return bookRepositry.save(book);
    }

    public List<Book> ListOfAllBook(){
        return bookRepositry.findAll();
    }

    public Optional<Book> findByBookId(Long id){
        return bookRepositry.findById(id);
    }

    public List<Book> findName(String name){
        return bookRepositry.findByTitle(name);
    }


    public Long numberOfBook(Long id){
        return bookRepositry.getNumber_Of_Books(id);
    }

    @Transactional
    public void deleteByBook_id(Long id){
        bookRepositry.deleteById(id);
    }

    @Transactional
    public void delete(){
        bookRepositry.deleteAll();
    }

    @Transactional
    public void deleteByTitle(String title){
        bookRepositry.deleteByTitle(title);
    }


    public List<Book> findByAuthor_name(String name) {
        return bookRepositry.findByAuthor_name(name);
    }

    public void deleteByAuthor_name(String author_name){
        bookRepositry.deleteByAuthor_name(author_name);
    }


    @Transactional
    public void updatenumberOfBook(Long id) {
        bookRepositry.updateNumberOfBook(id);
    }

    @Transactional
    public void addBookNumber(Long id){
        bookRepositry.addBookNumber(id);
    }

    @Transactional
    public void updatenumberOfBook(String title) {
        bookRepositry.updateNumberOfBook(title);
    }

    @Transactional
    public void addBookNumber(String title){
        bookRepositry.addBookNumber(title);
    }
}
