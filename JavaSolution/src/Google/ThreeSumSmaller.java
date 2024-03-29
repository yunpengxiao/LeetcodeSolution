package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
