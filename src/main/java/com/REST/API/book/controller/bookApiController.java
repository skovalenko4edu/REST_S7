package com.REST.API.book.controller;

import com.REST.API.base.exeption.ResourceNotFound;
import org.springframework.web.bind.annotation.*;
import com.REST.API.book.service.bookService;
import com.REST.API.book.entity.bookEntity;

import java.util.List;

@RestController
public class bookApiController {
    private final bookService bookService;

    public bookApiController(com.REST.API.book.service.bookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/REST/")
    public String ok() {
        return "ok";
    }

    @GetMapping("/api/REST/v1/books")
    public List<bookEntity> all(){
        return bookService.all();
    }

    @GetMapping("/api/REST/v1/books/{id}")
    public bookEntity byId(@PathVariable Integer id) {
        return bookService.byId(id).orElseThrow(ResourceNotFound::new);
    }

    @PostMapping("/api/REST/v1/books")
    public bookEntity create(@RequestBody bookEntity request){
        return bookService.create(request.getTitle(), request.getDescriptions());

    }
}
