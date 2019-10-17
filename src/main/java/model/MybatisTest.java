package model;

import mapper.userinfoMapper;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/21.
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        /*
         * 1.加载mybatis的配置文件，初始化mybatis，创建出SqlSessionFactory，是创建SqlSession的工厂
         * 这里只是为了演示的需要，SqlSessionFactory临时创建出来，在实际的使用中，SqlSessionFactory只需要创建一次，当作单例来使用
         */
        InputStream inputStream = Resources.getResourceAsStream("xml/mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);

        //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作
        SqlSession sqlSession = factory.openSession();


        
        userinfoMapper userinfoMapper = sqlSession.getMapper(userinfoMapper.class);   //通过Mapper接口


        userinfo us = new userinfo();
        us.setUid(1);
        us.setPassword("123456");
        us.setUname("huqingning");
        int i =userinfoMapper.updateByPrimaryKey(us);
//        int a =2/0;
        System.out.println(i);
        byte[] classFile  =  ProxyGenerator.generateProxyClass("$proxy11234",userinfoMapper.getClass().getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("D:/$proxy11234.class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        userinfo u = userinfoMapper.selectByPrimaryKey(1);
        System.out.println("userInfo："+u.getUname());

        //AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml/mybatis-config.xml");
        //3.使用SqlSession查询
        userinfo u1 = new userinfo();

        u1.setUid(1);
        //a.查询工资低于10000的员工
        List<userinfo> result = sqlSession.selectList("userinfoMapper.selectByPrimaryKey",u1);
        System.out.println("userInfo："+result.get(0));
    }
}
