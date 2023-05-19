public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
//        int[] nums = new int[]{1,5,2,4,3};  //1,5,3,2,4
//        int[] nums = new int[]{1,5,4,3,2};  //2,1,3,4,5
//        int[] nums = new int[]{1,1,5};      //1,5,1
//        int[] nums = new int[]{1,5,1};      //1,1,5
//        nums[1] = nums[1]^nums[2]^(nums[2] = nums[1]);

        Solution.nextPermutation(nums);
    }
}

class Solution {
    public static void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int length = nums.length;
        int e;
        int start = 0;
        for(int i = length-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                if(i-1 == 0 && nums[length-1]<=nums[i-1]){
                    e = nums[i];
                    nums[i] = nums[i-1];
                } else {
                    e = nums[length-1];
                    nums[length-1] = nums[i-1];
                }
                nums[i-1] = e;
                start = i;
                printArray(nums);
                break;
            }
        }
        //reverse
        int end = nums.length-1;
        if(start!=end){
            for(int j = start; j <= end; j++, end--){
                e = nums[end];
                nums[end] = nums[j];
                nums[j] = e;
                printArray(nums);
            }
        }
        printArray(nums);
    }

    //-------------------------------------------------------------------

    public static void nextPermutation1(int[] nums) {
        int start = -1;
        int end = -1;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                start = i;
                break;
            }
        }
        if(start == -1){
            reverse(nums,0);
        } else {
            for(int i = nums.length-1; i >= 0; i--){
                if(nums[i] > nums[start]){
                    end = i;
                    break;
                }
            }
            swap(nums,start,end);
            reverse(nums,start+1);
        }
    }

    private static void swap(int[] nums,int i,int j){
        int e = nums[i];
        nums[i] = nums[j];
        nums[j] = e;
    }

    private static void reverse(int[] nums,int start){
        int i = start;
        int j = nums.length-1;
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void printArray(int[] nums){
        for(int i : nums){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}