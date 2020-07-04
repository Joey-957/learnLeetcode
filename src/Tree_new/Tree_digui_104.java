package Tree_new;

public class Tree_digui_104 {
    public int getMaxDepth(TreeNode root){
        if (root==null){
            return 0;
        }else{
            int leftDepth = getMaxDepth(root.right);
            int rightDepth = getMaxDepth(root.right);
            return Math.max(leftDepth,rightDepth)+1;
        }
    }
}
