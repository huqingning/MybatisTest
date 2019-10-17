package model;

import bean.product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;

import java.sql.*;

/**
 * Created by Administrator on 2017/12/5.
 */
public class jdbcTest {
    private Connection conn =null;
    @Before
    public void init() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/onlineshoping","root","123456");
    }

    @Test
    public  void test() throws Exception{
        Statement st = conn.createStatement();

        String sql ="select * from product where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);  //预编译，效率更高
        ps.setInt(1,1);
        ResultSet ret = ps.executeQuery();
//        ps.execute();
//        ps.getResultSet();
        while (ret.next()){
            product pro = new product();
            pro.setId(ret.getInt(1));
            pro.setName(ret.getString(2));
            pro.setPrice(ret.getString(4));
            System.out.println(pro);
        }
    }
}
