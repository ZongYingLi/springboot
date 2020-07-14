package  com.test1.ch06.aop.aspect.validate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    //环绕通知
    @Around("com.igeek.ch06.aop.aspect.LogAspect.pointCut()")
    public Object aroudAdvice(ProceedingJoinPoint pjp) throws Throwable {
        //获得方法名
        String methodName = pjp.getSignature().getName();
        //获得参数列表
        for(Object arg : pjp.getArgs()){
            int value = (int)arg;
            //此时出现非正数
            if(value<=0){
                System.out.println("校验参数：the method "+methodName+" validate校验时发现0或者负数");
                return 0;
            }
        }

        System.out.println("校验参数：the method "+methodName+" validate校验通过");
        Object result = pjp.proceed();
        return result;
    }

}
