package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉排序树的前序遍历，递归和非递归
 */
public class NTPreorderTrav_589 {
    //recursion
    public List<Integer> NPreRecursion(Node root){
        List<Integer> list = new LinkedList<>();
        helper(root,list);
        return list;
    }
    private void helper(Node root,List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        for(int i = 0;i<root.children.size();i++){
            helper(root.children.get(i),list);
        }
    }

    /**
     * 非递归方法,根左右，用时5ms，官方答案亦然
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        if (root==null){
            return list;
        }
        stack.push(current);
        while(!stack.empty()){

            current = stack.pop();
            list.add(current.val);
            if (root.children.size()!=0){
                int index = current.children.size() - 1;
                for (int i = index; i >= 0; i--) {
                    stack.push(current.children.get(i));
                }
            }
        }
        return list;
    }
}
