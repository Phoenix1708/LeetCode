public class Solution {
    // keep it static
    private static char[][] board;
    private static char[] word;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();
        
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (exist(row, col, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(int row, int col, int wordCharIdx) {
        // if we've found the last char i.e. index now over the edge
        if (wordCharIdx == this.word.length) return true;
        // if the index is out of bound before we found all chars
        // or this cell doesn't match
        if (row < 0 || col < 0 || row > this.board.length - 1 || col > this.board[row].length - 1 || 
            this.word[wordCharIdx] != this.board[row][col]) 
            return false;
        
        // This cell matches. Mark visited
        this.board[row][col] ^= 256;
        // Now visit neighbours
        boolean exist = 
                exist(row - 1, col, wordCharIdx + 1) || 
                exist(row + 1, col, wordCharIdx + 1) ||
                exist(row, col - 1, wordCharIdx + 1) ||
                exist(row, col + 1, wordCharIdx + 1);
        // restore the starting point char if the word can't be found here
        this.board[row][col] = this.word[wordCharIdx];
        // return to the nested for loops to start from next cell
        return exist;
    }
}
