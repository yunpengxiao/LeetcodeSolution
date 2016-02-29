package Microsoft;

/**
 * Created by xyunpeng on 2/28/16.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int pre1 = 0;
        int pre2 = 0;
        int amount1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            amount1 = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = amount1;
        }

        pre1 = 0;
        pre2 = 0;
        int amount2 = 0;
        for (int i = 1; i < nums.length; i++) {
            amount2 = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = amount2;
        }

        return Math.max(amount1, amount2);
    }
}
