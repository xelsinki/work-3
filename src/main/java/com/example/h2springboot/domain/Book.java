package com.example.h2springboot.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String code;
    @Column
    private int price;

    // Empty PROTECTED constructor for JPA
    public Book(){

    }

    // Full constructor
    public Book(String name, String author, String code, int price) {
        this.name = name;
        this.author = author;
        this.code = code;
        this.price = price;
    }


    // toString
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
