package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String s = "MCMXCIV";
        System.out.println(Solution.romanToInt1(s));
    }

}

class Solution{
    public static int romanToInt1(String s){
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        return new String(s.replace("IV","IIII").replace("IX","VIIII")
                .replace("XL","XXXX").replace("XC","LXXXX")
                .replace("CD","CCCC").replace("CM","DCCCC")
                .toCharArray())
                .chars()
                .mapToObj(i -> (char) i)
                .map(c -> map.get(c))
                .reduce(Integer::sum).get();
    }

    public static int romanToInt2(String s){
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        ArrayList<Integer> intList = new ArrayList<>();
        for(char c : s.toCharArray()){
            intList.add(map.get(c));
        }
        for(int i = intList.size()-1; i >= 0; i--){
            int n = intList.get(i);
            if(i != 0){
                if(n > intList.get(i-1)){
                    result += n-intList.get(i-1);
                    i--;
                } else result += n;
            } else result += n;
        }
        intList.forEach(System.out::println);
        return result;
    }

    public static int romanToInt3(String s){
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for(int i = 0; i < s.length(); i++){
            if(i+1 < s.length()){
                if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                    result -= map.get(s.charAt(i));
                } else result += map.get(s.charAt(i));
            } else result += map.get(s.charAt(i));
        }
        return result;
    }
}