import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(Solution.isValid(s));
    }
}

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if ((c == ')' && stack.peek() == '(')
                        || (c == '}' && stack.peek() == '{')
                        || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty();
    }
}