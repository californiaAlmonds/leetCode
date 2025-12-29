public class CountNegativeNumbersInASortedMatrix {
    public static int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalNeg = 0;
        int row = 0;
        int col = cols-1;
        while(col>=0 && row<rows){
            if(grid[row][col] < 0){
            totalNeg += (rows - row);
            col--;
            }
            else{
                row++;
            }
        }
        return totalNeg;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,2}, {-3,-2,-1}};
        System.out.println(countNegatives(grid));
    }
}
