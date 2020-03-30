package cn.lightina.managebooks.service;

import cn.lightina.managebooks.dao.BookMapper;
import cn.lightina.managebooks.enumeration.ExceptionEnum;
import cn.lightina.managebooks.exception.ServiceException;
import cn.lightina.managebooks.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired(required = false)
    BookMapper bookMapper;

    // user查询图书
    @Override
    public List<BookList> getList() {
        return bookMapper.getList();
    }

    @Override
    public List<BookList> getListByQuery(String query) {
        return bookMapper.getListByQuery(query);
    }

    /*
    * 未调用BookService中的getlistuByuId
    * */
    @Override
    public List<Book> getListByuId(int userId) {
        return null;
    }

    @Override
    public void processRes(String ISBN, User user) {
        int count = bookMapper.processRes(ISBN, user);
        if (count == 0) throw new ServiceException(ExceptionEnum.RESERVATION_FAILURE);
    }

    //admin添加图书到数据库中
    @Override
    public void addBookList(BookList bookList,int state) {
        bookMapper.addBookList(bookList,"图书流通室",state);
    }

    @Override
    public void insertBorrow(int reservationId,int operator) {
        bookMapper.insertBorrow(reservationId,operator);
    }

    @Override
    public List<ReservationDetail> getResById(User user) {
        return bookMapper.getResById(user);
    }

    @Override
    public int deleteBookList(BookList bookList) {
        return bookMapper.deleteBookListById(bookList.getIsbn());
    }

    @Override
    public List<Reservation> getResInfo() {
        return null;
    }

    @Override
    public List<BorrowDetail> getBorInfo(User user) {
        return bookMapper.getBorById(user);
    }

    @Override
    public List<ReservationDetail> getResList() {
        return bookMapper.getResList();
    }

    @Override
    public void returnBookById(int borrowId) {
        bookMapper.returnBookById(borrowId);
    }

    @Override
    public List<BorrowDetail> getBorList() {
        return bookMapper.getBorList();
    }
}
