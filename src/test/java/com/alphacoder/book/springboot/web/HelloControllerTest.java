package com.alphacoder.book.springboot.web;

import com.alphacoder.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
/*
    테스트 진행시 JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킵니다.
    여기서는 SpringRunner라는 스프링 실행자를 사용합니다.
    즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
 */

@WebMvcTest(controllers = HelloController.class)
/*
    스프링 테스트 어노테이션중 @WebMvcTest 어노테이션은 Web에 집중할 수 있는 어노테이션입니다.
    해당 어노테이션을 사용시 @Controller, @ControllerAdvice 등을 사용 할 수 있습니다.
    단, @Service, @Component, @Repository 등은 사용 할 수 없습니다.
 */
public class HelloControllerTest {


    @Autowired
    // 스프링이 관리하는 빈을 주입 받습니다.
    private MockMvc mvc;
    /*
        Web API를 테스트할때 사용합니다.
        스프링 MVC 테스트의 시작점이며, 해당 클래스를 통해 HTTP GET, POST 등에 대한 API를 테스트 합니다.
     */

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())// mvc.perform() 의 결과를 검증 HTTP 상태값을 나타낸다.
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검증
    }
}
