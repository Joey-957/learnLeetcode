本文件夹记录剑指offer的习题

    面试题03. 数组中重复的数字:
    面试题04. 二维数组中的查找
         05. 替换字符串中的空格                收获：String string = new String（char[] array,0,size）,后两个参数是index，起始终止位置
         06. 以数组的形式输出一个链表逆序       使用栈
         
         07. 前序遍历+中序遍历重构二叉树         前序遍历+后序遍历 不能行,但是仅仅知道BST的先序遍历或者后续就能构造BST 因为BST的中序遍历是递增序列
                                                                                        
             后序遍历+中序遍历重构二叉树 
         09. 用两个栈实现队列
         
         
         
         42. ###全排列                      收获 String 和 基本数据类型重写了方法toString，
                                           char[]数组需要转换成字符串形式使用函数：String str = String.valueOf(char[] array);
                                                    //输出是：  abc
                                                   char[] chars = new char[]{'a','b','c'};
                                                   System.out.println(new String(chars));
                                              
                                           int[]数组转换成字符串形式： int[] array = new int[]{1,2,3};
                                                                    System.out.println(Arrays.toString(array));
                                                                    // 输出是 ：[1, 2, 3] ,即字符串的形式打印数组 
                                                                    
         53. 有序遍历即二分                   排序数组搜索问题应该联想到使用二分法或者双指针    
         
         54. BST 有序二叉树的遍历                :  BST的先序遍历是从小到大排序的           
         
         56. 数组中数字出现的次数              ：使用异或 ^，异或的性质： 
                                                                    1. 任何数与0异或运算，结果都是本来的数
                                                                    2. 任何数与自身做异或运算，a ^ a 都是 0
                                                                    3. 异或满足交换律和结合律，  即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^0= b ;a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
                                                                                     
         58. 对字符串的处理：                   1. StringBuilder sb;  sb.append("abc")  :完成字符串的拼接   
                                             2. String.trim(): 除去字符串两端的空格   
                                             3. sb.sppend(S,indexStart,indexEnd+1); // 拼接S的子串，从【indexStart，indexEnd】到 indexEnd +1 结束    
                                                                                                                      