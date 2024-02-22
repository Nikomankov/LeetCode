import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<List<String>> result;
    private static int size;

    public static void main(String[] args) {
        solveNQueens(5);
        printer();
    }

    //========================================================================================================
    //my solution
    public static List<List<String>> solveNQueens(int n) {
        size = n;
        result = new ArrayList<>(n);
        char[][] emptyBoard = createBoard();
        helper(emptyBoard, 0, 0);
        return result;
    }
    private static char[][] createBoard(){
        char[][] board = new char[size][size];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        return board;
    }

    private static void helper(char[][] board, int startRow, int qCounter){
        if(startRow > size || qCounter == size){
            if(qCounter == size){
                result.add(getResult(board));
            }
            return;
        }
        for(int row = startRow; row < size; row++){
            for(int col = 0; col < size; col++){
                if(isSafePosition(board, row, col)){
                    board[row][col] = 'Q';
                    qCounter++;
                    helper(board, row + 1, qCounter);
                    board[row][col] = '.';
                    qCounter--;
                }
            }
        }
    }

    private static List<String> getResult(char[][] board){
        List<String> result = new ArrayList<>(size);
        for(char[] row : board){
            result.add(String.valueOf(row));
        }
        return result;
    }

    private static boolean isSafePosition(char[][] board, int qRow, int qCol){
        //vertical
        for(int row = qRow; row >= 0; row--){
            if(board[row][qCol] == 'Q'){
                return false;
            }
        }
        //negative diagonal
        int row = qRow - 1;
        int col = qCol - 1;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        //positive diagonal
        row = qRow - 1;
        col = qCol + 1;
        while(row >= 0 && col < size){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    private static void printBoard(char[][] board){
        for(char[] row : board){
            System.out.println(String.valueOf(row));
        }
        System.out.println("------------");
    }

    //========================================================================================================
    //another solution

    public static List<List<String>> solveNQueens1(int n) {
        size = n;
        result = new ArrayList<>(size);

        char[][] emptyBoard = new char[size][size];
        for(char[] row : emptyBoard){
            Arrays.fill(row, '.');
        }
        helper1(emptyBoard, 0, 0, 0, 0);
        return result;
    }

    private static void helper1(char[][] board, int row, int cols, int diags, int antiDiags){
        if(row == size){
            result.add(converter(board));
            return;
        }
        for(int col = 0; col < size; col++){
            int currDiag = row - col + size;
            int currAntiDiag = row + col;

            if((cols & (1 << col)) != 0 ||
                    (diags & (1 << currDiag)) != 0 ||
                    (antiDiags & (1 << currAntiDiag)) != 0
            ){
                continue;
            }

            board[row][col] = 'Q';
            cols |= (1 << col);
            diags |= (1 << currDiag);
            antiDiags |= (1 << currDiag);

            helper1(board, row + 1, cols, diags, antiDiags);

            board[row][col] = '.';
            cols ^= (1 << col);
            diags ^= (1 << currDiag);
            antiDiags ^= (1 << currAntiDiag);
        }
    }

    private static List<String> converter(char[][] board){
        List<String> newBoard = new ArrayList<>();
        for(char[] row : board){
            newBoard.add(new String(row));
        }
        return newBoard;
    }
    //========================================================================================================
    //another solution

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; ++i)
            Arrays.fill(board[i], '.');

        dfs(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], board, ans);
        return ans;
    }

    private void dfs(int n, int i, boolean[] cols, boolean[] diag1, boolean[] diag2, char[][] board,
                     List<List<String>> ans) {
        if (i == n) {
            ans.add(construct(board));
            return;
        }

        for (int j = 0; j < cols.length; ++j) {
            if (cols[j] || diag1[i + j] || diag2[j - i + n - 1])
                continue;
            board[i][j] = 'Q';
            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
            dfs(n, i + 1, cols, diag1, diag2, board, ans);
            cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;
            board[i][j] = '.';
        }
    }

    private List<String> construct(char[][] board) {
        List<String> listBoard = new ArrayList<>();
        for (int i = 0; i < board.length; ++i)
            listBoard.add(String.valueOf(board[i]));
        return listBoard;
    }

    //========================================================================================================

    private static void printer(){
        StringBuilder builder = new StringBuilder("Results");
        for (List<String> board : result){
            builder.append("\n\t--Board--");
            for(String row : board){
                builder.append("\n\t");
                for(char c : row.toCharArray()){
                    builder.append(c).append(' ');
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}