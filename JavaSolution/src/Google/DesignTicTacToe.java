package Google;

/**
 * Created by xyunpeng on 5/17/16.
 */
public class DesignTicTacToe {
    int[] cols;
    int[] rows;
    int diagonal;
    int antiDiagonal;
    int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.cols = new int[n];
        this.rows = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        this.size = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1? 1: -1;
        rows[row] += add;
        cols[col] += add;
        if (row == col) {
            diagonal += add;
        }

        if (row == size - col - 1) {
            antiDiagonal += add;
        }

        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antiDiagonal) == size) {
            return player;
        } else {
            return 0;
        }
    }
}


//别人家的解法真是好: https://leetcode.com/discuss/101144/java-o-1-solution-easy-to-understand