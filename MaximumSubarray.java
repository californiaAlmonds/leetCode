public class MaximumSubarray {
    public static int maxSubArrayKadane(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i: nums){
            curSum = Math.max(curSum + i, i);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
    public static int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length-1);
    }

    private static int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) /2;
        int leftSum = maxSubArraySum(nums, left, mid);
        int rightSum = maxSubArraySum(nums, mid+1, right);
        int crossingSum = maxCrossingSum(nums, left, right, mid);
        return Math.max(leftSum, Math.max(rightSum, crossingSum));
    }
    private static int maxCrossingSum(int[] nums, int left, int right, int mid) {
        int maxLeftSum = Integer.MIN_VALUE, maxRightSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=mid; i>=left; i--){
            curSum += nums[i];
            maxLeftSum = Math.max(maxLeftSum, curSum);
        }
        curSum = 0;
        for(int i=mid+1; i<=right; i++){
            curSum += nums[i];
            maxRightSum = Math.max(maxRightSum, curSum);
        }
        return maxLeftSum + maxRightSum;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
