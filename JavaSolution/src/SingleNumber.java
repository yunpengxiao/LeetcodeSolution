/**
 * Created by xyunpeng on 1/25/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }
}
