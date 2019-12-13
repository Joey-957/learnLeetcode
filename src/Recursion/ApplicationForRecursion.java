package Recursion;

/**
 * 一些递归应用，计算一个数的乘方、背包问题、登山队员选择问题
 */
public class ApplicationForRecursion {

    //背包数组
    private int[] array = new int[]{11,9,7,6,5};
    private boolean[] select = new boolean[5];
    //挑选队员的数组
    private char[] persons = new char[]{'a','b','c','d','e'};
    private boolean[] selectTeam = new boolean[5];

    //计算一个数的乘方，x的偶数平方直接带入，x的基数次方例如x的三次方，返回x*x的平方
    private int power(int x,int y){
        if (y==1){
            return x;
        }
        if(y%2==0){
            return power(x,y/2)*power(x,y/2);
        }else{
            return x*power(x,y/2)*power(x,y/2);
        }
    }

    //背包问题
    private void backpack(int total,int index){
        int length = array.length;
        if(total<0||total>0&&index>=length){
            return;
        }
        if (total==0){
            for (int i = 0;i<index;i++){
                if(select[i]){
                    System.out.println(array[i]+"");
                }
            }
            return;
        }
        select[index] = true;
        backpack(total-array[index],index+1);
        select[index] = false;
        backpack(total,index+1);
    }

    //登山选队员问题
    private void combination(int teamNuber,int index){
        if (teamNuber == 0){
            for (int i = 0;i<persons.length;i++){
                System.out.println(persons[i]);
            }
            System.out.println();
            return;
        }
        if(index>=persons.length){
            return;
        }
        select[index] = true;
        combination(teamNuber-1, index+1);
        select[index] = false;
        combination(teamNuber,index+1);
    }

    /**
     * 在数学中，组合是对事物的一种选择，而不考虑他们的顺序。
     * 比如有5个登山队员，名称为 A,B,C,D和E。想要从这五个队员中选择三个队员去登峰，这时候如何列出所有的队员组合。（不考虑顺序）
     * n个人中挑选k个人
     */
    private void selectTeam(int n,int k){

    }

    public static void main(String[] argus){
        ApplicationForRecursion one = new ApplicationForRecursion();
        System.out.println(one.power(2,5));
        //背包问题
        one.backpack(20,0);
        //选队员
        //one.combination(2,0);

    }

}
