package src.SwordOffer;

import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化二叉树
 *   需要学 StringBuilder 的 setLength api  和 得到BST的层次遍历 输出 二叉树的根节点结构。
 *
 * 1. 使用递归中序遍历，放入list中 然后 list toString 转字符串。
 *   坏处是 list 或插入空格，需要特殊处理，去掉空格
 *
 * 2. 预计使用 stringBuffer  sb.append()拼接字符串拼接，然后使用 String.substring(startIndex,endIndex).split(",") 根据 分隔符放入String数组
 */
public class Swold37 {
    public String serialize(TreeNode root) {
        if (root == null){
            return new String();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Object> lists = new LinkedList<>();

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null){
                lists.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                lists.add('#');
            }
        }
        Object[] array = new Object[lists.size()];
        lists.toArray(array);
        return lists.toString();


    }

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3};
        String str1 = Arrays.toString(array);

        TreeNode t1= new TreeNode(-1);
        TreeNode t2= new TreeNode(0);
        TreeNode t3= new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        String s = new Swold37().serialize(t1);
        System.out.println();
        TreeNode root =new Swold37().deserialize(s);
    }
     //Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arrays = data.substring(1,data.length()-1).split(",");

        TreeNode root = null;
        TreeNode temp = null;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        // 因为 list转化里面会有空格，需要去掉空格
        for (int i=0;i<arrays.length;i++){
            if (i!=0){
                String str = arrays[i].substring(1,arrays[i].length());
                if (str.equals("#")){
                    queue1.offer(null);
                }else{
                    queue1.offer(new TreeNode(Integer.parseInt(str)));
                }
            }else {
                queue1.offer(new TreeNode(Integer.parseInt(arrays[i])));
            }
        }

        temp  = queue1.poll();
        if (temp != null){
            root = temp;
            queue2.offer(root);
        }
        TreeNode t = null;
        TreeNode left = null;
        TreeNode right = null;
        while(!queue2.isEmpty()){
            t = queue2.poll();
            if (t == null){
                continue;
            }
            if (!queue1.isEmpty()){
                left = queue1.poll();
                t.left = left;
                queue2.offer(left);
            }
            if (!queue1.isEmpty()){
                right = queue1.poll();
                t.right = right;
                queue2.offer(right);
            }

        }

        return root;
    }
}
class try2{
    public String serialize(TreeNode root) {
        if (root == null){
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //水平遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            //sb.append(cur.val+",");
            if (cur == null){
                sb.append("null,");
            }else {
              sb.append(cur.val+",");
              queue.offer(cur.left);
              queue.offer(cur.right);
            }
        }
        sb.setLength(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }
        String[] nodes = data.substring(1,data.length()-1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode parent = root;
        boolean isleft = true;
        for (int i=1;i<nodes.length;i++){
            TreeNode cur = getNode(nodes[i]);
            if (isleft){
                parent.left = cur;
            }else{
                parent.right = cur;
            }
            if (cur != null){
                queue.offer(cur);
            }
            isleft = !isleft;
            if (isleft){
                parent = queue.poll();
            }
        }
        return root;
    }
    // 把String 转化成小的节点
    private TreeNode getNode(String val){
        if (val.equals("null")){
            return  null;
        }
        return new TreeNode(Integer.valueOf(val));             //  讲string 类型的数字转化成int
    }

}