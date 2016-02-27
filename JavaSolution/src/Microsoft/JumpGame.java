package Microsoft;

/**
 * Created by xyunpeng on 2/26/16.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length && i <= maxLen; i++) {
            maxLen = Math.max(maxLen, nums[i] + i);
        }

        return maxLen >= nums.length - 1;
    }
}
