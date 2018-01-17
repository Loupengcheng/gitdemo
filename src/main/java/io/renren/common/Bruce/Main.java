package io.renren.common.Bruce;


import org.apache.commons.lang.enums.EnumUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
public class Main {

    private static final ThreadLocal<Integer> localInt = new ThreadLocal<>();

    public static void main(String[] args) throws IOException {
        /*
        IHelloWorld helloWorld = new HelloWorld();

        DynamicProxy dynamicProxy = new DynamicProxy(helloWorld);

        IHelloWorld helloWordProxy = (IHelloWorld)Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),helloWorld.getClass().getInterfaces(),dynamicProxy);

        helloWordProxy.sysHello();
        */

        /*
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-iocTest.xml");

        IUserService userService = ctx.getBean(IUserService.class);
        userService.add();
        */

        /*
        String resource = "mybatis_test.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = userInfoMapper.GetUserById(1);
            System.out.println(userInfo.toString());
        }
        finally {
            sqlSession.close();
        }
        */

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-iocTest.xml");
    }

    public void testMethod()
    {
        localInt.set(1);
        localInt.get();
    }

}
