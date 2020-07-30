package src.Tree;

import java.util.*;

/**
 * leetCode 1008. 先序遍历构造二叉树
 */
public class 先序遍历构造二叉排序树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    //方法一;

    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int temp = 0;
        TreeNode cur = null;//BST 遍历节点
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for(int i = 1;i< preorder.length;i++){
            temp = preorder[i];
            cur = new TreeNode(temp);

                if(stack.peek().val > temp){
                    stack.peek().left = cur;
                    stack.push(cur);
                    continue;
                }
                TreeNode par = null;
                while(!stack.isEmpty() && stack.peek().val < temp ){
                    par =  stack.pop();
                }
                par.right = cur;
                stack.push(cur);
            }

        return root;
    }

    Map<Integer,Integer> map = new HashMap<>();
    int[] pre = null;
    //方法二 ：使用先序遍历 得到中序遍历，利用二叉树的中序遍历和先序遍历构造二叉树。
    public TreeNode bstFromPreorder2(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        for (int i = 0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        pre = preorder;
        return recursion(0,0,inorder.length-1);

    }

    public TreeNode recursion(int preIndex,int leftIndex,int rightIndex){
        if (leftIndex > rightIndex){
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex]);
        int mid = map.get(pre[preIndex]);
        root.left = recursion(preIndex + 1,leftIndex,mid -1);
        root.right = recursion(preIndex + (mid - preIndex)+1,mid + 1,rightIndex);
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] b = a.clone();
        int[] c = Arrays.copyOf(a,a.length);

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Collections.reverse(list);
        System.out.println(list.get(0));
    }
}
