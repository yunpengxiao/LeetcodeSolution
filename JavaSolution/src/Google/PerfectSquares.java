package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                tmp = Math.min(tmp, dp[i - j * j] + 1);
            }
            dp[i] = tmp;
        }

        return dp[n];
    }
}
