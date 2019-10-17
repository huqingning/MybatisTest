import bean.tree.BinaryTree;
import bean.tree.Node;
import org.junit.Test;

/**
 * Created by Administrator on 2019/6/21.
 */
public class nodetest {


    @Test
    public void test(){
        BinaryTree bt = new BinaryTree();

        bt.insert(1);
        bt.insert(22);
        bt.insert(2);
        bt.insert(3);

        System.out.println(bt.findMax());

    }
}
