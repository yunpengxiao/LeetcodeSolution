package Linkedin;

/**
 * Created by xyunpeng on 2/28/16.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pre1 = 0;
        int pre2 = 0;
        int amount = 0;
        for (int i = 0; i < nums.length; i++) {
            amount = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = amount;
        }

        return amount;
    }
}
