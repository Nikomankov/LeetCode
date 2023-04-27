import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String digits = "23";
        Solution.letterCombinations(digits).forEach(d -> System.out.println(d+", "));
    }
}


class Solution {
    static String[] buttons = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> result = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return result;
        generator(digits,"",0);
        return result;
    }

    public static void generator(String digits, String prevCombinations, int index){
        if(digits.length() == prevCombinations.length()){
            result.add(prevCombinations);
        } else {
            String digitString = buttons[Character.getNumericValue(digits.charAt(index))-2];
            for(int i = 0; i<digitString.length(); i++) generator(digits,prevCombinations+digitString.charAt(i),index+1);
        }
    }

    static Map<Character,String> map = new HashMap<>(9);
    public static List<String> letterCombinations1(String digits) {
        if(digits.length() == 0) return result;
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        generator1(digits, "",0);

        return result;
    }

    public static void generator1(String digits, String prevCombinations, int index){
        if(digits.length() == prevCombinations.length()){
            result.add(prevCombinations);
        } else {
            String digitString = map.get(digits.charAt(index));
            for(int i = 0; i<digitString.length(); i++) generator(digits,prevCombinations+digitString.charAt(i),index+1);
        }
    }


}