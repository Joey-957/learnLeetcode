package src.Tree;



import java.util.HashMap;
import java.util.Map;

public class 后序遍历加中序遍历构造二叉树 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    int[] post = null;
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        int length = inorder.length;
        for (int i = 0;i< length;i++){
            map.put(inorder[i],i);
        }
        int lengthPost = postorder.length;
        return recursion(lengthPost -1,0,length -1);
    }
    public TreeNode recursion(int postPre,int leftIndex,int rightIndex){
        if (leftIndex > rightIndex){
            return  null;
        }
        TreeNode root = new TreeNode(post[postPre]);
        int mid = map.get(post[postPre]);
        root.right = recursion(postPre -1 ,mid +1,rightIndex);
        root.left = recursion(postPre - (rightIndex - mid) -1,leftIndex,mid-1);
        return  root;
    }

    public static void main(String[] args) {
        后序遍历加中序遍历构造二叉树 df = new 后序遍历加中序遍历构造二叉树();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};
        TreeNode root = df.buildTree(inorder,postOrder);

    }
}
