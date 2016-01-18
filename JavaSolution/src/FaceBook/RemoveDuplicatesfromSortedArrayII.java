package FaceBook;

/**
 * Created by xyunpeng on 1/17/16.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int p = nums.length - 1;
        int dup = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[p] || dup < 2) {
                if (nums[i] == nums[p]) {
                    dup++;
                } else {
                    dup = 1;
                }
                nums[--p] = nums[i];
            }
        }
        int res = nums.length - p;
        for (int i = 0; p < nums.length; i++, p++) {
            nums[i] = nums[p];
        }

        return res;
    }
}
