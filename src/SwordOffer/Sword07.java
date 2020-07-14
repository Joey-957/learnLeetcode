package src.SwordOffer;

import java.util.*;


public class Sword07 {
    // 回炉重做
    private Map<Integer,Integer> map = new HashMap<>();
    private int[] pre = null;
    public  TreeNode buildTree3(int[] preorder,int[] inorder){
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        pre = preorder;
        return  recursion(0,0,inorder.length-1);

    }
    public TreeNode recursion(int preorderIndex,int inorderLeftIndex,int inorderRightIndex){
        if (inorderLeftIndex > inorderRightIndex){
            return null;
        }
        TreeNode root = new TreeNode(pre[preorderIndex]);
        int mid = map.get(pre[preorderIndex]); //得到被选作根节点的元素，在中序遍历序列中对应的index，便于下一步分割
        root.left = recursion(preorderIndex+1,inorderLeftIndex,mid - 1);
        root.right = recursion(preorderIndex + (mid-inorderLeftIndex) +1 ,mid+1,inorderRightIndex);
        return root;
    }

    public static void main(String[] args) {
        new Sword07().buildTree3(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }



















    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder ==null||preorder.length==0){         // preorder 引用为空
            return null;
        }
        Map<Integer,Integer> indexMap = new HashMap<>();//存储数组中的值和下表的对应关系
        int length = preorder.length;
        for (int i=0;i<length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,length-1,inorder,0,length-1,indexMap);
        return  root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);       // 因为两个数组中的的元素唯一，且相同
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }



}
