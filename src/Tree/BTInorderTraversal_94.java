package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉排序树的中序排序，递归写法和循环写法。
 */
public class BTInorderTraversal_94 {

    private List<Integer> list = new LinkedList<>();

    /**
     * 递归，左中右
     */
    public List<Integer> inorderTraversal(TreeNode_ root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
//---------------------------------------------------------------------------------

    /**
     * Leetcode官方题解递归，借助辅助函数，无需新建成员变量List
     */
    public List<Integer> leetcode(TreeNode_ root) {
        List<Integer> list = new LinkedList<Integer>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode_ root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                helper(root.right, list);
            }
        }
    }
//---------------------------------------------------------------------------------

    /**
     * 非递归中序排序
     */
    public List<Integer> inorder(TreeNode_ root) {
        Stack<TreeNode_> stack = new Stack<>();
        List<Integer> listInorder = new LinkedList();
        TreeNode_ current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            listInorder.add(current.val);
            current = current.right;
        }
        return listInorder;
    }

    /**
     * 非递归前序遍历，根-》左-》右
     */
    public List<Integer> preOrder(TreeNode_ root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode_> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode_ current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                list.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return list;
    }

    /**
     * 非递归后序遍历，左节点-》右节点-》根节点
     * 引入节点lastNode
     */
    public List<Integer> postOrder(TreeNode_ root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode_> stack = new Stack<>();
        TreeNode_ current = root;
        TreeNode_ lastNode = null;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode_ popNode = stack.pop();
            if (popNode.right == null || popNode.right == lastNode) {
                list.add(popNode.val);
                lastNode = popNode;
                //current = stack.pop().right;
            } else {
                stack.push(popNode);
                current = popNode.right;
            }
        }
        return list;
    }


    public List<Integer> postorderTraversal(TreeNode_ root){
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode_> stack = new Stack<>();
        TreeNode_ current = root;
        TreeNode_ lastNode = null;
        TreeNode_ popNode = null;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            popNode = stack.pop();
            if (popNode.right == null || popNode.right == lastNode) {
                list.add(popNode.val);
                lastNode = popNode;
            } else {
                stack.push(popNode);
                current = popNode.right;//关键 别忘了  error 写错过current = current.right!!!
            }
        }
        return list;
    }

}
