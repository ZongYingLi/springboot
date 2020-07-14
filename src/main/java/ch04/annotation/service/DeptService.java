package com.test1.ch04.annotation.service;

import com.igeek.ch04.annotation.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service标注当前类是一个业务逻辑类，添加至IOC容器中
@Service
public class DeptService {

    //@Autowired 按照类型自动装配，在IOC容器中查找，若在IOC容器中出现匹配类型不唯一，则会报错
    //@Resource(name="deptDao") 指定id名称自动装配   @Resource(type=DeptDao.class) 指定类型自动装配
    //@Autowired
    @Resource(name="deptDao")
    private IDao dao;

    public void selectOne(){
        dao.select();
        System.out.println("DeptService selectOne()");
    }
}
