import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        long sum;
        for(int i=0; i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                l = j+1;
                r = nums.length-1;
                while(l<r){
                    sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum<target) l++;
                    else if(sum>target) r--;
                    else if(sum == target){
                        result.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        for(List<Integer> row: fourSum(nums, target)){
            for(int num: row) System.out.print("\s"+num);
            System.out.println();
        }
    }
}
