/**
 * Created by xyunpeng on 2/15/16.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        helper(n, 0, new int[n], result);
        return result;
    }

    private void helper(int n, int row, int[] queens, List<List<String>> result) {
        if (n == row) {
            result.add(buildQueens(queens, n));
            return ;
        }

        for (int i = 0; i < n; i++) {
            queens[row] = i;
            if (isValid(row, queens))
                helper(n, row + 1, queens, result);
        }
    }

    private boolean isValid(int row, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[i] - queens[row]) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }

    private List<String> buildQueens(int[] queens, int n) {
        List<String> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            StringBuilder t = new StringBuilder("");
            for (int j = 0; j < n; j++) {
                if (j == queens[i]) {
                    t.append('Q');
                } else {
                    t.append('.');
                }
            }
            result.add(t.toString());
        }

        return result;
    }
}
