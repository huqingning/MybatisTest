package model;

/**
 * Created by Administrator on 2018/9/25.
 */
public class SubjectImpl implements Subject {
    @Override
    public String SayHello(String name) {
        return "huqigning";
    }

    @Override
    public String SayGoodBye() {
        return null;
    }
}
