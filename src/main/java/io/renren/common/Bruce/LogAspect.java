package io.renren.common.Bruce;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    //@Pointcut("execution(* io.renren.common.Bruce.UserService.*(..))")
    @Pointcut("@annotation(io.renren.common.Bruce.LogAnnotation)")
    public void pointCut()
    {

    }

    @Before("pointCut()")
    public void before()
    {
        System.out.println("aspect before");
    }

    @After("pointCut()")
    public void after()
    {
        System.out.println("aspect after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning()
    {
        System.out.println("aspect afterReturning");
    }

}
