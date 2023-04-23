import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height2 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height1 = new int[]{1,1};

        long start = System.currentTimeMillis();
        Solution.maxArea1(height);
        long end = (System.currentTimeMillis() - start);
        System.out.println("1 = " + end);

        start = System.currentTimeMillis();
        Solution.maxArea2(height2);
        end = (System.currentTimeMillis() - start);
        System.out.println("2 = " + end);
    }
}


class Solution {
    public static int maxArea(int[] height) {
        if(Arrays.stream(height).anyMatch(e -> e<0 || e>10000) || height.length<2 || height.length > 100000) return 0;
        int max = 0;
        for(int i = 0; i < height.length-1; i++){
            for(int j = i+1; j < height.length; j++){
                max = Math.max(max, Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
//        if(Arrays.stream(height).anyMatch(e -> e<0 || e>10000) || height.length<2 || height.length > 100000) return 0;
        int max = 0;
        int l = 0;
        int r = height.length-1;
        while(l!=r){
            max = Math.max(max, Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }

    public static int maxArea2(int[] height) {
//        if(Arrays.stream(height).anyMatch(e -> e<0 || e>10000) || height.length<2 || height.length > 100000) return 0;
        int max = 0;
        int l = 0;
        int r = height.length-1;
        while(l!=r){
            int area = height[l] < height[r] ? height[l]*(r-l) : height[r]*(r-l);
            max = max > area ? max : area;
            if(height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }
}