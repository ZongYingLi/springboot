package com.test1.ch04.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmpDao implements IDao {
    @Override
    public void select() {
        System.out.println("EmpDao select() ...");
    }
}
