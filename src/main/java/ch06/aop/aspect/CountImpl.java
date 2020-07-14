package  com.test1.ch06.aop.aspect;

import org.springframework.stereotype.Component;

//计算器的实现类：纯业务逻辑
@Component
public class CountImpl implements ICount {

    @Override
    public int add(int a, int b) {
        System.out.println("add()");
        int result = a+b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub()");
        int result = a-b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul()");
        int result = a*b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div()");
        int result = a/b;
        return result;
    }
}
