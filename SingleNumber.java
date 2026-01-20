import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int num: nums){
            visited.put(num, visited.getOrDefault(num,0 )+1); 
        }
        for(Map.Entry<Integer,Integer> pair : visited.entrySet()){
            if(pair.getValue().equals(1)) return pair.getKey(); 
        }
        return 0;
    }
    public static int singleNumberSet(int[] nums){
        Set<Integer> visited = new HashSet<>();
        for(int num: nums){
            if(!visited.add(num)) visited.remove(num);
        }
        return visited.iterator().next();
    }
    public static int singleNumberXOR(int[] nums) {
        int xorAll=0;
        for(int num: nums) xorAll^=num;
        return xorAll;
    }
    public static int singleNumberSorted(int[] nums){
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i+=2){
            if(nums[i-1] != nums[i]) return nums[i-1];
        }
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumberXOR(nums));
        System.out.println(singleNumberSet(nums));
        System.out.println(singleNumberSorted(nums));
    }
}
