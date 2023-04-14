import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String s = "abckcabx";
        System.out.println(Solution.lengthOfLongestSubstring2(s));
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        String substring = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = substring.indexOf(c);
            if(index > -1){
                result = Math.max(substring.length(), result);
                substring = substring.substring(index+1);
            }
            substring += c;
        }
        return Math.max(substring.length(), result);
    }

    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        int n = s.length();
        int[] index = new int[128];

        for(int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while(!set.add(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}