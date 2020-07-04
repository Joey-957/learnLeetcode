本文记录leetcode中，借助数组来解决字符串问题的习题：
------------------------------------------------------
LeetCode_242：给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的字母异位词。（全小写字符）

    A思路：1.str1.length（）比较长度，不一致不是同位词
          2.String.toCharArray 转化成数组，经过Arrays.Sort()排序后 Array.equeal（str1,str2）,相等就是同位词。
    
    B思路：1.字符串s中的字符与‘a‘作差值，在对应int数组上累加一
          2.字符串t同样操作但是减一
          3.最终判断数组是不是均为零   