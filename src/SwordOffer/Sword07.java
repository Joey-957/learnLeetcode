package src.SwordOffer;

import java.util.HashMap;
import java.util.Map;

public class Sword07 {
    // 回炉重组























    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder ==null||preorder.length==0){         // preorder 引用为空
            return null;
        }
        Map<Integer,Integer> indexMap = new HashMap<Integer, Integer>();//存储数组中的值和下表的对应关系
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
