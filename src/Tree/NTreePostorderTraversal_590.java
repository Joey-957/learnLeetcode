package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历，递归和非递归
 */
public class NTreePostorderTraversal_590 {
    //--------递归写法---------------
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        helper(root, list);
        return list;
    }

    public void helper(Node root, List list) {
        if (root == null) {
            return;
        }
        int num = root.children.size();
        for (int i = 0; i < num; i++) {
            helper(root.children.get(i), list);
        }
        list.add(root.val);
    }

    //------------非递归写法-----------------------
    // linkedList 返回到list；
    public List<Integer> noRecursion(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        if (root==null){
            return list;
        }
        stack.push(current);
        while(!stack.empty()){
            current = stack.pop();
            list.addFirst(current.val);
            //stack.push(current);
            if (root.children.size()!=0){
                //int index = current.children.size() - 1;
                for (Node node:current.children) {
                    stack.push(node);
                }
            }
        }
        return list;
    }
}
