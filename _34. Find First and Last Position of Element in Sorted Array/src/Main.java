public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
//        int[] nums = new int[]{2,2};
        for(int i : Solution.searchRange(nums,10)){
            System.out.print(i + ", ");
        }
    }
}

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums.length != 0){
            int first = 0;
            int last = nums.length-1;
            int middle;
            while(first<=last){
                middle = (last+first)/2;
                if(nums[middle] == target) {
                    first = middle;
                    last = middle;

                    while(first >= 0 && nums[first] == target){
                        first--;
                    }
                    while(last < nums.length && nums[last] == target){
                        last++;
                    }

                    result[0] = first+1;
                    result[1] = last-1;
                    break;
                } else if(nums[middle] < target) first = middle + 1;
                else last = middle -1;
            }
        }
        return result;
    }
}