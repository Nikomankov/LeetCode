package org.example;

public class Main {
    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target = 6;
        int[] result = Solution.twoSum1(nums,target);
        System.out.println(result[0] + ", " + result[1]);
    }
}

class Solution {

    public static int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    public static int[] twoSum2(int[] nums, int target) {
        int l=nums.length;
        int i = 0;
        int step = 1;
        while (i < l){
            if(i+step >= l){
                step++;
                i=0;
                continue;
            } else if(nums[i]+nums[step+i]==target){
                return new int[]{i,i+step};
            }
            i++;
        }
        return new int[0];
    }
}