public class MagicSquaresInGrid {

    public static boolean isValidGrid(int row, int col, int[][] grid){
        int[] seen = new int[10];
        for(int r=row; r<=row+2; r++){
            for(int c=col; c<=col+2; c++){
                int val = grid[r][c];
                if (val < 1 || val > 9) return false;
                if(seen[val]==1) return false;
                seen[val] = 1;
            }
        }
        return true;
    }

    public static int numMagicSquaresInside(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int r1, r2, r3, c1, c2, c3, d1, d2;
        int totalMagicSquares = 0;
        for(int row=0; row+2<rows; row++){
            for(int col=0; col+2<cols; col++){
                if(!isValidGrid(row, col, grid)) continue;
                if(grid[row+1][col+1] != 5) continue;
                r1 = grid[row][col] + grid[row][col+1]+grid[row][col+2];
                r2 = grid[row+1][col] + grid[row+1][col+1]+grid[row+1][col+2];
                r3 = grid[row+2][col] + grid[row+2][col+1]+grid[row+2][col+2];
                c1 = grid[row][col] + grid[row+1][col] + grid[row+2][col];
                c2 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
                c3 = grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];
                d1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
                d2 = grid[row][col+2] + grid[row+2][col] + grid[row+1][col+1];
                if(r1 == 15 && r2 == 15 && r3 == 15 &&  c1 == 15 && c2 == 15 && c3 == 15 && d1 == 15 && d2 == 15){
                totalMagicSquares++;
            }
            }
        }
        return totalMagicSquares;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(grid));
    }
}
