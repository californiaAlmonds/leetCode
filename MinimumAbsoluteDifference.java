import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        List <List<Integer>> minDiffSet = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            int currDiff = arr[i]-arr[i-1];
            if(currDiff<minDiff){
                minDiffSet.clear();
                minDiff = currDiff;
                minDiffSet.add(List.of(arr[i-1], arr[i]));
            }
            else if(currDiff == minDiff) 
                minDiffSet.add(List.of(arr[i-1], arr[i]));
        }
        return minDiffSet;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,10,15};
        for(List<Integer> row: minimumAbsDifference(arr)){
            for(int num: row) System.out.print(num+" ");
            System.out.println();
        }
    }
}
