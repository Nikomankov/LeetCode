import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        int[] nums1 = new int[]{2,2,2,2,2};
        int target1 = 8;
        int[] nums2 = new int[]{0,3,0,1,1,-1,-5,5,3,-3,-3,0};
        int target2 = 8;
        int[] nums3 = new int[]{0,3,0};
        int target3 = 8;
        int[] nums4 = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target4 = -294967296;
//        printSolution(nums,target);
//        printSolution(nums1,target1);
//        printSolution(nums2,target2);
//        printSolution(nums3,target3);
        printSolution(nums4,target4);
    }

    public static void printSolution(int[] nums, int target){
        System.out.println("--------------------");
        Solution.fourSum(nums, target).forEach(l-> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }
}

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j< nums.length-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                for(int k = j+1; k < nums.length-1; k++){
                    if(k>j+1 && nums[k] == nums[k-1]) continue;
                    for(int l = k+1; l < nums.length; l++){
                        if(l>k+1 && nums[l] == nums[l-1]) continue;
                        long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum == target){
                            results.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        }
                    }
                }
            }
        }

        return results;
    }
}