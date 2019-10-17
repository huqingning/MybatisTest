package model;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/11/29.
 */
public class proxyTest {
    public static void main(String[] args){

        Subject realSubject = new RealSubject();

        /**
         * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         */


        InvocationHandler handler = new InvocationHandlerImpl(realSubject);


        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        byte[] classFile  =  ProxyGenerator.generateProxyClass("$proxy1123",realSubject.getClass().getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("D:/$proxy1123.class");
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
        System.out.println("动态代理对象的类型："+subject.getClass().getName());

        String hello = subject.SayHello("huqingning");
        System.out.println(hello);

    }
}
