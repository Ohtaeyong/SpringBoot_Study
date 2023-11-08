package org.koreait.controllers;

import lombok.RequiredArgsConstructor;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//스프링 4버전은 restController가 없어서 json통신을 하려면 @ResponsBody를 써야함.
@Controller
@RequiredArgsConstructor
public class HelloController {

    private final MemberRepository repository;

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @GetMapping("/info/{userId}")
    @ResponseBody
    public Member info(@PathVariable String userId) {
        Member member = repository.findByUserId(userId);

        return member;
    }
}
