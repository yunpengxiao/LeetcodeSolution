package FaceBook;

/**
 * Created by xyunpeng on 3/8/16.
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int minj = 0;
            for (int j = 0; j < n; j++) {
                if (min > dp[i - 1][j]) {
                    min = dp[i - 1][j];
                    minj = j;
                }
            }

            min = Integer.MAX_VALUE;
            int secj = 0;
            for (int j = 0; j < n; j++) {
                if (min > dp[i - 1][j] && j != minj) {
                    min = dp[i - 1][j];
                    secj = j;
                }
            }

            for (int j = 0; j < n; j++) {
                if (j != minj) {
                    dp[i][j] = dp[i - 1][minj] + costs[i][j];
                } else {
                    dp[i][j] = dp[i - 1][secj] + costs[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > dp[m - 1][i]) {
                min = dp[m - 1][i];
            }
        }

        return min;
    }
}


//自己写的代码不是很简洁
//别人家的代码:  https://leetcode.com/discuss/54415/ac-java-solution-without-extra-space