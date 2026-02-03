import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals{
    public static int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int[] interval: intervals){
            if(merged.isEmpty() || interval[0] > merged.get(merged.size()-1)[1]){
                merged.add(interval);
            }
            else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for(int[] row: merge(intervals)) {
            for(int i: row) System.out.print("\s"+ i);
            System.out.println();
        }
    }
}