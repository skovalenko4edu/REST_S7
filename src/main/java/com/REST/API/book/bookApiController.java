package com.REST.API.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class bookApiController {

    @GetMapping("/api/REST/")
    public String ok() {
        return "ok";
    }
}
