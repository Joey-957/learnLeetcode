package src.exe.BliBli;

import java.util.LinkedList;

public class Main2 {

    public boolean Game24Points (int[] arr) {
        // write code here
        LinkedList<Integer> listIn = new LinkedList<>();
        recursion(arr,listIn);
        if (listIn.size()==4){
            return true;
        } else{
            return false;
        }
        //return listAll;
    }
    public void recursion(int[] arr,LinkedList listIn){
        if (listIn.size()==4){
            return;
        }
        for (int i=0;i<4;i++){
            for (int j =i;j<4;j++){

            }
        }

    }
}
