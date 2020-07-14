import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {


        HelloWorld helloWorld = new HelloWorld();

        helloWorld.setUsername1("李宗莹");

        helloWorld.work();

        System.out.println();
        System.out.println("-------------Spring IOC------------");

        //1.创建IOC容器对象，此时容器创建后，就会立即创建容器中的bean实例及赋值
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.注入HelloWorld的实例bean
        // HelloWorld h = (HelloWorld)ac.getBean("h");
        //若通过类类型获取实例，要求当前IOC容器中有且只有一个当前类型的实例bean
        HelloWorld h = ac.getBean(HelloWorld.class);
        //3.使用bean
        h.work();
    }

}

