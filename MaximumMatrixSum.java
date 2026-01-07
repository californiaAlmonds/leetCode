class MaximumMatrixSum{
    public static long maxMatrixSum(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;
        int absSum = 0;
        int val=0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                val = matrix[r][c];
                absSum += Math.abs(val);
                if(val < 0) negCount++;
                if(Math.abs(val)<minAbs) minAbs = Math.abs(val);
            }
        }

        if(negCount%2==0) return absSum;
        else {
            maxSum = absSum - (2 * minAbs);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,-2,5},{-5,6,-1}};
        System.out.println(maxMatrixSum(matrix));
    }
}