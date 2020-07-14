package com.test1.ch04.annotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component将当前的类添加至IOC容器中
@Component
public class Dept {

    @Value(value = "6")
    private Integer id;
    @Value(value = "研发部")
    private String name;

    public Dept() {
    }

    public Dept(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
