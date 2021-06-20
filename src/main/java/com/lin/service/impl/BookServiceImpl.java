package com.lin.service.impl;

import com.lin.common.VO.ResultVO;
import com.lin.dao.BooksMapper;
import com.lin.entity.Books;
import com.lin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BookServiceImpl implements BooksService {
    @Autowired
    BooksMapper booksMapper;

    @Override
    public ResultVO selectAllBooks() {
        List<Books> books=booksMapper.selectAllBooks();
        return new ResultVO(1001,"查询成功",books);
    }

    @Override
    public ResultVO selectBookById(int bookId) {
        Books books = booksMapper.selectBookById(bookId);
        return new ResultVO(1002,"查询成功",books);
    }

    @Override
    public ResultVO addBook(String bookName,String bookContent,String bookAuthor) {
        Books books = new Books();
        books.setBookName(bookName);
        books.setBookContent(bookContent);
        books.setBookAuthor(bookAuthor);
        books.setBookAddtime(new Date());
        books.setBookModtime(new Date());
        int i = booksMapper.addBook(books);
        if (i>0){
            return new ResultVO(1003,"添加成功",null);
        }else{
            return new ResultVO(1013,"添加失败",null);
        }


    }

    @Override
    public ResultVO deleteBook(int bookId) {
        int i = booksMapper.deleteBook(bookId);
        if (i>0){
            return new ResultVO(1004,"删除成功",null);
        }else{
            return new ResultVO(1014,"删除失败",null);
        }

    }

    @Override
    public ResultVO updateBook(int bookId, String bookName, String bookAuthor, String bookContent) {
        Books books = new Books();
        books.setBookId(bookId);
        books.setBookName(bookName);
        books.setBookModtime(new Date());
        books.setBookAuthor(bookAuthor);
        books.setBookContent(bookContent);
        int i = booksMapper.updateBook(books);
        if (i > 0) {
            return new ResultVO(1005, "更新成功", null);
        } else {
            return new ResultVO(1015, "更新失败", null);
        }
    }


    }

