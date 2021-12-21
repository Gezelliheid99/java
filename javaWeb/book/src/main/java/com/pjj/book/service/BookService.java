package com.pjj.book.service;

import com.pjj.book.pojo.Book;
import com.pjj.book.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBookByID(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNum, int pageSize);

    Page<Book> pageByPrice(int pageNum, int pageSize, int min, int max);
}
