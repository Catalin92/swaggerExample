package com.example.swagger;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Book {

  private String title;
  private Author author;
  private LocalDate releaseDate;


}
