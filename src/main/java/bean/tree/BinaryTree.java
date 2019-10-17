package bean.tree;

/**
 * Created by Administrator on 2019/6/21.
 */
public class BinaryTree implements Tree {

    //表示根节点
    public Node root;

    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null){
            if(current.data > key){
                current = current.leftChild;
            }else if (current.data < key){
                current = current.rightChild;
            }else {
                return current;
            }
        }

        return null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return true;
        }else{
            Node current = root;
            Node parentNode = null;
            while (current != null){
                parentNode = current;
                if(current.data > data){
                    current = current.leftChild;
                    if(current == null){
                        parentNode.leftChild = newNode;
                        return true;
                    }
                }else {
                    current = current.rightChild;
                    if(current == null){
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void infixOrder(Node current) {
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }

    @Override
    public void preOrder(Node current) {

    }

    @Override
    public void postOrder(Node current) {

    }

    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null){
            maxNode = current;
            current = current.rightChild;
        }

        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null){
            minNode = current;
            current = current.leftChild;
        }

        return minNode;
    }

    @Override
    public boolean delete(int key) {
        return false;
    }
}
