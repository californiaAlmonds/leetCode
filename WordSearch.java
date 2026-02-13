public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && nextStep(board, i, j, word, 1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean nextStep(char[][] board, int r, int c, String word, int count){
        if(count == word.length()) return true;
        char temp = board[r][c];
        board[r][c] = '#';
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int dir[]: directions){
            int nr = r+dir[0], nc = c+dir[1];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc] == word.charAt(count) && nextStep(board, nr, nc, word, count+1)){
                return true;
            } 
        }
        board[r][c] = temp;
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board, word));
    }
}
