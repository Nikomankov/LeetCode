import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] nums = {
                {1,2,0},
                {3,4,-1,1},
                {7,8,9,11,12}
        };
        int[] result = {3,2,1};
        printer(nums,result);
    }

    //========================================================================================================
    //my solution
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min) min++;
        }
        return min;
    }

    //========================================================================================================
    //best time solution
    public static int firstMissingPositiveByTime(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i] -= 1;
        }
        for(int i=0;i<nums.length;i++){
            int val = nums[i];

            if(val<0 || val>=n){
                continue;
            }

            //sort array
            while( nums[i]>=0 && nums[i]<n &&nums[i] != nums[nums[i]]){
                int idx = nums[i];
                nums[i] = nums[idx];
                nums[idx] = idx;
            }

        }

        for(int i=0;i<n;i++){
            if(nums[i]!= i){
                return i+1;
            }
        }

        return (n+1);
    }

    //========================================================================================================
    //best memory solution
    public int firstMissingPositiveByMemory(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // Swap the current element with its correct position
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                System.gc();
                return i + 1;
            }
        }
        System.gc();
        return nums.length + 1;

    }

    //========================================================================================================
    public static void printer(int[][] nums, int[] results){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < results.length; i++){
            int result = firstMissingPositiveByTime(nums[i]);
            builder.append("test: ").append(i).append("\n")
                    .append("output: ").append(result).append(" - ").append(result==results[i]).append("\n\n");
        }
        System.out.println(builder);
    }
}