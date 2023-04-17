public class Main {
    public static void main(String[] args) {
        String s1 = "ccc";
        String s2 = "kjklmomlkjkuipjkkjpiuk";
        String s3 = "cbbd";
        String s4 = "aaaa";
        String s5 = "a";
        String s6 = "bbaaaa";
        System.out.println(Solution.longestPalindrome(s1));
        System.out.println(Solution.longestPalindrome(s2));
        System.out.println(Solution.longestPalindrome(s3));
        System.out.println(Solution.longestPalindrome(s4));
        System.out.println(Solution.longestPalindrome(s5));
        System.out.println(Solution.longestPalindrome(s6));
    }
}


class Solution {
    public static String longestPalindrome(String s) {
        String result = "";
        int length = s.length();
        char[] array = s.toCharArray();


        for(int i = 0; i<length; i++) {
            int l = i, m = i;

            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = s.substring(l, m+1);
                }
                l--;
                m++;
            }

            l = i;
            m = i + 1;
            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = s.substring(l, m+1);
                }
                l--;
                m++;
            }
        }

        return result;
    }
}