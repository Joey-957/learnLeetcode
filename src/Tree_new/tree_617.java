package Tree_new;

public class tree_617 {

    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
//        if (t1==null&&t2==null){
//            return null;
//        }
//        if (t1.left==null&&t2.left==null){
//            return t1;
//        }
//        if (t2.right==null&&t2.right==null){
//            return t1;
//        }
//        if (t1.left!=null&&t2.left!=null){
//            t1.left.val += t2.left.val;
//        }else if(t1.left==null&&t2.left!=null){
//            t1.left = t2.left;
//        }
//        mergeTrees(t1.left,t2.left);               必须带返回值  t1 = mergeTrees(t1.left,t2.left)
//        mergeTrees(t1.right,t2.right);             同上    t1 就是通过得到返回值来改变t1的结构
//        return t1;

        if (t1==null){
            return t2;
        }
        if (t2==null){
            return t1;
        }
        if (t1!=null&&t2!=null){
            t1.val += t2.val;
        }


        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        t1.left = n1;
        t1.right = n2;
        n1.left = n3;

        t2.left = n4;
        t2.right = n5;
        n4.right = n6;
        n4.left = null;
        n5.right = n7;
        n5.left = null;

        new tree_617().mergeTrees(t1,t2);
    }
}
