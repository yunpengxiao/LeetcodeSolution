package Microsoft;

/**
 * Created by xyunpeng on 2/26/16.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) max = dp[i];
        }

        return max;
    }
}
