package Uber;

/**
 * Created by xyunpeng on 5/2/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }

        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (helper(board)) {
                            return true;
                        }
                        else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int p = 0; p < 9; p++) {
            if (board[p][j] == c) return false;
        }

        for (int p = 0; p < 9; p++) {
            if (board[i][p] == c) return false;
        }

        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
}


//人家优雅的解法: https://leetcode.com/discuss/30482/straight-forward-java-solution-using-backtracking