public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] matrix1 = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };

        int[][] expected = new int[][]{
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };
//        int[][] largeMatrix = matrixGenerator(20);
        mirrorRotate(matrix1);
        printer(matrix1);


    }

    /*

                ------------------------------
       level 0__|_0,0   0,1   0,2   0,3   0,4 |     n = 4
                |     -------------------     |
       level 1__|_1,0_|_1,1   1,2   1,3 | 1,4 |     n = 3
                |     |      -----      |     |
       level 2__|_2,0_|_2,1_|_2,2 | 2,3 | 2,4 |     n = 2
                |     |      -----      |     |
                | 3,0 | 3,1   3,2   3,3 | 3,4 |
                |     -------------------     |
                | 4,0   4,1   4,2   4,3   4,4 |
                -------------------------------

                4 coordinates for change
                int cof = j - i
                 --->matrix[i][j]-----
                 |                   |
                 |                   v
           matrix[n-cof][i]       matrix[j][n]
                 ^                   |
                 |                   |
                 ---matrix[n][n-cof]<---

     */

    //my solution
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int levels = n/2;
        n = n - 1;
        //matrix levels
        for(int i = 0; i < levels; i++){
            for(int j = i; j < n; j++){
                int cof = j - i;
                int cacheVal1 = matrix[j][n];
                matrix[j][n] = matrix[i][j];
                int cacheVal2 = matrix[n][n-cof];
                matrix[n][n-cof] = cacheVal1;
                cacheVal1 = matrix[n- cof][i];
                matrix[n-cof][i] = cacheVal2;
                matrix[i][j] = cacheVal1;
            }

            //decrease length for next level
            n--;
        }
    }
    public static void mirrorRotate(int[][] matrix){
        int t;
        int n = matrix.length;
        //diagonal mirror
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        //vertical mirror
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                t = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = t;
            }
        }
    }

    private static int[][] matrixGenerator(int n){
        int[][] matrix = new int[n][n];
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = ++count;
            }
        }
        return matrix;
    }
    private static void printer(int[][] matrix){
        StringBuilder builder = new StringBuilder("\nResult: \n");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                builder.append(j == 0 ? "\t" : "")
                        .append(matrix[i][j])
                        .append(j != matrix.length - 1 ? ", " : "\n");
            }
        }
        System.out.println(builder);
    }
}