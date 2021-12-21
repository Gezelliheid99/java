package com.pjj.book.test;

import com.pjj.book.pojo.Book;
import com.pjj.book.service.BookService;
import com.pjj.book.service.impl.BookServiceImpl;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"springboot实战","pjj",new BigDecimal(88),1000,500,null));
    }

    @Test
    public void deleteBookByID() {
        bookService.deleteBookByID(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"springboot实战","pjj",new BigDecimal(88),20000,500,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1,10));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1,4,10,50));
    }


}