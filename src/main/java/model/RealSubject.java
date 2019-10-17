package model;

/**
 * Created by Administrator on 2017/11/29.
 */
public class RealSubject implements Subject{



    public RealSubject(){

        super();

    }
    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name)
    {
        return "hello " + name;
    }

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye()
    {
        return " good bye ";
    }
}
