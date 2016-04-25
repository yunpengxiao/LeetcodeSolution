package FaceBook;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null && nums.length == 0) {
            return 0;
        }

        int max = 0;
        int walker = 0;
        int runner = 0;
        int sum = 0;
        while (runner < nums.length) {
            if (sum == k) {
                max = Math.max(max, runner - walker + 1);
                sum -= nums[walker++];
            } else if (sum > k && runner != 0) {
                while (sum > k) {
                    sum -= nums[walker++];
                }
            } else {
                sum += nums[runner++];
            }

        }

        return max;


    }
}
