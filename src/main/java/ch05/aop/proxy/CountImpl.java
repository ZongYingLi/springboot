package com.test1.ch05.aop.proxy;

//计算器的实现类：纯业务逻辑
public class CountImpl implements ICount {

    @Override
    public int add(int a, int b) {
        int result = a+b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a-b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a*b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a/b;
        return result;
    }
}
