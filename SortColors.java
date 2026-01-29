public class SortColors {
    public static int[] sortSimple(int[] nums){
        int count0 = 0, count1 = 0, count2 = 0;
        for(int num: nums){
            if(num == 0) count0++;
            if(num == 1) count1++;
            if(num == 2) count2++;
        }
        for(int i=0; i<nums.length;i++){
            if(count0-->0) nums[i] = 0;
            else if(count1-->0) nums[i] = 1;
            else if(count2-->0) nums[i] = 2;
        }
        return nums;
    }
    public static int[] sortTwoPointer(int[] nums){
        int count = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        for(int i=count;i<nums.length;i++){
            if(nums[i]==1) {
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        return nums;
    }
    private static int[] sort(int[] nums) {
        int low =0, mid = 0, high = nums.length-1, temp;
        while(mid<=high){
            if(nums[mid]==0){
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
         }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        for(int i: sort(nums)) System.out.print("\s" + i);
    }
}
