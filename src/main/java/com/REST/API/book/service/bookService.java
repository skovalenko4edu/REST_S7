package com.REST.API.book.service;

import com.REST.API.book.entity.bookEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class bookService {
    static List<bookEntity> bookStorage = new ArrayList<>();

    public bookService() {
        fillStorage();
    }

    public void fillStorage() {
        Random random = new Random();
        for(int i=0; i<100; i++){
            bookEntity book = new bookEntity();
            book.setId(i);
            book.setTitle("Book №" + random.nextInt(100, 999));
            book.setDescriptions("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            bookStorage.add(book);


        }
    }
    public List<bookEntity> all(){
        return bookStorage;
    }
    public Optional<bookEntity> byId(Integer id){
        return bookStorage.stream().filter((book -> book.getId().equals(id))).findFirst();

    }
    public bookEntity create(String title, String description){
        bookEntity book = new bookEntity();
        book.setId(bookStorage.size());
        book.setTitle(title);
        book.setDescriptions(description);
        bookStorage.add(book);
        return book;
    }
    public Optional<bookEntity> edit(bookEntity book){
        bookEntity oldBookEntity = byId(book.getId()).orElseThrow();
        oldBookEntity.setTitle(book.getTitle());
        oldBookEntity.setDescriptions(book.getDescriptions());
        return Optional.of(oldBookEntity);

    }
}
