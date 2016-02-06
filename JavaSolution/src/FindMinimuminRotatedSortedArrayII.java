/**
 * Created by xyunpeng on 2/5/16.
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end--;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
