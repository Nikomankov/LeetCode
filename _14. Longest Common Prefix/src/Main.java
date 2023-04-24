import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower","flow","flight"};
        System.out.println(Solution.longestCommonPrefix1(strs1));

        String[] strs2 = new String[]{"dog","dracecar","dcar"};
        System.out.println(Solution.longestCommonPrefix1(strs2));

        String[] strs3 = new String[]{"ab", "a"};
        System.out.println(Solution.longestCommonPrefix1(strs3));
    }
}

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return result.toString();
            }
            result.append(first.charAt(i));
        }
        return result.toString();
    }

    public static String longestCommonPrefix1(String[] strs) {
        StringBuilder result = new StringBuilder(strs[0]);
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(result.toString()) != 0){
                result.deleteCharAt(result.length()-1);
            }
        }
        return result.toString();
    }
}