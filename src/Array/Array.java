package Array;

/**
 * Array是无序数组，对数组进行检索、插入、删除、打印输出等操作，假设数组不存在重复数据
 */
public class Array {

    private String[] array;
    private int length = 0;//数组元组的个数

    public Array(int max){
        this.array = new String [max];
    }

    //检索数组是否存在某元素，存在返回数组下标，不存在返回-1
    public int select(String elem){
        int index = -1;
        for (int i=0;i<=length;i++){
            if(array[i].equals(elem)){
                index = i;
                break;
            }
        }
        return index;
    }

    //插入数据
    public void insert(String elem){
        array[length] = elem;
        length++;
    }

    //删除某项指定的元素，删除成功则返回true，否则返回false
    public Boolean delete (String target){
        int index = -1;
        if((index = select(target))!=-1){
            for(int i = index;i<length-1;i++){
               array[i] = array[i+1];
            }
        }else {
            return false;
        }
        return true;
    }

    public void display(){
        for(int i=0;i<=length;i++){
            System.out.println(array[i]);
        }
    }
}
