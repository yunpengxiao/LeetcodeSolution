package Google;

/**
 * Created by xyunpeng on 4/25/16.
 */
public class LongestIncreasingPathinaMatrix {
    int[][] dirct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = helper(matrix, i, j, m, n, cache);
                max = Math.max(len, max);
            }
        }

        return max;
    }

    private int helper(int[][] matrix, int x, int y, int m, int n, int[][] cache) {
        if(cache[x][y] != 0) {
            return cache[x][y];
        }
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int p = x + dirct[i][0];
            int q = y + dirct[i][1];
            if (p < 0 || q < 0 || p >= m || q >= n || matrix[p][q] <= matrix[x][y]) {
                continue;
            }
            int len = 1 + helper(matrix, p, q, m, n, cache);
            max = Math.max(len, max);
        }
        cache[x][y] = max;
        return max;
    }
}
