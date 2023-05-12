public class Main {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issipi";
//        String haystack = "a", needle = "a";
        System.out.println(Solution.strStr(haystack,needle));


    }
}

class Solution {
    public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        char[] array = haystack.toCharArray();
        int needLen = needle.length();

        for (int i = 0; i <= array.length - needLen; i++){
            int j = 0;
            while(j < needLen && array[i+j] == needle.toCharArray()[j]){
                j++;
            }
            if(j == needLen) {
                return i;
            }
        }
        return -1;
    }
}