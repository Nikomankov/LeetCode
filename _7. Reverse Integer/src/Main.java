public class Main {
    public static void main(String[] args) {
        int x = 2147483647;
        int p = -2143847412;
        int y = -2147483412;
        int k = -90;
//        System.out.println(Solution.reverse(k));
        System.out.println(Solution.reverse(-2147483648));
    }
}

class Solution {
    public static int reverse(int x) {
        long xLong = x;
        int result = 0;
        int i = 1;
        int j = 1;
        byte m = 1;

        if(xLong<0){
            xLong = xLong*(-1);
            m = -1;
        }
        while(xLong/10/i>0){
            i=i*10;
        }

        while(i>0){
            if(j == 1000000000) {
                int c = (int) (result + (xLong / i) * j);
                if (c % j != result) return 0;
            }
            result += (xLong/i)*j;
            xLong = xLong%i;
            i=i/10;
            j=j*10;
        }

        result = result*m;
        return result;
    }
    public static int reverse1(int x) {
        int temp;
        long reverse=0;
        while(x!=0){
            temp=x%10;
            reverse=reverse*10+temp;
            x=x/10;
        }
        if(reverse >=Integer.MIN_VALUE && reverse <=Integer.MAX_VALUE){
            return (int )reverse;
        }
        return 0;
    }
}