package io.renren.common.Bruce;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();

        Object result = method.invoke(target,args);

        after();

        return result;
    }

    private void before()
    {
        System.out.println("before");
    }

    private void after()
    {
        System.out.println("after");
    }
}
