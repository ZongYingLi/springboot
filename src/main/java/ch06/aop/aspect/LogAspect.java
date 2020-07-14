package  com.test1.ch06.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Order(2)
public class LogAspect {

    /**
     * 公共的切入点表达式
     * 1.通过@Pointcut("execution()")来声明公共切入点
     * 2.无需提供方法逻辑，空方法
     */
    @Pointcut("execution(public int com.igeek.ch06.aop.aspect.CountImpl.*(..))")
    public void pointCut(){ }

    /**
     * 前置通知
     * 1.在方法执行之前执行的通知，前置通知使用 @Before 注解, 并将切入点表达式的值作为注解值.
     * 2.切点表达式 @Before("execution(public int com.igeek.ch06.aop.aspect.CountImpl.add(int,int))")
     * 3.切点表达式省略写法：
     * 第一个* ： 匹配任意访问权限 任意返回值
     * 同包路径下，可以省略包名
     * 第二个* ： 匹配任意方法
     * .. ： 匹配任意参数列表
     */
    //@Before("execution(*  CountImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdvice(JoinPoint jp){
        //方法名
        String methodName = jp.getSignature().getName();
        //参数列表
        List<Object> args = Arrays.asList(jp.getArgs());
        //日志追踪
        System.out.println("日志追踪： the method "+methodName+" begin with "+args);
    }

    //后置通知
    //@After("execution(*  CountImpl.*(..))")
    @After("pointCut()")
    public void afterAdvice(JoinPoint jp){
        System.out.println("日志追踪： the method "+jp.getSignature().getName()+" end with");
    }

    /**
     * 返回通知
     * 1.通过value属性指定切点
     * 2.通过returning属性，将返回值赋值在result参数上，一定要保证 returning的值 与 方法的形参名称一致
     */
    //@AfterReturning(value = "execution(* CountImpl.*(..))" , returning = "result")
    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterReturningAdvice(JoinPoint jp,Object result){
        System.out.println("日志追踪： the method "+jp.getSignature().getName()+" end with "+result);
    }

    /**
     * 异常通知
     * 1.通过value属性指定切点
     * 2.通过throwing属性，将异常信息赋值在ex参数上，一定要保证throwing的值 与 方法的形参名称一致
     */
    //@AfterThrowing(value = "execution(* CountImpl.*(..))" , throwing = "ex")
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint jp,Exception ex){
        System.out.println("日志追踪： the method "+jp.getSignature().getName()+" 抛出异常： "+ex.getMessage());
    }

    /**
     * 环绕通知
     * 1.连接点：ProceedingJoinPoint 提供了可以执行方法
     */
    //@Around("execution(* CountImpl.*(..))")
    public int aroundAdvice(ProceedingJoinPoint pjp){
        int result = 0;
        //前置通知
        System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" begin with "+Arrays.asList(pjp.getArgs()));
        try {
            result = (int)pjp.proceed();
            //返回通知
            System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" end with "+result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" 抛出异常： "+throwable.getMessage());
        }
        //后置通知
        System.out.println("环绕通知--日志追踪： the method "+pjp.getSignature().getName()+" end with");
        return result;
    }

}
