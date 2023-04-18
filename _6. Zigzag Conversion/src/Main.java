public class Main {
    public static void main(String[] args) {
        int n = 5;
        String s = "1".repeat(n) + "_".repeat(n-2) + "1".repeat(n) + "_".repeat(n-2) +"1".repeat(n);
        System.out.println(Solution.convert1(s,n));
    }
}

class Solution {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int length = s.length();
        int k = numRows*2-2; // number of characters in a block
        int spaces = numRows-2; //max number of spaces in block string
        double p = k*1.0/(numRows-1);
        int n = Math.min(length,numRows);

        for(int i = 0; i < n; i++){
            if(i!=0) result.append("\n");
            int o = i;

            if(o > 0 && o < n-1){
                result.append(s.charAt(o));
                //middle strings
                while (o < length){
                    o += (spaces-i+1)*p;
                    if(o >= length) break;
                    result.append("\s".repeat(spaces-i)).append(s.charAt(o));
                    o += i*p;
                    if(o >= length) break;
                    result.append("\s".repeat(i-1)).append(s.charAt(o));
                }
            } else {
                //end lines
                while(o < length){
                    result.append(s.charAt(o));
                    o += k;
                    if(o < length) result.append("\s".repeat(spaces));
                }
            }
        }

        return result.toString();
    }
    public static String convert1(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int k = 2* (numRows -1);
        for(int i=0;i<numRows;i++){
            int index = i ;
            while(index<n){
                str.append(s.charAt(index));
                if(i!=0 && i!=numRows-1){
                    int k1 = k- (2*i);
                    int k2 = index + k1;
                    if(k2<n){
                        str.append(s.charAt(k2));
                    }
                }
                index = index + k;
            }
        }
        return str.toString();
    }
}