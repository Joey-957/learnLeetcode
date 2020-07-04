package src.SwordOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 1.本题不能使用暴力方法做，因为 输入SEE ，因为从 S 到 E 有两条路，其中一条是死路
 * 2.建立标志位可以使用marked【】【】，但是board数组只有字符，
 * 3.需要使用回溯
 */
public class Sword12 {
    public static void main(String[] args) {
        char[][] bordS = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        new Sword12().exist(bordS, "ABCCEDASF");
    }


    //暴力破解法,选取什么 作标志位？  建立同样大小的marked数组
    public boolean exist(char[][] board, String word) {
        //boolean flag = false;
        char[] words = word.toCharArray();
        if (words.length == 0) {
            return false;
        }
        int y = board.length;
        int x = board[0].length;
        int index_X = -1, index_Y = -1;
        int[][] marked = new int[y][x];
        //int count = 0;                // 记录多少个字符已经被识别

        for (int i = 0; i < y - 1; i++) {        //找到字符串第一个字符的顺序了
            for (int j = 0; j < x - 1; j++) {
                if (board[i][j] == words[0]) {
                    index_X = i;
                    index_Y = j;
                    marked[i][j] = -1;
                    //count++;
                    break;
                }
            }
            if (index_X != -1) {
                break;
            }
        }
        int m;
        for (m = 1; m < words.length - 1; m++) {
            if (index_X - 1 > 0 && board[index_X - 1][index_Y] == words[m] && marked[index_X - 1][index_Y] != -1) {
                index_X--;
                marked[index_X][index_Y] = -1;
                //count++;
                continue;
            }
            if ((index_X + 1) < x - 1 && board[index_X + 1][index_Y] == words[m] && marked[index_X + 1][index_Y] != -1) {
                index_X++;
                marked[index_X][index_Y] = -1;
                continue;
            }
            if (index_Y - 1 > 0 && board[index_X][index_Y - 1] == words[m] && marked[index_X][index_Y - 1] != -1) {
                index_Y--;
                marked[index_X][index_Y] = -1;
                continue;
            }
            if (index_Y + 1 < y - 1 && board[index_X][index_Y + 1] == words[m] && marked[index_X][index_Y + 1] != -1) {
                index_Y++;
                marked[index_X][index_Y] = -1;
                continue;
            }
            return false;
        }

        return true;
    }
}

/**
 * 使用回溯法，重新做该题，7.2
 * <p>
 * 还是不行
 */
//class rightHuisufa{
//
//    public boolean flag = false;
//    //public boolean[][] visited = null;
//    public List<Character> select = null;      // 选择列表
//
//    //jianzhi
//
//
//    public boolean exist(char[][] board, String word) {
//        char[] words = word.toCharArray();
//        int length = words.length;
//        if (length==0){
//            return false;
//        }
//        select = new LinkedList<>();     // 初始化选择数组
//        int m = board.length;
//
//        int n = board[0].length;
//
//        //visited = new boolean[m][n];   // 标志位数组
//
//        return recursion(board,words,m,n);
//        //return flag;
//    }
//
//    public boolean recursion(char[][] board,char[] words,int m,int n){   // m，n 固定不变
//        if (select.size()==words.length){
//                return true;
//        }
//
//
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                 if (board[i][j]==words[])
//            }
//        }
//    }
//
//
//
//}


class answer {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';          // 如果匹配字符串中有‘/’ 会出错，所以可以使用‘ ’代替

        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }


}