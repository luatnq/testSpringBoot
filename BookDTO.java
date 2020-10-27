package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {
    @JsonProperty("book_name")
    private String bookName;
    @JsonProperty("author")
    private String author;
    @JsonProperty("publish_year")
    private int publishYear;

}
