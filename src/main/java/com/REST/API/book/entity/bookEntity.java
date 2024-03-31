package com.REST.API.book.entity;

import org.springframework.aop.IntroductionInterceptor;

public class bookEntity {
    private Integer id;
    private String title;
    private String descriptions;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public bookEntity() {
     }

    public bookEntity(Integer id, String title, String descriptions) {
        this.id = id;
        this.title = title;
        this.descriptions = descriptions;
    }
}
