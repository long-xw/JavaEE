package com.bigjava.demo.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强的类
 * @author LXW
 * @creat2020-11-15-下午 2:49
 */

@Component
@Aspect         //生成代理对象
@Order(3)
public class UserProxy {
    //相同的切入点抽取
    @Pointcut (value = "execution(* com.bigjava.demo.aopanno.User.add(..))")
    public void pointdemo() {

    }

    //前置通知
    //@Before注解表示作为前置通知
    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("User Before......");
    }

    //最终通知
    @After(value = "pointdemo()" )
    public void after() {
        System.out.println("after ......");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "pointdemo())" )
    public void afterReturning() {
        System.out.println("AfterReturning ......");
    }


    //异常通知
    @AfterThrowing(value = "pointdemo()" )
    public void afterThrowing() {
        System.out.println("AfterThrowing ......");
    }


    //环绕通知
    @Around(value = "pointdemo()" )
    public void around(ProceedingJoinPoint proceedingJoinPoint)  throws Throwable{
        System.out.println("环绕之前 ......");
        //被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后 ......");
    }

}
