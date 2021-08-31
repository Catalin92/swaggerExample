package com.example.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("/swagger")
public class TestController {

  @ApiOperation(value="Getting all the books in DB", nickname="GET_GetAllBooks")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  })
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Books Information Retrieved"),
      @ApiResponse(code = 403, message = "Forbidden access"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @GetMapping(value = "/getList", produces = APPLICATION_JSON_VALUE)
  public Book getBooks(){
    return new Book();
  }

  @ApiOperation(value="Create a new book", nickname="POST_CreateBook")
  @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Book was created"),
      @ApiResponse(code = 403, message = "Forbidden access"),
      @ApiResponse(code = 409, message = "Book already exists"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @PostMapping(value ="/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  public String postBook(@RequestBody Book book){
    //save book
    return "Created";
  }


  @ApiOperation(value="Delete a book", nickname="DELETE_RemoveBook")
  @ApiImplicitParam(name = "organizationHeader", dataType = "string", paramType = "query",value = "Indicates the organization")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Book was removed"),
      @ApiResponse(code = 403, message = "Forbidden access"),
      @ApiResponse(code = 404, message = "Book not found"),
      @ApiResponse(code = 500, message = "Internal Server Error")
  })
  @DeleteMapping("/delete/{id}")
  public String deleteBook(@ApiParam(name = "bookID", type="string", format="UUID") @PathVariable("id") String id){
    return "DELETE_LIST";
  }

}
