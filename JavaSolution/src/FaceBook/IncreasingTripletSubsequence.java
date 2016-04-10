package FaceBook;

/**
 * Created by xyunpeng on 4/9/16.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] >= 3) {
                return true;
            }
        }

        return false;
    }
}

//这个是dp的算法,时间复杂度是O(n^2),这是比较general的算法,其实可以做到时间复杂度为n,直接用两个变量就可以了
//别人家的代码: https://leetcode.com/discuss/87204/accepted-java-solution-this-question-only-lines-clear-concise