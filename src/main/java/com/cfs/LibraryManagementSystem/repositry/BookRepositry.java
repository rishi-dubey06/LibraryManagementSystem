package com.cfs.LibraryManagementSystem.repositry;

import com.cfs.LibraryManagementSystem.entity.Book;
import com.cfs.LibraryManagementSystem.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepositry extends JpaRepository<Book,Long> {


    void deleteByTitle(String title);

    List<Book> findByTitle(String name);


    @Modifying
    @Transactional
    @Query(value = "delete from book where author_name=?",nativeQuery = true)
    void deleteByAuthor_name(String authorName);


    @Query(value = "SELECT * FROM book WHERE author_name = ?", nativeQuery = true)
    List<Book> findByAuthor_name(String name);

    @Query(value = "select number_of_books from book where book_id=?",nativeQuery = true)
    Long getNumber_Of_Books(Long id);

    @Modifying
    @Query(value = "update book set number_of_books=number_of_books-1 where book_id=?",nativeQuery = true)
    void updateNumberOfBook(Long id);

    @Modifying
    @Query(value = "update book set number_of_books=number_of_books+1 where book_id=?",nativeQuery = true)
    void addBookNumber(Long id);

    boolean getNumberOfBooksByTitle(String bookName);

    @Modifying
    @Query(value = "update book set number_of_books=number_of_books-1 where title=?",nativeQuery = true)
    void updateNumberOfBook(String title);

    @Modifying
    @Query(value = "update book set number_of_books=number_of_books+1 where title=?",nativeQuery = true)
    void addBookNumber(String title);

    @Query(value="select author_name from book where book_id=?",nativeQuery = true)
    String findAuthor_name(Long bookId);




}
