public class RemoveElement {
    public static int removeElement(int[] nums, int val){
        int left = 0;
        int count = 0;
        int right = nums.length-1;
        while(left<=right){
         if(nums[left] == val){
            nums[left] = nums[right];
            nums[right] = -1;
            right--;
         }
         else left++;
        }
        for(int n: nums){
            if(n <0) break;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println("\n\n" + removeElement(nums, val));
    }
}
