package FaceBook;

/**
 * Created by xyunpeng on 2/3/16.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return  -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {       //这里注意要加上等于
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {         //这里注意要加上等于
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
