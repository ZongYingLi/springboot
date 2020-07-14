package  com.test1.ch06.aop.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch06_aop.xml");

        ICount bean = (ICount)ac.getBean("countImpl");
        System.out.println(bean.getClass().getName());

        int result1 = bean.add(10, 20);
        System.out.println("-->result1 = "+result1);

        int result2 = bean.div(20, 0);
        System.out.println("-->result2 = "+result2);
    }

}
