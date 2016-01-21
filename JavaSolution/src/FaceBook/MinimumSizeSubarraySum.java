package FaceBook;

/**
 * Created by xyunpeng on 1/20/16.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int walker = 0;
        int runner = 0;
        int sum = 0;
        int maxLen = Integer.MAX_VALUE;
        while (runner < nums.length) {
            if (sum + nums[runner] < s) {
                sum += nums[runner++];
            } else {
                maxLen = Math.min(maxLen, runner - walker + 1);
                while (walker <= runner && sum + nums[runner] >= s) {
                    sum -= nums[walker++];
                }
                maxLen = Math.min(maxLen, runner - walker + 2);
            }
        }
        if (maxLen == Integer.MAX_VALUE) return 0;
        return maxLen;
    }
}

//基本思路都差不多
//别人家的代码:  https://leetcode.com/discuss/77439/concise-java-1ms-o-n-solution
//别人家的代码:  https://leetcode.com/discuss/74489/1-ms-o-n-time-solution-in-java-dynamic-sliding-window