package FaceBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xyunpeng on 1/16/16.
 */
public class sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;                   //仔细想一下为什么这里可以跳过
            twoSum(nums, i + 1, 0 - nums[i], res);
        }

        return res;
    }

    private void twoSum(int[] nums, int pos, int target, List<List<Integer>> res) {
        int start = pos;
        int end = nums.length - 1;
        while (start < end) {
            int t = nums[start] + nums[end];
            if (t == target) {
                List<Integer> item = new ArrayList<>();
                item.add(0 - target);
                item.add(nums[start]);
                item.add(nums[end]);
                res.add(item);
                while (start < end && nums[start] == nums[start + 1])         //所有相等的其实都不用查了
                    start++;
                start++;
                while (start < end && nums[end] == nums[end - 1])
                    end--;
                end--;
            } else if ( t > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
