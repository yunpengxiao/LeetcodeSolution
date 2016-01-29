/**
 * Created by xyunpeng on 1/28/16.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int tail = nums.length - 1;
        int i = 0;
        while (i <= tail) {
            if (nums[i] == val) {
                nums[i] = nums[tail];
                tail--;
            } else {
                i++;
            }
        }
        return tail + 1;
    }
}
