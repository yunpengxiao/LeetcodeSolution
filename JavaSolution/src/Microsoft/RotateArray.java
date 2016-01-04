package Microsoft;

/**
 * Created by xyunpeng on 1/3/16.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return ;
        }

        int step = k % nums.length;
        reverse(nums, 0, nums.length - step - 1);
        reverse(nums, nums.length - step, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}
