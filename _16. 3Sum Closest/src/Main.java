import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<int[]> nums = new ArrayList<>();
        nums.add(new int[]{-1,2,1,-4});
        nums.add(new int[]{0,0,0});
        nums.add(new int[]{4,0,5,-5,3,3,0,-4,-5});
        nums.add(new int[]{0,0,0});
        nums.add(new int[]{0,1,2});
        int[] target = new int[]{1,1,-2,10000,0};
        int[] expected = new int[]{2,0,-2,0,3};

        for(int i = 0; i < nums.size(); i++){
            int result = Solution.threeSumClosest(nums.get(i),target[i]);
            System.out.println(result + " - " + (result == expected[i] ? "Match" : "Mismatch"));
        }

//        System.out.println(Solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));

    }
}

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1, k = nums.length-1; j<k;){
                int sum = nums[i] + nums[j] + nums[k];
                result = Math.abs(target - sum) < Math.abs(target-result) ? sum : result;
                if(sum == target) return target;
                else if (target - sum < 0) k--;
                else j++;
            }
        }
        return result;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int sum = nums[i] + twoSumClosest(nums, target - nums[i], i);
            if(ans == Integer.MIN_VALUE || Math.abs(sum - target) < Math.abs(ans - target)){
                ans = sum;
            }
        }
        return ans;
    }
    public int twoSumClosest(int[] nums, int k, int st){
        int si = st + 1;
        int ei = nums.length - 1;
        int ans = Integer.MIN_VALUE;
        while(si < ei){
            int sum = nums[si] + nums[ei];
            if(ans == Integer.MIN_VALUE || Math.abs(sum - k) < Math.abs(ans - k)){
                ans = sum;
            }
            if(sum == k){
                return sum;
            }else if(sum < k){
                si++;
            }else{
                ei--;
            }

        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        int res = 0;
        boolean wasRes = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (wasRes && Math.abs(res) > Math.abs(sum - target)) {
                        res = sum - target;
                    } else if (!wasRes) {
                        res = sum - target;
                        wasRes = true;
                    }
                }
            }
        }
        return target + res;
    }
}