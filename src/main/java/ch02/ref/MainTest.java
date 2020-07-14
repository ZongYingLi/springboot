package com.test1.ch02.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        //1.创建IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch02_ref.xml");
        //2.注入实例bean  通过getBean(Class class)要求当前IOC容器中有且只能有一个实例bean
        Person person = ac.getBean(Person.class);
        System.out.println(person);
    }

}
