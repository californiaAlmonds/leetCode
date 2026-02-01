import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i=0, j=1, k = 2;
        while(i<nums.length-2){
            while (j<nums.length-1) {
                while (k<nums.length) {
                    if(nums[i]+nums[j]+nums[k] == 0 && !result.contains(List.of(nums[i], nums[j], nums[k]))) result.add(List.of(nums[i], nums[j], nums[k]));
                    k++;
                }
                j++;
                k=j+1;
            }
            i++;
            j=i+1;
            k=j+1;
        }
        return result;
    }
    public static List<List<Integer>> threeSumTwoPointer(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        for(int i = 0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            l = i+1; r = nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]+nums[i]<0) l++;
                else if(nums[l]+nums[r]+nums[i]>0) r--;
                else if(nums[l]+nums[r]+nums[i]==0) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,0,1,0,0,0,0};
        for(List<Integer> row: threeSumTwoPointer(nums)){
            for(int num: row) System.out.print("\s" +num);
            System.out.println();
        }
    }
}
