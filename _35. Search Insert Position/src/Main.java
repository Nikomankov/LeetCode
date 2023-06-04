public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(Solution.searchInsert(nums,3));  //1
        System.out.println(Solution.searchInsert(nums,2));  //1
        System.out.println(Solution.searchInsert(nums,7));  //4
        System.out.println(Solution.searchInsert(nums,0));  //0
        System.out.println(Solution.searchInsert(nums,4));  //2
    }
}

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        int middle;

        while (first<=last){
            middle = (first + last)/2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) last = middle - 1;
            else first = middle + 1;
        }

        return first;
    }
}