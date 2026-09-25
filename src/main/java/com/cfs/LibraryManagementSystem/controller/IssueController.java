package com.cfs.LibraryManagementSystem.controller;

import com.cfs.LibraryManagementSystem.entity.Issue;
import com.cfs.LibraryManagementSystem.exceptionhandling.CustomHandling;
import com.cfs.LibraryManagementSystem.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("issue")
@CrossOrigin(origins = "*")
public class IssueController {



    private IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("findAll")
    public List<Issue> findAll(){
        return issueService.findAll();
    }

    @PostMapping("book/issued/by/id")

        public void bookIssued (@RequestParam Long book_id, @RequestParam Long member_id){
        try {
            issueService.bookIssusedById(book_id, member_id);
        }catch (CustomHandling e){
            System.out.println(e.getMessage());
        }
    }

   @DeleteMapping("delete/by/id")
    public void bookReturnedById(@RequestParam Long bookId, @RequestParam Long memberId){
        issueService.bookReturnedById(bookId,memberId);
   }
}
