public class Search2dMatrix{

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = (rows*cols)-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            int row = mid/cols; int col = mid%cols;
            if(matrix[row][col] == target) return true;
            if(matrix[row][col]>target) right = mid-1;
            else left = mid+1; 
        }
        return false;
    }

    public static boolean searchMatrixStairCase(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1;
        while(row<rows && col>=0){
            if(matrix[row][col] == target) return true;
            else if(target<matrix[row][col]) col--;
            else row++;
        }
        return false;
    }


    public static void main(String args[]){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int target = 9;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrixStairCase(matrix, target));





    }
}