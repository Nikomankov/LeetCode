public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(Solution.removeElement(nums,2));

    }
}

class Solution {
    public static int removeElement(int[] nums, int val) {

        int i = 0;
        int j = 0;

        while (i+j < nums.length){
            if(nums[i+j] == val) j++;
            else {
                nums[i] = nums[i+j];
                i++;
            }
        }

        return i;
    }
}