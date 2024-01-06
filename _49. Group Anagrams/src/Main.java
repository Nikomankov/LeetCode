import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        printer(groupAnagrams(strs));

    }


    //========================================================================================================
    //my solution
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = stringSorter(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            } else {
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(key,value);
            }
        }
        return map.values().stream().toList();
    }

    private static String stringSorter(String input){
        char[] array = input.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    //========================================================================================================
    //another one solution
    private static final int[] PRIMES = new int[]{ 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    public static List<List<String>> groupAnagramsAnotherOne(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for(String s :strs){
            Integer key = getWordKey(s);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    private static int getWordKey(String s){
        char[] chars = s.toCharArray();
        int res=2;
        for(char c:chars ){
            res *= PRIMES[c-97];
        }

        return res;
    }



    private static void printer(List<List<String>> result){
        StringBuilder builder = new StringBuilder();
        for(List<String> list : result){
            for(int i = 0; i < list.size(); i++){
                builder.append(i == 0 ? "\t" : "")
                        .append(list.get(i))
                        .append(i == list.size()-1 ? "\n" : ", ");
            }
        }
        System.out.println(builder);
    }
}