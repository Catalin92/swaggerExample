package com.example.swagger.controllers;

import com.example.swagger.models.Author;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

  @ApiOperation(value="Getting all the authors", nickname="list_authors")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  })
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Author Information Retrieved"),
      @ApiResponse(code = 403, message = "Forbidden access"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public List<Author> getAuthors(){
    return List.of(
            Author.builder().firstName("Alin").lastName("Popescu").age(20).build(),
            Author.builder().firstName("Valentin").lastName("Andrei").age(33).build(),
            Author.builder().firstName("Ioana").lastName("Mircea").age(23).build()
    );
  }

  @ApiOperation(value="Get author by id", nickname="read_author")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  })
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Author Information Retrieved"),
          @ApiResponse(code = 403, message = "Forbidden access"),
          @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
  public List<Author> getAuthorById(@PathVariable("id") String id){
    return List.of(
            Author.builder().firstName("Alin").lastName("Popescu").age(20).build(),
            Author.builder().firstName("Valentin").lastName("Andrei").age(33).build(),
            Author.builder().firstName("Ioana").lastName("Mircea").age(23).build()
    );
  }

  @ApiOperation(value="Create a new author", nickname="create author")
  @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Author was created"),
      @ApiResponse(code = 403, message = "Forbidden access"),
      @ApiResponse(code = 409, message = "Author already exists"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createAuthor(@RequestBody Author author){
    //save Author
    return new ResponseEntity<>(HttpStatus.CREATED);
  }


  @ApiOperation(value="Delete author", nickname="remove_author")
  @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Author was removed"),
      @ApiResponse(code = 403, message = "Forbidden access"),
      @ApiResponse(code = 404, message = "Author not found"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAuthor(@ApiParam(name = "AuthorID", type="string", format="UUID") @PathVariable("id") String id){
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
