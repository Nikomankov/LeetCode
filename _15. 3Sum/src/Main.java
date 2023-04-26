import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums1 = new int[]{0,1,1};
        int[] nums2 = new int[]{0,0,0};
        int[] nums3 = new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        printSolution(nums);
        printSolution(nums1);
        printSolution(nums2);
        printSolution(nums3);
    }

    public static void printSolution(int[] nums){
        System.out.println("--------------------");
        Solution.threeSum(nums).forEach(l-> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }
}

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1, k = nums.length-1; j<k;){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) k--;
                else if (sum < 0) j++;
                else {
                    results.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (nums[j] == nums[j-1] && j<k) j++;
                }
            }
        }
        return results;
    }
}
