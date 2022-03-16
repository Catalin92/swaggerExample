package com.example.swagger.controllers;

import com.example.swagger.models.Author;
import com.example.swagger.models.Book;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @ApiOperation(value="Get all books", nickname="list_books")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Books Information Retrieved"),
            @ApiResponse(code = 403, message = "Forbidden access"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Book> getBooks(){
        Author author = Author.builder().firstName("Alin").lastName("Popescu").age(20).build();
        return List.of(
                Book.builder().title("Alba ca zapada").releaseDate(LocalDate.now()).author(author).build(),
                Book.builder().title("Scufita Rosie").releaseDate(LocalDate.now()).author(author).build()
        );
    }

    @ApiOperation(value="Create new book", nickname="create book")
    @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book was created"),
            @ApiResponse(code = 403, message = "Forbidden access"),
            @ApiResponse(code = 409, message = "Book already exists"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createBook(@RequestBody Book book){
        //save Book
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
