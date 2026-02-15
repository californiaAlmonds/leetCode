import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int[] prefixes = new int[nums.length+1];
        HashMap<Integer, Integer> freMap = new HashMap<>();
        int count = 0;
        freMap.put(0, 1);
        for(int i=1; i<=nums.length; i++){
            prefixes[i] = prefixes[i-1] + nums[i-1];
            count += freMap.getOrDefault(prefixes[i] - k, 0);
            freMap.put(prefixes[i], freMap.getOrDefault(prefixes[i], 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println("\n"+ subarraySum(nums, k));
    }
}
