public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{6,7,0,1,2,3,4,5};
//        int[] nums = new int[]{5,1,3};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1,3};
//        int[] nums = new int[]{3,1};
//        int[] nums = new int[]{1,3,5};
        System.out.println(Solution.search(nums,0));
    }
}

class Solution {
    public static int search(int[] nums, int target) {

        int first = 0;
        int last = nums.length-1;
        int middle;
        //find index with min int
        while(last-first > 1){
            middle = (first + last)/2;
            if(nums[middle] < nums[last]) last = middle;
            else first = middle;
        }
        middle = nums[first] < nums[last] ? first : last;

        //define search area
        first = 0;
        last = nums.length-1;
        if(nums[last] < target) last = middle - 1;
        else first = middle;

        //find target index
        while (first<=last){
            middle = (first + last)/2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                first = middle + 1;
            } else if (nums[middle] > target){
                last = middle - 1;
            }
        }
        return -1;
    }
}