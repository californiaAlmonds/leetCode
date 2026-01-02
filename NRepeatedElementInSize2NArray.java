import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2NArray {
    public static int repeatedNTimes(int[] nums){
        Set<Integer> numSet = new HashSet<>(); 
        for(int i : nums){
            // if(!numMap.contains(i)) numMap.add(i);
            // else return i;
            if(!numSet.add(i)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(nums));
    }
}
