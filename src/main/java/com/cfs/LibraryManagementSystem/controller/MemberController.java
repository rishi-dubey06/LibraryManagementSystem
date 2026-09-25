package com.cfs.LibraryManagementSystem.controller;

import com.cfs.LibraryManagementSystem.entity.Member;
import com.cfs.LibraryManagementSystem.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
public class MemberController {


    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public void save(@RequestBody Member member){
        memberService.save(member);
    }

    @GetMapping("/findAll")
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Member> findById(@RequestParam Long id){
        return memberService.findById(id);
    }

    @GetMapping("/findByName")
    public List<Member> findByName(@RequestParam String name){
        return memberService.findByName(name);
    }

    @GetMapping("/findByEmail")
    public  List<Member> findByEmail(@RequestParam String email){
        return memberService.findByEmail(email);
    }

    @GetMapping("/findByCourse")
    public List<Member> findByCourse(@RequestParam String course){
        return memberService.findByCourse(course);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
       memberService.deleteAll();
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id){
      memberService.deleteById(id);
    }

    @DeleteMapping("/deleteByName")
    public void deleteByName(@RequestParam String name){
         memberService.deleteByName(name);
    }

    @DeleteMapping("/deleteByEmail")
    public  void deleteByEmail(@RequestParam String email){
        memberService.deleteByEmail(email);
    }

    @DeleteMapping("/deleteByCourse")
    public void deleteByCourse(@RequestParam String course){
         memberService.deleteByCourse(course);
    }



}
