public class Main {
    public static void main(String[] args) {
        int[][] heights = {
                {0,1,0,2,1,0,1,3,2,1,2,1},
                {4,2,0,3,2,5},
                {3,2,0,1,0,2,1},
                {0,2,0,1,3,0,2,1,0,3},
                {2,3},
                {2,0,1,0,3},
                {5,4,1,2},
                {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}
        };
        int[] outputs = {6,9,5,12,0,5,1,83,0};

//        trap(heights[7]);
        printer(heights,outputs);
    }

    //========================================================================================================
    //my solution
    public static int trap(int[] height) {
        int result = 0;
        int n = height.length;

        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i]=Math.max(height[i], leftMax[i-1]);
        }

        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        for(int i = 0; i < n; i++){
            int waterLevel=0;
            waterLevel = Math.min(leftMax[i], rightMax[i]);
            result += (waterLevel - height[i]);
        }

        return result;
    }

    //========================================================================================================
    //another one solution
    public static int trap1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[right];
        int maxWater = 0;

        while(left < right) {
            if(leftMax < rightMax) {
                left++;
                if(height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    maxWater += leftMax - height[left];
                }
            } else {
                right--;
                if(height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    maxWater += rightMax - height[right];
                }
            }
        }

        System.gc();
        return maxWater;
    }

    //========================================================================================================
    //best memory solution
    public static int trapByMemory(int[] height) {
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        int water = 0;

        int max = 0;
        for(int i = 0; i < lMax.length; i++){
            max = Math.max(max,height[i]);

            if( max == height[i]){
                lMax[i] = height[i];
            }else{
                lMax[i] = max;
            }
        }

        int max2 = 0;
        for(int i = height.length - 1; i >= 0; i-- ){
            max2 = Math.max(max2,height[i]);

            if(max2 == height[i]){
                rMax[i] = height[i];
            }else{
                rMax[i] = max2;
            }
        }

        for(int i = 0; i < height.length; i++){
            water += Math.max(Math.min(lMax[i],rMax[i]) - height[i], 0);
        }
        System.gc();
        return water;
    }

    //========================================================================================================
    public static void printer(int[][] heights, int[] outputs){
        StringBuilder builder = new StringBuilder("---Printer---\n\n");
        for(int i = 0; i < outputs.length; i++){
            builder.append("Test ").append(i+1).append("\n");
            int result = trap(heights[i]);
            builder.append("   expected = ").append(outputs[i]).append(", fact = ").append(result).append("\n")
                    .append("   result = ").append(result == outputs[i]).append("\n");
        }
        System.out.println(builder);
    }
}