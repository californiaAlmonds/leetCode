public class NextPermutation {
    public static int[] nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && (nums[j]<=nums[i])) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums = reverse(nums, i+1);
        return nums;
    }
    public static int[] reverse (int[] nums, int i){
        int j = nums.length-1;
        while(i<j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        return nums;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,1};
        for(int i: nextPermutation(nums)) System.out.print("\s"+ i);
    }
}
