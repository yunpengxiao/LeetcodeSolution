package Linkedin;

/**
 * Created by xyunpeng on 1/19/16.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0
        }

        int local = nums[0];
        int global = local;
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(local + nums[i] - nums[i - 1], nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }
}
