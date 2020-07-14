package com.test1.ch04.annotation.dao;

import org.springframework.stereotype.Repository;

//@Repository标注当前类是一个持久层，完成数据操作，添加至IOC容器中
//当前若提供value属性，则在IOC容器中此实例的id将是value指定的名称；若没有指定value属性，则按照当前类名的首字母小写来作为id
@Repository(value = "deptDao")
public class DeptDao implements IDao{

    public void select(){
        System.out.println("UserDao select()....");
    }

}
