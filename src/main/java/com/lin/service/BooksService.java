package com.lin.service;

import com.lin.common.VO.ResultVO;
import com.lin.entity.Books;

import java.util.List;

public interface BooksService {
    //查找所有书
    public ResultVO selectAllBooks();
    //根据id查找一本书
    public ResultVO selectBookById(int bookId);
    //增加一本书
    public ResultVO addBook(String bookName,String bookContent,String bookAuthor);
    //删除一本书
    public ResultVO deleteBook(int bookId);
    //修改一本书
    public ResultVO updateBook(int bookId,String bookName,String bookAuthor,String bookContent);
}
