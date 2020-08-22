package src.Huisu;

import java.util.*;

/**
 *  全排列，有重复
 *
 *  给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 *  输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 *
 * 方法一 ： 使用标志位法 + set 结果集 去重: 效率很低
 * 方法二 ： 使用剪枝法去重
 *
 */
public class PamutationsII {

    public List<List<Integer>> results = new LinkedList<>();
    public Set<List<Integer>>  re = new HashSet<>();


    public List<List<Integer>> permuteUnique(int[] nums) {

          int length = nums.length;
          if (length==0){
              return results;
          }
          //建立标志数组
          boolean[] flag = new boolean[length];

          LinkedList<Integer> listChoice = new LinkedList<>();
          recursion(nums,listChoice,flag);

          results = new LinkedList<>(re);
          return results;
    }


    public void recursion(int[] nums,LinkedList<Integer> listChoice,boolean[] flagArray){
          if (listChoice.size()==nums.length){
              re.add(new LinkedList<>(listChoice));
              return;
          }

          for (int i = 0;i<nums.length;i++){
              if (!flagArray[i]) {
                  listChoice.add(nums[i]);
                  flagArray[i] = true;
                  recursion(nums, listChoice, flagArray);
                  //  状态重置，
                  flagArray[i] = false;
                  listChoice.removeLast();
              }
          }
    }

    public static void main(String[] args) {
        PamutationsII p = new PamutationsII();
        List list = p.permuteUnique(new int[]{1,1,2});
        System.out.println(list);
    }
}

class  func2{

    public List<List<Integer>> results = new LinkedList<>();
    //public Set<List<Integer>>  re = new HashSet<>();


    public List<List<Integer>> permuteUnique(int[] nums) {

        int length = nums.length;
        if (length==0){
            return results;
        }
        //建立标志数组
        boolean[] flag = new boolean[length];

        LinkedList<Integer> listChoice = new LinkedList<>();
        Arrays.sort(nums);
        recursion(nums,listChoice,flag);

        //results = new LinkedList<>(re);
        return results;
    }


    public void recursion(int[] nums,LinkedList<Integer> listChoice,boolean[] flagArray){
        if (listChoice.size()==nums.length){
            results.add(new LinkedList<>(listChoice));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            //剪枝
            if (i>0&&nums[i]==nums[i-1]&& !flagArray[i - 1]){        // flagArray[i - 1]==false
                continue;
            }
            if (!flagArray[i]) {
                listChoice.add(nums[i]);
                flagArray[i] = true;
                recursion(nums, listChoice, flagArray);
                //  状态重置，
                flagArray[i] = false;
                listChoice.removeLast();
            }
        }
    }
}
