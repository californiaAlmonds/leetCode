public class SetMatrixZeroes {
    public static int[][] setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int j=0; j<cols; j++) if(matrix[0][j]==0) firstRowZero = true;
        for(int i=0; i<rows; i++) if(matrix[i][0]==0) firstColZero = true;
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = rows-1; i>0; i--) for(int j = cols-1; j>0; j--)
            if(matrix[0][j] == 0|| matrix[i][0] == 0) matrix[i][j] = 0;
        if(firstColZero) {
            for(int i=0; i<rows; i++) matrix[i][0] = 0;
        }
        if(firstRowZero) {
            for(int j=0; j<cols; j++) matrix[0][j] = 0;
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] input = {{1,1,1}, {1,0,1}, {1,1,1}};
        
        for(int[] row: setZeroes(input)) {
            for(int n: row) System.out.print("\s"+n);
            System.out.println();
        }
    }
}