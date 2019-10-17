package model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/9/25.
 */
public class SubjectProxyImpl implements SubjectProxy  {

    Subject subject;

    @Override
    public void SayHello() {

        System.out.println("zhiqian");
        subject = new SubjectImpl();
        subject.SayHello("dadasd");
        System.out.println("zhiqian");

    }
}
