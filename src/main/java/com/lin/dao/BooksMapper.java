package com.lin.dao;

import com.lin.common.general.GeneralDAO;
import com.lin.entity.Books;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BooksMapper extends GeneralDAO<Books> {
    //查找所有书
    List<Books> selectAllBooks();
    //根据id查找一本书
    Books selectBookById(int BookId);
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBook(int bookId);
    //修改一本书
    int updateBook(Books books);
}