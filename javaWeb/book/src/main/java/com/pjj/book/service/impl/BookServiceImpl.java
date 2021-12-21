package com.pjj.book.service.impl;

import com.pjj.book.dao.BookDao;
import com.pjj.book.dao.impl.BookDaoImpl;
import com.pjj.book.pojo.Book;
import com.pjj.book.pojo.Page;
import com.pjj.book.service.BookService;
import com.pjj.book.utils.WebUtils;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年08月09日 12:12
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookByID(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNum, int pageSize) {
        Page<Book> page = new Page<>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录条数
        Integer pageCountTotal = bookDao.queryForPageTotalCount();
        page.setPageCountTotal(pageCountTotal);
        //求总页码 向上取整
        Integer pageNumTotal = pageCountTotal/pageSize;
        if (pageCountTotal % pageSize > 0 ){
            pageNumTotal+=1;
        }
        page.setPageNumTotal(pageNumTotal);

        //设置当前页码
        if (pageNum < 1){
            pageNum = 1;
        }
        if (pageNum > pageNumTotal){
            pageNum = pageNumTotal;
        }
        page.setPageNum(pageNum);
        //当前页数据
        int begin = (pageNum-1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNum, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录条数
        Integer pageCountTotal = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageCountTotal(pageCountTotal);
        //求总页码 向上取整
        Integer pageNumTotal = pageCountTotal/pageSize;
        if (pageCountTotal % pageSize > 0 ){
            pageNumTotal+=1;
        }
        page.setPageNumTotal(pageNumTotal);

        //设置当前页码
        if (pageNum < 1){
            pageNum = 1;
        }
        if (pageNum > pageNumTotal){
            pageNum = pageNumTotal;
        }
        page.setPageNum(pageNum);
        //当前页数据
        int begin = (pageNum-1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;


    }
}
