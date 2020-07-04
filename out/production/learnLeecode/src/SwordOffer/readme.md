本文件夹记录剑指offer的习题

    面试题03. 数组中重复的数字:
    面试题04. 二维数组中的查找
         05. 替换字符串中的空格                收获：String string = new String（char[] array,0,size）,后两个参数是index，起始终止位置
         06. 以数组的形式输出一个链表逆序       使用栈
         07. 前序遍历+中序遍历重构二叉树         前序遍历+后序遍历 不能行
             后序遍历+中序遍历重构二叉树 
         09. 用两个栈实现队列
         
         
         
         42. ###全排列                      收获 String 和 基本数据类型重写了方法toString，
                                           char[]数组需要转换成字符串形式使用函数：String str = String.valueOf(char[] array);
                                                    //输出是：  abc
                                                   char[] chars = new char[]{'a','b','c'};
                                                   System.out.println(new String(chars));
                                              
                                           int[]数组转换成字符串形式： int[] array = new int[]{1,2,3};
                                                                    System.out.println(Arrays.toString(array));
                                                                    // 输出是 ：[1, 2, 3]  
                                                                    
                                                                    