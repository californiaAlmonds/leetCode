public class CountInversions {
    public static long countInversions(int[]nums){
        return mergeSort(nums, 0, nums.length-1);
    }
    public static long mergeSort(int[] nums, int l, int r){
        long inversions = 0;
        if(l>=r) return 0;
        int mid = (r+l)/2;
        inversions += mergeSort(nums, l, mid);
        inversions += mergeSort(nums, mid+1, r);
        inversions += merge(nums, l, mid, r);
        return inversions;
    }
    public static long merge(int[] nums, int l, int mid, int r){
        long inversions = 0;
        int left = l;
        int right = mid+1;
        int i = 0;
        int[] merged = new int[r-l+1];
        while(left<=mid && right<=r){
            if(nums[left] > nums[right]){
                merged[i++] = nums[right++];
                inversions += (mid - left + 1);
            } else if(nums[left]<=nums[right]){
                merged[i++] = nums[left++];
            }
        }
        while(left<=mid){
            merged[i++] = nums[left++];
        }
        while(right<=r){
            merged[i++] = nums[right++];
        }
        for(int j=0;j<merged.length; j++){
            nums[j+l] = merged[j];
        }
        return inversions;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,5,6,8,4,3,1,3};
        System.out.println(countInversions(nums));
    }
}
