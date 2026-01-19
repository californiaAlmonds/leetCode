import java.util.ArrayList;
import java.util.List;

public class FindMissingAndRepeatedValues {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] result = new int[2];
        List<Integer> range = new ArrayList<>(n*n);
        for(int i=1; i<=n*n;i++){
            range.add(i);
        }
        for(int[] row: grid){
            for(int num: row){
                if(range.contains(num)) range.set(range.indexOf(num), 0);
                else result[0] = num;
            }
        }
        for(int i:range) if(i!=0) result[1] = i;
        return result;
    }
    public static int[] findMissingAndRepeatedValuesOptimized(int[][] grid){
        int n = grid.length;
        int[] result= new int[2];
        int[] range = new int[(n*n)+1];
        for(int[] row: grid){
            for(int num: row) range[num]++;
        }

        for(int i=1; i<n*n;i++){
            if(range[i]==0) result[1] = i;
            if(range[i]==2) result[0] = i;
        }
        return result;
    }
    public static int[] findMissingAndRepeatedValuesXOR(int[][] grid){
        int n = grid.length;
        int xorAll = 0;
        for(int i=1; i<=n*n;i++) xorAll ^= i;
        for(int[] row: grid) for(int num: row) xorAll ^= num;
        int rmsb = xorAll & -xorAll;

        int x=0, y=0;
        for(int i=1; i<=n*n;i++){
            if((i & rmsb) != 0) x^=i; 
            else y^=i;
        }
        for(int[] row: grid) for(int num: row){
            if((num & rmsb) != 0) x^=num;
            else y^=num;
        }
        for(int[] row: grid) for(int num: row){
            if(num == x) return new int[]{x,y};
            if(num == y) return new int[]{y,x};
        }
        
        return new int[]{x,y};
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2}, {3,3}};
        int[] result = findMissingAndRepeatedValuesXOR(grid);
        for(int i: result) System.out.println(i);
    }
}
