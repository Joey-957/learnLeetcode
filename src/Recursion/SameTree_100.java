package Recursion;

import Tree_new.TreeNode;

public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //boolean flag = true;
        //boolean flag_r = false;
        if (p==null&&q==null){
            return true;
        }
        if (p==null||q==null){
            //flag = false;
            return false;
        }
        if (q.val!=p.val){
//            flag = isSameTree(p.left,q.left);
//            flag = isSameTree(p.right,p.right);
            return false;
        }

        return isSameTree(p.left,p.left)&&
                isSameTree(p.right,q.right);

    }
}
