package com.testproject.bookApi.dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private String title;
    private String author;
    private String description;
    private Double price;

}
