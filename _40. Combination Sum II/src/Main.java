import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] candidates = {
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {10,1,2,7,6,1,5},
                {2,5,2,1,2}
        };
        int[] targets = {30,8,5};

        printer(candidates,targets);
    }

    //========================================================================================================
    //my solution

    public static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        handler(0,candidates,target, new ArrayList<>());
        return result;
    }

    public static void handler(int index, int[] candidates, int target, List<Integer> currentList){
        if(target<0) return;
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for(int i = index; i < candidates.length && candidates[i] <= target; i++){
            if(i != index && candidates[i] == candidates[i-1]) continue;
            currentList.add(candidates[i]);
            handler(i+1, candidates, target-candidates[i], currentList);
            currentList.remove(currentList.size()-1);

        }
    }


    //========================================================================================================
    //best time solution
    public List<List<Integer>> combinationSum2ByTime(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            @Override
            public int size() {
                init();
                return result.size();
            }
            @Override
            public List<Integer> get(int index) {
                init();
                return result.get(index);
            }
            protected void init() {
                if (result != null)
                    return;
                result = new ArrayList<>();
                Arrays.sort(candidates);
                dfsHelper(candidates, target, 0, new LinkedList<>(), result);
            }
        };
    }
    private void dfsHelper(int[] candidates, int target, int start, List<Integer> combination,         List<List<Integer>> result) {
        if(target < 0) return;
        else if(target == 0) {
            result.add(new LinkedList<>(combination));
        } else {
            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i - 1]) continue;

                combination.add(candidates[i]);
                dfsHelper(candidates, target - candidates[i], i + 1, combination, result);
                combination.remove(combination.size() - 1);

            }
        }

    }


    //========================================================================================================
    private static void printer(int[][] candidates, int[] targets){
        for(int i = 0; i < targets.length; i++){
            List<List<Integer>> result = combinationSum2(candidates[i],targets[i]);
            StringBuilder builder = new StringBuilder("test ").append(i+1).append(":")
                                            .append("\n   target: ").append(targets[i])
                                            .append("\n   output: ");
            if(result.size()>0){
                builder.append("[\n");
                for(int l = 0; l < result.size(); l++){
                    List<Integer> list = result.get(l);
                    for(int c = 0; c < list.size(); c++){
                        if(c==0) builder.append("            [");
                        builder.append(list.get(c))
                                .append(c!=list.size()-1 ? "," : "]");
                    }
                    builder.append(l!= result.size()-1 ? ",\n" : "\n           ]\n");
                }
            } else builder.append("empty");

            System.out.println(builder);
        }
    }
}