package FaceBook;

/**
 * Created by xyunpeng on 1/16/16.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int p = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[p]) {
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
