package com.dongjun.springboothelloword.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class HelloWorldController
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@RestController
public class HelloWorldController {

    /**
     * Method HelloWorld
     *
     * @return String
     */
    @GetMapping(value = "/")
    public String HelloWorld() {
        return "Hello World!";
    }
}
