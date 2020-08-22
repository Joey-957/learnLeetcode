package src.exe.BliBli;

import com.sun.org.apache.xpath.internal.operations.String;
import src.Huisu.Pamutations;

import java.util.LinkedList;
import java.util.List;

public class Main1 {


    public List<List<Integer>> listAll = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> listIn = new LinkedList<>();
        recursion(nums, listIn);

        return listAll;
    }

    public void recursion(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            listAll.add(new LinkedList<>(list));  // 注意的点： 把list以此为元素内容，再建一个new LinkedList（List list）。
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            recursion(nums, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {



        int[] array = new int[]{1, 2, 3};
        src.Huisu.Pamutations p = new src.Huisu.Pamutations();

        System.out.println(p.permute(array).toString());
        System.out.println(p.listAll.toString());
    }

}
