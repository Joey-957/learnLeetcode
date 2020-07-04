package src.SwordOffer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Swold28 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return fun(root,root);
    }

    public boolean fun(TreeNode rootLeft,TreeNode rootRight){
        if(rootLeft==null&&rootRight==null){
            return true;
        }
        if(rootLeft==null||rootRight==null){
            return false;
        }
        if(rootLeft.val!=rootRight.val){
            return false;
        }
        return fun(rootLeft.left,rootRight.right)&&fun(rootLeft.right,rootRight.left);
    }
}
