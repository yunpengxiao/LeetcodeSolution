package FaceBook;

/**
 * Created by xyunpeng on 1/24/16.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null && nums.length < 2) return ;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zero++] = nums[i];
            }
        }

        for (int i = zero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
