package Tree;

/**
 * 有序数组转化二叉搜索树（平衡的）
 * 分析：没思路，二分思想找每层的根节点
 * 递归；
 */
public class SortedArraytoBinaSearTree_108 {

    protected TreeNode_ sortedArrayToBST(int[] nums){
        int min = 0,max = nums.length-1;
        int middle = (min+max)/2;
        if (nums.length==0){
            return null;
        }
        if (nums.length==1){
            return new TreeNode_(nums[min]);
        }
        if (nums.length==2){
            TreeNode_ root  = new TreeNode_(nums[0]);
            root.right = new TreeNode_(nums[1]);
            return root;
        }
        TreeNode_ root = new TreeNode_(nums[middle]);
        TreeNode_ returnNode;
        returnNode = root;
        helper(min,middle-1,nums,root);
        helper(middle+1,max,nums,root);
        return returnNode;
    }

    public void helper(int min,int max,int[] nums,TreeNode_ node){
        if (min == max){
            TreeNode_ node1 = new TreeNode_(nums[min]);
            if (node.val>=node1.val){
                node.left = node1;
            }else{
                node.right = node1;
            }
            return;
        }
        int middle = (min+max)/2;
        if (min==middle){
            TreeNode_ node1 = new TreeNode_(nums[min]);
            TreeNode_ node2 = new TreeNode_(nums[max]);
            node.left = node1;
            node1.right = node2;
        }

    }


    //上面的版本冗杂,3.0
    protected TreeNode_ sortedArrayToBST2(int[] nums){
        if (nums.length==0){
            return null;
        }
        int min = 0,max = nums.length-1;
        //int middle = (min+max)/2;
        TreeNode_ root = null;             // = new TreeNode_(nums[middle]);
        TreeNode_ rootR = root;
        helper2(min,max,nums,root);

        return rootR;
    }

    public void helper2(int min,int max,int[] nums,TreeNode_ root){
        TreeNode_ node = null; //新创建一个节点

        if (min == max){
            TreeNode_ node1 = new TreeNode_(nums[min]);
            if (node.val>=node1.val){
                node.left = node1;
            }else{
                node.right = node1;
            }
            return;
        }
        int middle = (min+max)/2;
        if (min==middle){
            root.val = nums[min];
            TreeNode_ node1;
            node1= new TreeNode_(nums[max]);
            root.left = node1;
        }
        node = new TreeNode_(nums[middle]);
        root= node;
        helper2(min, middle-1, nums, root);
        helper2(middle+1,max,nums,root);
    }
//------------------------------------------------------------------
    //官方标答，左右子树分开
    protected TreeNode_ sortedArrayToBST_(int[] nums){
        return qq(nums,0,nums.length-1);
    }

    private TreeNode_ qq(int[]nums,int min,int max){
        if (min==max){
            return new TreeNode_(nums[min]);
        }else if(min>max){
            return null;
        }
        int mid = min+((max-min)>>1);
        /**
         * mid = (min+max)>>1存在溢出风险，建议更改成；
         * mid = min+(max-min)>>1,>>1运算优先级低，需要带括号
         */
        TreeNode_ root = new TreeNode_(nums[mid]);
        root.left = qq(nums,min,mid-1);
        root.right = qq(nums, mid+1, max);
        return  root;
    }
}
