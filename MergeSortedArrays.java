public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = nums1.length-1;
        m--;
        n--;
        while(m>=0 && n>=0){
            if(nums1[m] > nums2[n]) {
                nums1[size--] = nums1[m--];
            }
            else {
                nums1[size--] = nums2[n--];
            }
        }
        while(n>=0){
            nums1[size--] = nums2[n--];
        }
        for(int num: nums1) System.out.println(num);
    }
    public static void main(String[] args) {
        int[] nums1 = {0}, nums2 = {1};
        int m = 0, n= 1;
        merge(nums1, m, nums2, n);
    }
}
