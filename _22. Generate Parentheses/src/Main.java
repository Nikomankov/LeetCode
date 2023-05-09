import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int n = 3;
        Solution.generateParenthesis(n).forEach(e -> System.out.print(e + ", "));


    }
}


class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursiveGenerator(result, "", n, n);
        return result;
    }

    public static void recursiveGenerator(List<String> result, String s, int left, int right){
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }
        if(left > 0){
            recursiveGenerator(result, s + "(", left - 1, right);
        }
        if(right > left){
            recursiveGenerator(result, s + ")", left, right - 1);
        }
    }
}