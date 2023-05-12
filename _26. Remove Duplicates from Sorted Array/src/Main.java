public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[]{0,0,1,1,1,1,1,1,1,1};
        System.out.println(Solution.removeDuplicates(nums));


    }
}

class Solution {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return nums.length;

        int i = 0;
        int j = 1;

        while (i+j < nums.length){
            if(nums[i]>=nums[i+j]) j++;
            else {
                nums[i+1] = nums[i+j];
                i++;
            }
        }
        return i+1;
    }

    public static int removeDuplicates1(int[] nums) {
        int i =0;
        for(int j=0; j<nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }
}