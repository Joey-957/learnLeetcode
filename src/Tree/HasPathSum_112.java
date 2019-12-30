package Tree;

import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 分析：递归，sum依次减去每条路径节点值，(小于零及时返回)此处分析出错！！！！！，最终等于叶子节点则true
 */
public class HasPathSum_112 {

    private boolean flag = false;

    /**
     * 自己写的，树的递归一般都有分支，分支A（||&&）分支B
     *
     */
    public boolean hasPathSum(TreeNode_ root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            if(sum==root.val){
                flag = true;
                return flag;
            }
        }
//        if(sum<root.val){         error！sum可以是较大的负数，节点都是负数，这种情况不符合
//            return flag;
//        }
        sum = sum - root.val;
//        hasPathSum(root.left,sum);
//        hasPathSum(root.right,sum);
//        return flag;
        //改进
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }

//-----------------------------------------------------------------------------------
    //方法二：迭代
    public boolean hasPathSum_2(TreeNode_ root, int sum) {
        if (root==null){
            return false;
        }
        Stack<Integer> stackSum = new Stack<>();
        Stack<TreeNode_> stackNode = new Stack<>();
        stackNode.push(root);
        stackSum.push(sum-root.val);
        while(!stackNode.empty()){
            TreeNode_ node = stackNode.pop();
            int endSum = stackSum.pop();
            if (node.left==null&&node.right==null&&endSum==0){
                return true;
            }
            if (node.right!=null){
                stackNode.push(node.right);
                stackSum.push(endSum-node.right.val);
            }
            if (node.left!=null){
                stackNode.push(node.left);
                stackSum.push(endSum-node.left.val);
            }
        }
        return false;
    }

}
