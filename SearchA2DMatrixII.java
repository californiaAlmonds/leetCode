public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length-1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c] ==target) return true;
            else if(target <matrix[r][c] && c>0) c--;
            else r++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target = 99;
        System.out.println(searchMatrix(matrix, target));
    }
}
