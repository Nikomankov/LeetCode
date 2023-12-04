import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<List<Integer>> global;

    public static void main(String[] args) {

        int[][] candidates = {
                {2,3,6,7},
                {2,3,5},
                {2}
        };
        int[] targets = {7,8,1};
        printer(candidates,targets);

    }


    //my solution
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        global = new ArrayList<>();
        candidates = Arrays.stream(candidates).filter(c -> c<=target).sorted().toArray();
        handler1(new ArrayList<>(), candidates, target);
        return global;
    }

    public static void handler1(List<Integer> result, int[] candidates, int target){
        for(int i = 0; i < candidates.length; i++){
            Integer c = candidates[i];
            if(target < c || (result.size() != 0 && c < result.get(result.size()-1))) continue;
            target -= c;
            result.add(c);
            if(target > 0) {
                handler1(result, candidates, target);
            } else
                if(target == 0){
                    global.add(new ArrayList<>(result));
                }
            result.remove(c);
            target+=c;
        }
    }

    //========================================================================================================
    //best time solution
    public List<List<Integer>> combinationSumByTime(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        findCombination(0, target, candidates, currentSubset, result);
        return result;
    }

    public static void findCombination(int index, int target, int[] candidates, List<Integer> currentSubset, List<List<Integer>> result) {
        // checks if we have explored all the elements of array
        if(index == candidates.length) {
            if(target == 0) {
                result.add(new ArrayList<>(currentSubset));
            }
            return;
        }

        if(candidates[index] <= target) {
            currentSubset.add(candidates[index]);

            // After adding the element of curr index, iterate the left path until the base condition is met
            findCombination(index, target - candidates[index], candidates, currentSubset, result);

            // this is required because when the above recursion call
            // is executed then the Data structure still has curr index element so we need to remove it
            currentSubset.remove(currentSubset.size() - 1);
        }

        // check for the next element of array
        findCombination(index + 1, target, candidates, currentSubset, result);
    }

    //========================================================================================================
    //best memory solution
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combinationSumByMemory(int[] candidates, int target) {
        makeCombs(new ArrayList<>(), candidates, 0, target, 0);
        System.gc();
        return combinations;
    }

    private void makeCombs(List<Integer> comb, int[] nums, int sum, int target, int idx) {
        if (sum == target) {
            combinations.add(new ArrayList<>(comb));
        } else {
            for (int i = idx; i < nums.length; i++) {
                if (sum + nums[i] <= target) {
                    comb.add(nums[i]);
                    makeCombs(comb, nums, sum + nums[i], target, i);
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }

    public static void printer(int[][] candidates, int[] targets){
        for(int i = 0; i < targets.length; i++){
            List<List<Integer>> result = combinationSum(candidates[i], targets[i]);
            StringBuilder str = new StringBuilder();
            if(result.size()>0){
                str.append("[");
                for(List<Integer> list : result){
                    str.append("[");
                    for(Integer n : list){
                        str.append(n).append(", ");
                    }
                    str = str.delete(str.length()-2,str.length());
                    str.append("], ");
                }
                str = str.delete(str.length()-2,str.length());
                str.append("]");
            } else str.append("empty");

            System.out.println("test " + i + ": \n   target: " + targets[i] + "\n  output: " + str);
        }
    }
}