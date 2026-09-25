package com.cfs.LibraryManagementSystem.repositry;

import com.cfs.LibraryManagementSystem.entity.Issue;
import com.cfs.LibraryManagementSystem.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface IssueRepositry extends JpaRepository<Issue,Long> {


    @Query(value="select * from issues where member_id=?",nativeQuery = true)
    List<Issue> findByMemberId(Long member_id);

    @Query(value="select * from issues where book_id=?",nativeQuery = true)
    List<Issue> findByBookId(Long book_id);

}
