import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[][] nums = new int[][]{
//                {1,2,3},
//                {0,1},
//                {1},
                {5,4,6,2}
//                {10,2,10,3,4,5}
        };
        int[] expectedArrayCount = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            expectedArrayCount[i] = factorial(nums[i].length);
        }

        for(int j = 0; j < nums.length; j++){
            int[] n = nums[j];
            List<List<Integer>> result = permute(n);
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

    //========================================================================================================
    //my solution
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>(Arrays.stream(num).boxed().toList());
        if(numList.size() == 1) {
            result.add(numList);
            return result;
        }
        handler(numList.size(),numList,result);


        return result;
    }

    public static void handler(int length, List<Integer> nums, List<List<Integer>> result) {

        if(length == 1) {
            result.add(List.copyOf(nums));
        } else {
            for(int i = 0; i < length-1; i++) {
                handler(length - 1, nums, result);
                if(length % 2 == 0) {
                    int n = nums.get(i);
                    nums.set(i, nums.get(length-1));
                    nums.set(length-1, n);
                } else {
                    int n = nums.get(0);
                    nums.set(0, nums.get(length-1));
                    nums.set(length-1, n);
                }
            }
            handler(length - 1, nums, result);
        }
    }

    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }

        return result;
    }

    //========================================================================================================
    //best time solution
    public static List<List<Integer>> permuteByTime(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<List<Integer>> compermute = compermute(nums,0,res);
        return compermute;
    }
    private static List<List<Integer>> compermute(int[] nums, int start, List<List<Integer>> res  ) {

        if(start==nums.length) {
            List<Integer>t = new ArrayList();
            for(int i=0;i<start;i++) {
                t.add(nums[i]);
            }
            res.add(t);
        }else {
            for(int i=start;i<nums.length;i++) {
                int temp = nums[i];
                nums[i]=nums[start];
                nums[start]=temp;
                compermute(nums,start+1,res);
                temp = nums[start];
                nums[start]=nums[i];
                nums[i]=temp;
            }
        }
        return res;
    }
}