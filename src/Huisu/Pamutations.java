package src.Huisu;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 无重复全排列，使用回溯法暴力枚举求解
 * 参考知乎大神的帖子：https://zhuanlan.zhihu.com/p/93530380
 *
 * leetcode  全排列 无重复版，leetcode 46
 *
 */

//第一种解法，没有使用标志数组
public class Pamutations {

    public List<List<Integer>> listAll = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> listIn = new LinkedList<>();
        recursion(nums,listIn);

        return listAll;
    }
    public void recursion(int[] nums,LinkedList<Integer> list){
           if (list.size()==nums.length){
               listAll.add(new LinkedList<>(list));  // 注意的点： 把list以此为元素内容，再建一个new LinkedList（List list）。
               return;
           }
           for(int i=0;i<nums.length;i++){
               if (list.contains(nums[i])){
                   continue;
               }
               list.add(nums[i]);
               recursion(nums, list);
               list.removeLast();
           }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        Pamutations p = new Pamutations();

        System.out.println(p.permute(array).toString());
        System.out.println(p.listAll.toString());
    }
}

// 第二种、使用标志数组
class Pamutation{

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

//    public static void main(String[] args) {
//        int[] nums = {1, 1, 3};
//        Pamutation solution = new Pamutation();
//        List<List<Integer>> lists = solution.permute(nums);
//        System.out.println(lists);
//    }



}
