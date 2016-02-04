/**
 * Created by xyunpeng on 2/3/16.
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = -1;
            result[1] = -1;

            if (nums == null || nums.length == 0) {
                return result;
            }

            int start = 0;
            int end = nums.length - 1;
            int mid;
            while (start + 1 < end) {
                mid = start + ((end - start) >> 1);
                if (nums[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (nums[start] == target) {
                result[0] = start;
            } else if (nums[end] == target) {
                result[0] = end;
            }

            start = 0;
            end = nums.length - 1;
            while (start + 1 < end) {
                mid = start + ((end - start) >> 1);
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (nums[end] == target) {
                result[1] = end;
            } else if (nums[start] == target) {
                result[1] = start;
            }

            return result;
        }
}
