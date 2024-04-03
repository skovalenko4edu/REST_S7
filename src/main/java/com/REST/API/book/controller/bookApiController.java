package com.REST.API.book.controller;

import com.REST.API.base.exeption.ResourceNotFound;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.REST.API.book.service.bookService;
import com.REST.API.book.entity.bookEntity;

import java.util.List;
@OpenAPIDefinition(
        info = @Info(
                title = "Пример API для обучения",
                description = "Система обмена книгами", version = "1.0.0",
                contact = @Contact(
                        name = "Сергей Коваленко",
                        email = "sk0valenko4job@mail.ru",
                        url = "https://net.net"
                )
        )
)
@RestController
public class bookApiController {
    private final bookService bookService;

    public bookApiController(com.REST.API.book.service.bookService bookService) {
        this.bookService = bookService;
    }
    @Tag(name = "Проверка", description = "Позволяет убедиться, что можно работать")
    @Operation (summary = "Проверка сервера", description = "Вызвать метод и убедиться, что сервер работает")
    @ApiResponses(
            value = {
                    @ApiResponse( responseCode = "200", description = "Ура я жив!"),
                    @ApiResponse( responseCode = "500", description = "Поздравляю! Ты сломал сервер!", content = @Content)
            }
    )
    @GetMapping("/api/REST/")
    public String ok() {
        return "Hello! I am a book sharing resource. And I work.";
    }
    @Tag(name = "Книги", description = "Позволяет работать с книгами")
    @Operation (summary = "Запрос всей библиотеки", description = "Дает посмотреть все книги")
    @ApiResponses(
            value = {
                    @ApiResponse( responseCode = "200", description = "Книги найдены"),
                    @ApiResponse( responseCode = "400", description = "Все разобрали, приходите в другой день.", content = @Content),
                    @ApiResponse( responseCode = "500", description = "Санитарный день. Библиотека не доступна.", content = @Content)
            }
    )
    @GetMapping("/api/REST/v1/books")
    public List<bookEntity> all(){
        return bookService.all();
    }
    @Tag(name = "Книги", description = "Позволяет работать с книгами")
    @GetMapping("/api/REST/v1/books/{id}")
    public bookEntity byId(@PathVariable Integer id) {
        return bookService.byId(id).orElseThrow(ResourceNotFound::new);
    }
    @Tag(name = "Книги", description = "Позволяет работать с книгами")
    @PostMapping("/api/REST/v1/books")
    public bookEntity create(@RequestBody bookEntity request){
        return bookService.create(request.getTitle(), request.getDescriptions());

    }
    @Tag(name = "Книги", description = "Позволяет работать с книгами")
    @PutMapping("/api/REST/v1/books/{id}")
   public bookEntity edit(@PathVariable Integer id, @RequestBody bookEntity request){
       return bookService.edit(request).orElseThrow(ResourceNotFound::new);

   }
    @Tag(name = "Книги", description = "Позволяет работать с книгами")
    @DeleteMapping("/api/REST/v1/books/{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return  bookService.delete(id);
   }
}
