package FaceBook;

/**
 * Created by xyunpeng on 1/7/16.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int product = 1;
        for (int i = output.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            output[i] = product * output[i];
        }
        return output;
    }
}
