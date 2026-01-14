import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majorityElement=0;
        int targetCount = nums.length / 2;
        Map<Integer, Integer> elementMap = new HashMap<>();
        for(int i: nums){
            elementMap.put(i, elementMap.getOrDefault(i, 0) + 1);
            if(elementMap.get(i) > targetCount) {
                majorityElement = i;
                return majorityElement;
            }
        }
        return majorityElement;
    }
    public static int majorityElementSorting(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static int majorityElementBoyerMoore(int[] nums){
        int candidate=0, count=0;
        for(int i: nums){
            if(count == 0) 
                candidate = i;
            if(i == candidate) count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums= {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementSorting(nums));
        System.out.println(majorityElementBoyerMoore(nums));
    }
}
