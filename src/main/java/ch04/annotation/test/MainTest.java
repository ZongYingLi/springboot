package com.test1.ch04.annotation.test;

import com.igeek.ch04.annotation.controller.DeptController;
import com.igeek.ch04.annotation.entity.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        //1.创建IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch04_annotation.xml");

        //2.注入实例，获得实例
        Dept dept = ac.getBean(Dept.class);
        System.out.println(dept);

        DeptController controller = ac.getBean(DeptController.class);
        controller.find();

    }

}
