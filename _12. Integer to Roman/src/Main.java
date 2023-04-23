import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 58;
        int num3 = 1994;
        System.out.println(Solution.intToRoman1(num1));
        System.out.println(Solution.intToRoman1(num2));
        System.out.println(Solution.intToRoman1(num3));
    }
}


class Solution {
    public static String intToRoman(int num) {
        String result = "";
        HashMap<Integer,Character> map = new HashMap<>(7){};
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        int i = 1;
        while(num/i != 0){
            int o = num%(i*10)/i;
            if(o > 0) {
                if(o < 4) result = String.valueOf(map.get(i)).repeat(o) + result;
                else if(o == 4) result = map.get(i) + String.valueOf(map.get(i*5)) + result;
                else if(o == 9) result = map.get(i) + String.valueOf(map.get(i*10)) + result;
                else result = map.get(i*5) + String.valueOf(map.get(i)).repeat(o-5) + result;
            }
            i=i*10;
        }
        return result;
    }

    public static String intToRoman1(int num) {
        StringBuilder result = new StringBuilder();
        HashMap<Integer,Character> map = new HashMap<>(7){};
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        for(int i = 1000; i>=1; i=i/10){
            if(num/i == 0) continue;
            int o = num/i%10;
            if(o > 0) {
                if(o < 4) result.append(String.valueOf(map.get(i)).repeat(o));
                else if(o == 4) result.append(map.get(i)).append(map.get(i*5));
                else if(o == 9) result.append(map.get(i)).append(map.get(i*10));
                else result = result.append(map.get(i*5)).append(String.valueOf(map.get(i)).repeat(o-5));
            }
        }
        return result.toString();
    }

    public String intToRoman2(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M",  "CM", "D",  "CD", "C",  "XC", "L",
                "XL", "X",  "IX", "V",  "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; ++i) {
            if (num == 0)
                break;
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}