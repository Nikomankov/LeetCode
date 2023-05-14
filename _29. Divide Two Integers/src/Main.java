public class Main {
    public static void main(String[] args) {
//        int dividend = 10;
//        int divisor = 3;
        int dividend = 7;
        int divisor = -3;
//        int dividend = 2147483647;
//        int divisor = 2;
        System.out.println(Solution.divide(dividend,divisor));

    }
}

class Solution {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean negative = dividend < 0 ^ divisor < 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0, i = 0;

        while (dividend - divisor >= 0) {
            for (i = 0; dividend - (divisor << i << 1) >= 0; i++);
            result += 1 << i;
            dividend -= divisor << i;
        }
        return negative ? -result : result;
    }
}