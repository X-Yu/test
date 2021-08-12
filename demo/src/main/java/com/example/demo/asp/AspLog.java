package com.example.demo.asp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName : AspLog  //类名
 * @Description : 切面类  //描述
 * @Author : lhy  //作者
 * @Date: 2020-03-27 14:15  //时间
 */
@Aspect
@Component
public class AspLog {
    // 指定切入点表达式： 拦截哪些方法； 即为哪些类生成代理对象
    // 解释@Pointcut("execution(* cn.itcast.e_aop_anno.*.*(..))")
    @Pointcut("@annotation(com.example.demo.asp.Log)")
    public void pointCut_(){
    }

    // 前置通知 : 在执行目标方法之前执行
    @Before("pointCut_()")
    public void begin(){
        System.out.println("开始打印日志");
    }

    // 后置/最终通知：在执行目标方法之后执行  【无论是否出现异常最终都会执行】
    @After("pointCut_()")
    public void after(){
        System.out.println("结束日志打印");
    }

    // 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
//    @AfterReturning("pointCut_()")
//    public void afterReturning() {
//        System.out.println("afterReturning()");
//    }

    // 异常通知： 当目标方法执行异常时候执行此关注点代码
    @AfterThrowing("pointCut_()")
    public void afterThrowing(){
        System.out.println("afterThrowing()");
    }

    // 环绕通知：环绕目标方式执行
//    @Around("pointCut_()")
//    public void around(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("环绕前....");
//        pjp.proceed();  // 执行目标方法
//        System.out.println("环绕后....");
//    }
}
