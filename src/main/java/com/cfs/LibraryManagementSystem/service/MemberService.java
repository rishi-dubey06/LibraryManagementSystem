package com.cfs.LibraryManagementSystem.service;

import com.cfs.LibraryManagementSystem.entity.Member;
import com.cfs.LibraryManagementSystem.repositry.MemberRepositry;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    private MemberRepositry memberRepositry;

    public MemberService(MemberRepositry memberRepositry) {
        this.memberRepositry = memberRepositry;
    }

    public List<Member> findAll(){
        return memberRepositry.findAll();
    }

    public Optional<Member> findById(Long id){
        return memberRepositry.findById(id);
    }
    public List<Member> findByName(String name){
        return memberRepositry.findByName(name);
    }

    public List<Member> findByCourse(String course){
        return memberRepositry.findByCourse(course);
    }

    public List<Member> findByEmail(String email){
        return memberRepositry.findByEmail(email);
    }


    public void deleteById(Long id){
        memberRepositry.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name){
        memberRepositry.deleteByName(name);
    }

    @Transactional
    public void deleteByCourse(String course){
        memberRepositry.deleteByCourse(course);
    }

    @Transactional
    public void deleteByEmail(String email){
        memberRepositry.deleteByEmail(email);
    }


    public void deleteAll(){
        memberRepositry.deleteAll();
    }

    public void save(Member member){
        memberRepositry.save(member);
    }

}
