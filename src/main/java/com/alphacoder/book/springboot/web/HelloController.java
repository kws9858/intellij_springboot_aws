package com.alphacoder.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//  @RestController - JSON을 반환하는 컨트롤러로 만들어줍니다.
//  Spring Regacy에서 사용하던 @ResponsBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해주는 Annotation 입니다.
@RestController
public class HelloController {

    //  HTTP Method GET의 요청을 받을 수 있는 API를 만들어 줍니다.
    //  Spring Regacy의 @RequstMapping(method = RequestMethod.GET)과 동일합니다.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
