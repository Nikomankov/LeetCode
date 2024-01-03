public class Main {
    public static void main(String[] args) {
        String[] strings = {
                "aa",
                "aa",
                "cb",
                "cakepancakecakecoke"
        };
        String[] patterns = {
                "a",
                "*",
                "*??",
                "*cake????"
//                "?aghg?sdfsdf*ergerg**wdwqdq?SDFSG"    "?a"
        };
//        for(int i = 0; i < strings.length; i++){
//            boolean result = isMatch(strings[i],patterns[i]);
//            StringBuilder builder = new StringBuilder("====================\n")
//                    .append(i+1).append("\n")
//                    .append("\ts = ").append(strings[i]).append("\n")
//                    .append("\tp = ").append(patterns[i]).append("\n")
//                    .append("\tresult = ").append(result).append("\n");
//            System.out.print(builder);
//        }
        System.out.println(isMatch(strings[3],patterns[3]));

    }


    //========================================================================================================
    //best time solution
    public boolean isMatchByTime(String s, String p) {
        int si=0,pi=0,mi=0,starIdx=-1;
        while(si<s.length()) {
            if(pi<p.length() && (s.charAt(si)==p.charAt(pi)||p.charAt(pi)=='?')){
                si++;
                pi++;
            }else if(pi<p.length() && p.charAt(pi)=='*'){
                starIdx=pi;
                mi=si;
                pi++;
            }else if(starIdx!=-1){
                pi=starIdx+1;
                mi++;
                si=mi;
            }else{
                return false;
            }
        }
        while(pi<p.length() && p.charAt(pi)=='*'){
            pi++;
        }
        return pi==p.length();
    }

    //========================================================================================================
    //best memory solution



    //========================================================================================================
    //dynamical programming solution
    public static boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[p.length()+1][s.length()+1];
        for(int i = dp.length-1; i >= 0; i--) {
            for(int j = dp[0].length-1; j >= 0; j--) {
                if(i == dp.length-1 && j == dp[0].length-1) {
                    dp[i][j] = true;
                } else if(i == dp.length-1) {
                    dp[i][j] = false;
                } else if(j == dp[0].length-1) {
                    if(p.charAt(i) == '*') {
                        dp[i][j] = dp[i+1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(p.charAt(i) == '?') {
                        dp[i][j] = dp[i+1][j+1];
                    } else if(p.charAt(i) == '*') {
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    } else if(p.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                printArray(dp);
            }
        }
        return dp[0][0];
    }

    private static void printArray(Boolean dp[][]){
        StringBuilder builder = new StringBuilder("\n=======================================\n");
        for(int i = dp.length-1; i >= 0; i--){
            for(int j = dp[0].length-1; j >=0; j--){
                if(dp[i][j] != null){
                    builder.append(dp[i][j] ? 1 : 0).append(" ");
                } else {
                    builder.append("_ ");
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}