public class Main {
    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(x);
        System.out.println(Solution.isPalindrome(x));
        System.out.println(Integer.MAX_VALUE);

    }
}

class Solution {
    public static boolean isPalindrome(int x) {
        if(x>=Integer.MAX_VALUE || x<0) return false;
        if(x/10 == 0) return true;

        int i = 1;
        while(x/(int)Math.pow(10,i) > 0){
            i++;
        }

        int j = 1;
        while(j <= i/2){
            int a = x/(int)Math.pow(10,i-1);
            int b = x%10;
            if(a == b){
                x = (int)Math.floor(x%Math.pow(10,i-1)/10);
                i -=2;
            } else return false;
        }

        return true;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0)
            return false;

        int q;
        int r;
        int divident = x;
        int reverseOfX = 0;

        while (divident != 0) {
            q = divident / 10;
            r = divident % 10;

            reverseOfX = reverseOfX*10 + r;

            divident = q;
        }

        if (reverseOfX == x)
            return true;
        else
            return false;
    }

    public static boolean isPalindrome2(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}