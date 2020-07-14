packagecom.test1.ch03.prop;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException {

        //1.创建IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch03_prop.xml");
        //2.注入ComboPooledDataSource数据源实例
        ComboPooledDataSource dataSource = ac.getBean(ComboPooledDataSource.class);
        System.out.println(dataSource);
        //3.获得链接对象
        Connection connection = dataSource.getConnection();

        //设置当前数据库操作为不自动提交
        connection.setAutoCommit(false);

        //4.创建语句对象
        PreparedStatement preparedStatement = connection.prepareStatement("select name from t_dept where id=?");
        //5.给占位符?传值 第一个参数：给第几个?传值  第二个参数：传递的数值
        preparedStatement.setInt(1,2);

        //设置保存点
        connection.setSavepoint("sp");

        //6.执行，返回结果集
        ResultSet resultSet = preparedStatement.executeQuery();

        //事务回滚
        connection.rollback();

        //7.处理结果集
        while (resultSet.next()){
            String name = resultSet.getString(1);
            System.out.println(name);
        }

        //事务提交
        connection.commit();

        //8.关闭资源
        if(resultSet!=null){
            resultSet.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(connection!=null){
            connection.close();
        }
        if(dataSource!=null){
            dataSource.close();
        }
    }

}
