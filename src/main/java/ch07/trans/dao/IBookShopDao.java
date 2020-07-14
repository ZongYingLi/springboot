package  com.test1.ch07.trans.dao;

import  com.test1.ch07.trans.exception.AccountException;
import  com.test1.ch07.trans.exception.BookStockException;

public interface IBookShopDao {

    //根据bookId获取书的价格
    public int selectPrice(int bookId);
    //根据bookId更新库存
    public void updateStock(int bookId) throws BookStockException;
    //根据username,price更新账户余额
    public void updateBalance(String username, int price) throws AccountException;

}