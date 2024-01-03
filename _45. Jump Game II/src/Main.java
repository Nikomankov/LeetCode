public class Main {
    public static void main(String[] args) {

        int[][] arrays = new int[][]{
                {10,9,8,7,6,5,4,3,2,1,1,0},
                {5,9,3,2,1,0,2,3,3,1,0,0},
                {1,1,1,1},
//                {1,0,1,2,30,4},
                {3,5,12,67,9,2,0},
                {2,3,1,1,4},
                {2,3,0,1,4}

        };

        for(int[] a : arrays){
            System.out.println(jump(a));
        }
    }


    //========================================================================================================
    //my solution
    public static int jump(int[] nums) {
        int steps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++steps;
                break;
            }
            if (i == end) {
                ++steps;
                end = farthest;
            }
        }

        return steps;
    }
}