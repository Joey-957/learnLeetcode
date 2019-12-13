package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树即二叉查找树，二叉搜索树的增删查方法的具体实现
 */
public class FunctionOfTreeImpletion implements FunctionOfTree{
    //实现一、递归实现
//    @Override
//    public TreeNode findTreeNode(int key,TreeNode root) {
//        TreeNode current = root;
//        if(current.getData()==key){
//            return current;
//        }
//        if(current.getData()<key&&current.getRightTreeNode()!=null){
//            return findTreeNode(key,current.getRightTreeNode());
//        }
//        if(current.getData()>key&&current.getLeftTreeNode()!=null){
//            return findTreeNode(key,current.getLeftTreeNode());
//        }
//        return null;
//    }

    //实现方式二、采用循环方式，不是用递归
    @Override
    public TreeNode findTreeNode(int key, TreeNode root) {
        TreeNode current = root;
        TreeNode TreeNodeReturn = null;
        while(current!=null){
            if(current.getData()==key){
                TreeNodeReturn = current;
                break;
            }
            if(current.getData()>key){
                current = current.getLeftTreeNode();
            }
            if(current.getData()<key){
                current = current.getRightTreeNode();
            }
        }
        return TreeNodeReturn;
    }

    @Override
    public boolean insertTreeNode(int key, TreeNode root) {
        TreeNode insertTreeNode = new TreeNode(key);
        if (root == null){
            root = insertTreeNode;
            return true;
        }
        TreeNode fatherTreeNode = root;
        boolean flag = false;
        while(root!=null){
            fatherTreeNode = root;
            if (root.getData()==key){
                flag = true;
                break;
            }
            if (root.getData()<key){
                root = root.getRightTreeNode();
            }else {
               root = root.getLeftTreeNode();
            }
        }
        if(fatherTreeNode.getData()<key){
            fatherTreeNode.setRightTreeNode(insertTreeNode);
            flag = true;
        }
        if (fatherTreeNode.getData()>key){
            fatherTreeNode.setLeftTreeNode(insertTreeNode);
            flag = true;
        }
        return flag;
    }

    /**
     * @param key value
     * @param root rootTreeNode
     * @return true or false
     *
     * 删除节点是二叉搜索树中最复杂的操作，删除的节点有三种情况
     * 1.删除的是叶子节点
     * 2.该节点有一个叶子节点
     * 3.该节点有两个叶子节点
     */
    @Override
    public boolean delete(int key, TreeNode root) {
        TreeNode current = root;
        TreeNode parentTreeNode = root;
        boolean flag = false;
        while(current!=null){
            if (current.getData()==key){
                break;
            }
            if (current.getData()<key){
                parentTreeNode = current;
                current = current.getRightTreeNode();
            }else{
                parentTreeNode = current;
                current = current.getLeftTreeNode();
            }
        }
        if (current == null){
            return flag;
        }
        //1.删除的是叶子节点
        if(current.getLeftTreeNode()==null&&current.getRightTreeNode()==null){
            if (parentTreeNode.getData()<current.getData()){
                parentTreeNode.setRightTreeNode(null);
            }else {
                parentTreeNode.setLeftTreeNode(null);
            }
            flag = true;
        }
        //2.删除的是有一个叶子节点
        if (current.getRightTreeNode()==null||current.getLeftTreeNode()==null){
            TreeNode childTreeNode = null;
            if(current.getLeftTreeNode()==null){
                childTreeNode = current.getRightTreeNode();
            }else {
                childTreeNode = current.getLeftTreeNode();
            }
            if (parentTreeNode.getData()<current.getData()){
                parentTreeNode.setRightTreeNode(childTreeNode);
            }else{
                parentTreeNode.setLeftTreeNode(childTreeNode);
            }
            flag = true;
        }
        //3.删除的节点有两个叶子节点,使用被删节点的后继节点替代，后继节点是：比删除节点大的最小节点
        //找到后继节点，然后把current要删除的节点替换掉
        else{



            flag = true;
        }





        return flag;
    }

    /**
     * 遍历树，根据特定的顺序访问数的每一个节点。比较常见的是前序遍历、中序遍历、后序遍历
     * 1.中序遍历：左子树-》根节点-》右子树
     * 2.前序遍历：根节点-》左子树-》右子树
     * 3.后序遍历：左子树-》右子树-》根节点
     */
    //中序遍历,从小到大输出,采用递归
    public void infixOrder(TreeNode root){
        //if(root==null){return;}
        if(root!=null){
            infixOrder(root.getLeftTreeNode());
            System.out.println(root.getData());
            infixOrder(root.getRightTreeNode());
        }
    }
    //前序遍历
    public void preOrder(TreeNode root){
        if (root!=null){
            System.out.println(root.getData());
            preOrder(root.getLeftTreeNode());
            preOrder(root.getRightTreeNode());
        }
    }
    //后序遍历
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.getLeftTreeNode());
            postOrder(root.getRightTreeNode());
            System.out.println(root.getData());
        }
    }

    /**
     * 查找最大值最小值
     * 最大值：没有左节点的节点
     * 最小值：没有右节点的节点
     */
    public TreeNode MaxNum(TreeNode root){
        TreeNode current = root;
        TreeNode maxTreeNode = current;
        while(current!=null){
            maxTreeNode = current;
            current = current.getRightTreeNode();
        }
        return maxTreeNode;
    }
    public TreeNode MinNum(TreeNode root){
        TreeNode minTreeNode = root;
        while(root!=null){
            minTreeNode = root;
            root = root.getLeftTreeNode();
        }
        return minTreeNode;
    }

    /**
     *  二叉树的层次遍历（使用队列)
     *
     */
    public void BinaryTreeLevelSearch(TreeNode root){
        TreeNode current = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            current = queue.poll();
            System.out.println(current.getData());
            if (current.getLeftTreeNode()!=null){
                queue.offer(current.getLeftTreeNode());
            }
            if(current.getRightTreeNode()!=null){
                queue.offer(current.getRightTreeNode());
            }
        }

    }
}
