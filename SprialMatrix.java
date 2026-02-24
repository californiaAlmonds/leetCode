import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int right = matrix[0].length -1, bottom = matrix.length -1, left = 0, top = 0;
        while(left<=right && top<=bottom){
            for(int c = left; c<=right; c++) {
                result.add(matrix[top][c]);
            }
            top++;
            for(int r = top; r<=bottom; r++) {
                result.add(matrix[r][right]);
            }
            right--;
            if(top<=bottom){
                for(int c = right; c>=left; c--) {
                    result.add(matrix[bottom][c]);
                }
                bottom--;
            }
            if(left<=right){
                for(int r = bottom; r>=top; r--) {
                    result.add(matrix[r][left]);
                }
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for(int n:spiralOrder(matrix))System.out.println(n);
    }
}