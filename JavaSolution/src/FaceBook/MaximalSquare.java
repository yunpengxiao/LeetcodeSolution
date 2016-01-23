package FaceBook;

/**
 * Created by xyunpeng on 1/22/16.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] area = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) area[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1'){
                    area[i][j] = Math.min(area[i - 1][j], Math.min(area[i][j - 1], area[i - 1][j - 1])) + 1;
                } else {
                    area[i][j] = 0;
                }
                if (area[i][j] > max) max = area[i][j];
            }
        }
        return max * max;
    }
}
