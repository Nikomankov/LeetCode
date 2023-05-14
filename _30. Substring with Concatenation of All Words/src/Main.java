import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = new String[]{"foo","bar"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","word"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = new String[]{"bar","foo","the"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","good"};
        String s = "aabbccaa";
        String[] words = new String[]{"aa","bb"};
//        String s = "ababababab";
//        String[] words = new String[]{"ababa","babab"};

        Solution.findSubstring(s,words).forEach(e -> System.out.print(e + ", "));
    }
}

class Solution {

    public static List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        char[] sArray = s.toCharArray();
        for (String value : words) {
            map.putIfAbsent(value, map.size());
        }
        int[] count = new int[map.size()];
        for (String word : words) {
            count[map.get(word)]++;
        }
        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j <= s.length() - totalWordsLength; j += wordLength) {
                int[] localCount = new int[map.size()];
                for (int k = j + totalWordsLength - wordLength; k >= j; k -= wordLength) {
                    String str = new String(sArray, k, wordLength);
                    Integer key = map.get(str);
                    if (!(key != null && count[key] >= ++localCount[key])) {
                        j = k;
                        break;
                    }
                    if (j == k) {
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }
}