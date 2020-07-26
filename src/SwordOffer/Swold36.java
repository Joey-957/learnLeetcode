package src.SwordOffer;
import java.util.Stack;

/**
 *  BST   的中序遍历是递增序列
 *  将二叉排序树转化成“排序的循环双向链表”
 *
 */
public class Swold36 {

    // 递归法比非递归法 快很多
    private Node pre, head;
    public Node treeToDoublyList(Node root){
        if (root == null){
            return null;
        }
        recursion(root);
        head.left = pre;
        pre.right = head;
        return  head;
    }

    public void  recursion(Node root){
        if (root ==null){
            return ;
        }
        recursion(root.left);
        if (pre !=null){
            pre.right = root;
            //root.left = pre;
        }else {
            head = root;
            head.left = pre;
        }
        root.left = pre;
        pre = root;
        recursion(root.right);
    }



    /**
     *  非递归法
     */
//    private Node pre, head;
//    public Node treeToDoublyList(Node root) {
//        if(root == null) return null;
//        res(root);
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//    public void res(Node root){
//        Stack<Node> stack = new Stack<>();
//        Node cur = root;
//        while(!stack.isEmpty() || cur != null){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if(pre != null) {
//                pre.right = cur;
//            } else {
//                head = cur;
//            }
//            cur.left = pre;
//            pre = cur;
//            cur = cur.right;
//        }
//    }























    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
