package Google;

/**
 * Created by xyunpeng on 2/3/16.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            int leftValue = (mid - 1) >= 0? nums[mid -1]: Integer.MIN_VALUE;
            int rightValue = (mid + 1) < nums.length? nums[mid + 1]: Integer.MIN_VALUE;
            if (nums[mid] > leftValue && nums[mid] > rightValue) {
                return mid;
            } else if (nums[mid] < leftValue) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[start] > nums[end]? start: end;
    }
}
