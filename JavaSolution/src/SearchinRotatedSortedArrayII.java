/**
 * Created by xyunpeng on 2/4/16.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {                             //我一开始写成了nums[mid] < nums[end],这样是通不过的,可以仔细想一下
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }

        if (nums[start] == target) {
            return true;
        }

        if (nums[end] == target) {
            return true;
        }

        return false;
    }
}
