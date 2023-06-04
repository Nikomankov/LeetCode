import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        char[][] correctBoard = new char[][]{   {'5','3','.','.','7','.','.','.','.'},
                                                {'6','.','.','1','9','5','.','.','.'},
                                                {'.','9','8','.','.','.','.','6','.'},
                                                {'8','.','.','.','6','.','.','.','3'},
                                                {'4','.','.','8','.','3','.','.','1'},
                                                {'7','.','.','.','2','.','.','.','6'},
                                                {'.','6','.','.','.','.','2','8','.'},
                                                {'.','.','.','4','1','9','.','.','5'},
                                                {'.','.','.','.','8','.','.','7','9'}};

        char[][] incorrectBoard = new char[][]{ {'8','3','.','.','7','.','.','.','.'},
                                                {'6','.','.','1','9','5','.','.','.'},
                                                {'.','9','8','.','.','.','.','6','.'},
                                                {'8','.','.','.','6','.','.','.','3'},
                                                {'4','.','.','8','.','3','.','.','1'},
                                                {'7','.','.','.','2','.','.','.','6'},
                                                {'.','6','.','.','.','.','2','8','.'},
                                                {'.','.','.','4','1','9','.','.','5'},
                                                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(Solution.isValidSudoku(correctBoard));
        System.out.println(Solution.isValidSudoku(incorrectBoard));
        System.out.println(6%3);
    }
}

class Solution {
    public static boolean isValidSudoku(char[][] board) {
        Set check = new HashSet();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    String string = "(" + board[i][j] + ")";
                    if(!check.add(string + i) || !check.add(j + string) || !check.add(i/3 + string + j/3)) return false;
                }
            }
        }
        return true;
    }
}