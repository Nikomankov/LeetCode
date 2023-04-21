import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"+-12", "efsgsafs-2043", "    2-43", "00000-42a1234", "   +0 123", "9223372036854775808", "-23372036854775808"};

        Arrays.stream(strings).forEach(Solution::myAtoi);

//        Solution.myAtoi("-2147483648");

    }
}

class Solution {
    public static int myAtoi(String s) {
        long result = 0;
        char[] array = s
                .trim()
                .toCharArray();

        int i = 1;
        int m = 1;
        boolean start = false;
        for(char c : array){
            if(Character.isDigit(c)){
                result = result*i + Character.getNumericValue(c);
                if(result > Integer.MAX_VALUE) break;
                i = 10;
                start = true;
            } else if(!start){
                if(c == '-'){
                    m = -1;
                    start = true;
                } else if (c == '+') start = true;
                else break;
            } else break;
        }

        result = result*m;
        result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE :
                result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
        System.out.println(result);
        return (int)result;
    }

    public static int myAtoi1(String s) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (s.length() == 0) return 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i) - '0');
            i++;
        }
        return result * sign;
    }
}