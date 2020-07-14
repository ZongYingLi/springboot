package  com.test1.ch07.trans.service;

import  com.test1.ch07.trans.exception.AccountException;
import  com.test1.ch07.trans.exception.BookStockException;

public interface IBookShopService {

    //通过账户名及书号购买书
    public void purchase(String username, int bookId) throws BookStockException, AccountException;
}
