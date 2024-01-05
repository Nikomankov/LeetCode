import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {1,2,3},
//                {0,1},
//                {1},
                {5,4,2,2}
//                {10,2,10,3,4,5}
        };
        int[] expectedArrayCount = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            expectedArrayCount[i] = factorial(nums[i].length);
        }

        for(int j = 0; j < nums.length; j++){
            int[] n = nums[j];
            List<List<Integer>> result = permuteUnique(n);
            String inputArrStr = "";
            for(int i : n){
                inputArrStr += (i + ", ");
            }
            inputArrStr.substring(0,inputArrStr.length()-2);
            StringBuilder builder = new StringBuilder("\n=================================")
                    .append("\ninput: ").append(inputArrStr)
                    .append("\nexpected size: ").append(expectedArrayCount[j])
                    .append("\nactual size: ").append(result.size())
                    .append("\n\t");
            result.forEach(r -> {
                r.forEach(i -> builder.append(i).append(", "));
                builder.delete(builder.length()-2,builder.length()-1);
                builder.append("\n\t");
            });
            System.out.println(builder);
        }
    }

    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return result;
    }

    //========================================================================================================
    //my solution
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums,0, result);
        return result;
    }
    private static void permuteUnique(int[] nums, int start, List<List<Integer>> result) {

        if(start == nums.length) {
            List<Integer> current = new ArrayList<>();
            for(int i = 0; i < start; i++) {
                current.add(nums[i]);
            }
            result.add(current);
        }else {
            for(int i = start; i < nums.length; i++) {
                if(canSwap(nums,start,i)){
                    swap(start, i, nums);
                    permuteUnique(nums,start + 1,result);
                    swap(start, i, nums);
                }
            }
        }
    }

    private static void swap(int a, int b, int[] nums){
        if(a == b) return;
        int n = nums[b];
        nums[b] = nums[a];
        nums[a] = n;
    }

    private static boolean canSwap(int[] nums, int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (nums[i] == nums[curr]) {
                return false;
            }
        }
        return true;
    }




}