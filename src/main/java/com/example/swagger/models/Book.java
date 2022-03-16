package com.example.swagger.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Book {
  private String title;
  private Author author;
  private LocalDate releaseDate;
}
