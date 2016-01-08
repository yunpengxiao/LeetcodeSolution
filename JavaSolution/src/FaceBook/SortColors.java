package FaceBook;

/**
 * Created by xyunpeng on 1/7/16.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return ;
        }

        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[red];
                nums[red++] = t;
            } else if (nums[i] == 2){
                int t = nums[i];
                nums[i] = nums[blue];
                nums[blue--] = t;
                i--;
            } else {
                continue;
            }
        }
    }
}
