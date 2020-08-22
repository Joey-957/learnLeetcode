package src.exe;

public class MainSC {
    public static void main(String[] args) {

    }
    public static int func(int[] arr){
        if (arr == null){
            return -1;
        }
        if (arr.length ==1){
            return 1;
        }
        int p = 0;
        int q = 1;
        while(q < arr.length){
            if (arr[p] != arr[q]){
                arr[p++] = arr[q];
                q++;
            }else{
                q++;
            }
        }
        return p+1;
    }


    public static int funtion(int[] arr){
        if (arr == null){
            return -1;
        }
        if (arr.length ==1){
            return 1;
        }
        int pre = arr[0];
        //boolean
        for (int i=1;i<arr.length;i++){
            for(int j =i;j<arr.length;j++){
                if (arr[j]!=pre){
                    pre = arr[j];
                    break;
                }else{
                    while(j<arr.length){
                        if(arr[j]!=pre){
                            break;
                        }
                        j++;
                    }

                }
            }

        }
        return 0;
    }
}
class HelloWold{
    public static final String playGame = new String("ABC");
}
