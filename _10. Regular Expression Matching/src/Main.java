public class Main {
    public static void main(String[] args) {

        String[] sArray = new String[]{"aab","aa", "aa", "ab", "abc", "abb","aaaakkkk"};
        String[] pArray = new String[]{"c*a*b","a", "a*", ".*", "a..", "a.*", "a*k*"};
        Boolean[] rArray = new Boolean[]{true, false, true, true, true, true, true};

        int maxLength = 0;
        String[] results = new String[sArray.length];

        for(int i = 0; i < sArray.length; i++){
            results[i] = "\ts = " + sArray[i] + ", p = " + pArray[i] + ", ";
            maxLength = Math.max(results[i].length(), maxLength);
        }
        for(int j = 0; j < 2; j++){
            for(int i = 0; i < results.length; i++){
                System.out.print(i == 0 ? j + "_".repeat(maxLength+11) + "\n" : "");
                System.out.println(results[i] + "\s".repeat(maxLength-results[i].length()) +
                        (j==0 ?
                            (Solution.isMatch(sArray[i],pArray[i]) == rArray[i] ? "Match" : "Mismatch") :
                            (Solution.isMatch1(sArray[i],pArray[i]) == rArray[i] ? "Match" : "Mismatch")));
            }
        }
    }
}

class Solution {
    public static boolean isMatch(String s, String p) {
        if(s.matches("[a-z]+") && p.matches("[a-z.*]+")){
            return s.matches(p);
        }
        return false;
    }

    public static Boolean[][]dp;
    public static boolean isMatch1(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return helper(s,p,0,0);
    }
    public static boolean helper(String s, String p, int i, int j){
        if(i>=s.length() && j>=p.length()){
            return true;
        }
        if(j>=p.length()){
            return false;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        char chp = p.charAt(j);
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            if(helper(s, p, i, j + 2)){
                dp[i][j]=true;
                return true;
            }
            if(i<s.length() && (s.charAt(i)==chp || chp=='.')){
                boolean flag = helper(s,p,i+1,j);
                dp[i][j]=flag;
                return flag;
            }
        }
        else{
            if(i<s.length() && (s.charAt(i)==chp || chp=='.')){
                boolean flag = helper(s,p,i+1,j+1);
                dp[i][j]=flag;
                return flag;
            }
        }
        dp[i][j]=false;
        return false;
    }
}