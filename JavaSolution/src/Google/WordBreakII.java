package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (!breakable(s, wordDict)) {
            return result;
        }
        helper(s, wordDict, 0, "", result);
        return result;
    }

    private void helper(String s, Set<String> wordDict, int start, String pre, List<String> result) {
        if (start == s.length()) {
            result.add(pre.trim());
            return ;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                helper(s, wordDict, i, pre + " " + s.substring(start, i), result);
            }
        }
    }

    private boolean breakable(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
