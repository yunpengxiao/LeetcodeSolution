package Microsoft;

/**
 * Created by xyunpeng on 2/26/16.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String result = null;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (result == null || j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }
}
