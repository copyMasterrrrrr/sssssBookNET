package com.lin.controller;

import com.lin.common.VO.ResultVO;
import com.lin.entity.Books;
import com.lin.service.BooksService;
import io.swagger.annotations.*;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/book")
@Api(value = "提供books相关操作的接口",tags = "书籍管理")
public class BookController {
    @Resource
    private BooksService booksService;


    //查找所有书

    @GetMapping("/bookslist")
    @ApiOperation("书籍列表接口")
    @ApiImplicitParam(dataType = "String" ,name = "token" ,value = "token令牌")
    public ResultVO selectAllBooks(@RequestHeader("token")String token){
        return booksService.selectAllBooks();
    }


    @GetMapping("/getbook")
    @ApiOperation("根据书籍id查找书籍接口")
    @ApiImplicitParam(dataType = "int" ,name="bookId",value = "书籍id",required = true)
    //根据id查找一本书
    public ResultVO selectBookById(@RequestParam("bookId") int bookId){
        return booksService.selectBookById(bookId);
    }

    //增加一本书
    @PostMapping("/addbook")
    @ApiOperation("添加书籍接口")
    public ResultVO addBook(String bookName,String bookContent,String bookAuthor) {
        return booksService.addBook(bookName,bookContent,bookAuthor);
    }

    //删除一本书
    @GetMapping("/dltbook")
    @ApiOperation("根据书籍id删除书籍接口")
    @ApiImplicitParam(dataType = "int" ,name="bookId",value = "书籍id",required = true)
    public ResultVO deleteBook(int bookId) {
        return booksService.deleteBook(bookId);
    }

    //修改一本书
    @PostMapping("/updbook")
    @ApiOperation("根据书籍id更新书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int" ,name="bookId",value = "书籍id",required = true),
            @ApiImplicitParam(dataType = "String" ,name="bookName",value = "书籍名称",required = true),
            @ApiImplicitParam(dataType = "String" ,name="bookAuthor",value = "书籍作者",required = true),
            @ApiImplicitParam(dataType = "String" ,name="bookContent",value = "书籍内容",required = true)
    })
    public ResultVO updateBook(int bookId, String bookName, String bookAuthor, String bookContent) {
        return booksService.updateBook(bookId,bookName,bookAuthor,bookContent);
    }



}
