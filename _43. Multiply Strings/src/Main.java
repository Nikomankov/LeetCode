public class Main {
    public static void main(String[] args) {

        String[] strArray = {"0","1","2","3","4","5","6","7","8","9"};
        for(String num : strArray){
            System.out.println(num + " = " + (int)(num.charAt(0)));
        }


        System.out.println(multiply("123","456"));

    }

    //========================================================================================================
    //my solution
    /*
         123
       * 456
        -----
         738
       +615
      +492
      --------
       56088
     */

    public static String multiply(String num1, String num2) {
        if(num1.length() > 200 || num2.length()>200) return null;

        int[] array = new int[num1.length() + num2.length()];
        StringBuilder result = new StringBuilder();

        for(int i = num1.length()-1; i >= 0; i--){
            char c1 = num1.charAt(i);
            for(int j = num2.length()-1; j >= 0; j--){
                char c2 = num2.charAt(j);
                int n = array[i+j+1] + ((int)(c1 - '0')) * ((int)c2 - '0');
                array[i+j+1] = n % 10;
                if(i+j+1 > 0){
                    array[i+j] += n / 10;
                }
            }
        }

        for(int n : array){
            result.append(n);
        }
        while(result.charAt(0) == '0' && result.length()>1){
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    //========================================================================================================
    //best memory solution


    //========================================================================================================
    //best time solution
}