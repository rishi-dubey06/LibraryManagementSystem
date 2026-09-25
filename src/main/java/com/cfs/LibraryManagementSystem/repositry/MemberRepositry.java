package com.cfs.LibraryManagementSystem.repositry;

import com.cfs.LibraryManagementSystem.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepositry extends JpaRepository<Member,Long> {


    List<Member> findByName(String name);

    List<Member> findByCourse(String course);



    void deleteByName(String name);


    void deleteByCourse(String course);

    List<Member> findByEmail(String email);


    void deleteByEmail(String email);
}
