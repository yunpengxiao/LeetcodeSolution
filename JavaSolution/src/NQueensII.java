/**
 * Created by xyunpeng on 2/15/16.
 */
public class NQueensII {
    private int count;

    public int totalNQueens(int n) {
        count = 0;

        helper(n, 0, new int[n]);
        return count;
    }

    private void helper(int n, int row, int[] queens) {
        if (n == row) {
            count++;
            return ;
        }

        for (int i = 0; i < n; i++) {
            queens[row] = i;
            if (isValid(queens, row)) {
                helper(n, row + 1, queens);
            }
        }
    }

    private boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[i] - queens[row]) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }
}
