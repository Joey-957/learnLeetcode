package src.SwordOffer;

/**
 * 输入一个数组，判断该数组是不是某二叉搜索树后序遍历的结果
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * 后序遍历： 左右跟， 所以如果是后序遍历数组符合以下规则：
 *                                                1、最后一个元素是根节点元素
 *                                                2、第一个比根节点大的元素是有点点中的第一个元素，所以找到右子树第一个元素边界
 *                                                3、根节点左子树元素都比根节点元素小，根节点右子树都比根节点元素大
 *                                                4、分治法切割成子直到i>=j
 */
public class Swold33 {
    public boolean verifyPostorder(int[] postorder) {
        int left = 0;
        int right = postorder.length-1;
        return func(postorder,left,right);
    }
    public boolean func(int[] array,int index,int rootIndex){
        if (index>=rootIndex){
            return true;
        }
        int left = index;
        while(array[index]<array[rootIndex]){
            index++;
        }
        int m = index;
        while (array[index]>array[rootIndex]){
            index++;
        }
        return index == rootIndex&&func(array,left,m-1)&&func(array,m,rootIndex-1);
    }
}
