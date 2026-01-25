public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i=0;
        while(i < height.length){
            for(int j=i; j<height.length; j++){
                int curArea = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(maxArea, curArea);
            }
            i++;
        }
        return maxArea;
    }

    public static int maxAreaOptimized(int[] height){
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while(left < right){
            int curArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, curArea);

            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOptimized(heights));
    }
}
