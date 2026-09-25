package com.cfs.LibraryManagementSystem.service;

import com.cfs.LibraryManagementSystem.entity.Book;
import com.cfs.LibraryManagementSystem.entity.Issue;
import com.cfs.LibraryManagementSystem.entity.Member;
import com.cfs.LibraryManagementSystem.exceptionhandling.CustomHandling;
import com.cfs.LibraryManagementSystem.repositry.BookRepositry;
import com.cfs.LibraryManagementSystem.repositry.IssueRepositry;
import com.cfs.LibraryManagementSystem.repositry.MemberRepositry;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class IssueService {

    private IssueRepositry issueRepositry;
    private MemberRepositry memberRepositry;
    private BookRepositry bookRepositry;



    public IssueService(IssueRepositry issueRepositry, MemberRepositry memberRepositry, BookRepositry bookRepositry) {
        this.issueRepositry = issueRepositry;
        this.memberRepositry = memberRepositry;
        this.bookRepositry = bookRepositry;

    }
    Issue issue=new Issue();


    @Transactional
    public void bookReturnedById(Long bookId,Long memberId) {

        if (issueRepositry.findByMemberId(memberId).isEmpty()) {
            throw new CustomHandling("Member not found");

        } else if (issueRepositry.findByBookId(bookId).isEmpty()) {

            throw new CustomHandling("Book not found");
        } else {
                issueRepositry.deleteById(bookId);
                bookRepositry.addBookNumber(bookId);
                System.out.println("book has been returned");
            }
        }






    @Transactional
    public void bookIssusedById(Long bookId,Long memberId) {

        if (memberRepositry.findById(memberId).isEmpty()) {
            throw new CustomHandling("Member not found");

        } else if (bookRepositry.findById(bookId).isEmpty()) {

            throw new CustomHandling("Book not found");
        } else {


            if (issueRepositry.existsById(bookId)) {
                throw new CustomHandling("Member Id " + memberId + " has already issued this book id " + bookId);
            } else {
                issue.setBook_id(bookId);
                issue.setMember_id(memberId);
                issue.setAuthor_name(bookRepositry.findAuthor_name(bookId));
                issue.setIssue_date(LocalDate.now());
                issueRepositry.save(issue);

                bookRepositry.updateNumberOfBook(bookId);


                System.out.println("book has been issued");
            }
        }
    }

    public List<Issue> findAll() {

        return issueRepositry.findAll();
    }
}
