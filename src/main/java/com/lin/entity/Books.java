package com.lin.entity;

import java.util.Date;
import javax.persistence.*;

public class Books {
    /**
     * 主键id 用户id
     */
    @Id
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 用户名 用户名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 书籍内容 
     */
    @Column(name = "book_content")
    private String bookContent;

    /**
     * 添加时间 添加时间
     */
    @Column(name = "book_addtime")
    private Date bookAddtime;

    /**
     * 更新时间 更新时间
     */
    @Column(name = "book_modtime")
    private Date bookModtime;

    /**
     * 作者 作者
     */
    @Column(name = "book_author")
    private String bookAuthor;

    /**
     * 获取主键id 用户id
     *
     * @return book_id - 主键id 用户id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置主键id 用户id
     *
     * @param bookId 主键id 用户id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取用户名 用户名
     *
     * @return book_name - 用户名 用户名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置用户名 用户名
     *
     * @param bookName 用户名 用户名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取书籍内容 
     *
     * @return book_content - 书籍内容 
     */
    public String getBookContent() {
        return bookContent;
    }

    /**
     * 设置书籍内容 
     *
     * @param bookContent 书籍内容 
     */
    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    /**
     * 获取添加时间 添加时间
     *
     * @return book_addtime - 添加时间 添加时间
     */
    public Date getBookAddtime() {
        return bookAddtime;
    }

    /**
     * 设置添加时间 添加时间
     *
     * @param bookAddtime 添加时间 添加时间
     */
    public void setBookAddtime(Date bookAddtime) {
        this.bookAddtime = bookAddtime;
    }

    /**
     * 获取更新时间 更新时间
     *
     * @return book_modtime - 更新时间 更新时间
     */
    public Date getBookModtime() {
        return bookModtime;
    }

    /**
     * 设置更新时间 更新时间
     *
     * @param bookModtime 更新时间 更新时间
     */
    public void setBookModtime(Date bookModtime) {
        this.bookModtime = bookModtime;
    }

    /**
     * 获取作者 作者
     *
     * @return book_author - 作者 作者
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * 设置作者 作者
     *
     * @param bookAuthor 作者 作者
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}