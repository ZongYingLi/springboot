package  com.test1.ch07.trans.service;


import javax.annotation.Resource;
import  com.test1.ch07.trans.dao.IBookShopDao;
import  com.test1.ch07.trans.exception.AccountException;
import  com.test1.ch07.trans.exception.BookStockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

@Service("bookShopService")
public class BookShopServiceImpl implements IBookShopService {
    @Resource
    private IBookShopDao bookShopDao;


    //通过账户名及书号购买书
    //支持注解式事务管理
    @Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED,
            rollbackFor={IOException.class, SQLException.class},
            noRollbackFor={ArithmeticException.class},
            readOnly=false,
            timeout=3)
    @Override
    public void purchase(String username, int bookId) throws BookStockException, AccountException {
        int price = bookShopDao.selectPrice(bookId);
        //一旦添加了事务管理，当前两项操作要么都做，要么都不做
        //买书后，更新库存
        bookShopDao.updateStock(bookId);
        //根据提供会员信息，修改余额
        bookShopDao.updateBalance(username, price);
    }

}
