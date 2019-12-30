package Tree;

import java.util.List;

/**
 * N叉排序树的定义
 */
public class Node {
    public int val;
    public List<Node> children;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
    public Node (int val,List<Node> list){
        this.val = val;
        this.children = list;
    }
}
