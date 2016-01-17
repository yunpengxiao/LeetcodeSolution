package FaceBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xyunpeng on 1/14/16.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void helper(int[] nums, List<Integer> item, List<List<Integer>> res, int pos) {
        res.add(new ArrayList<Integer>(item));

        for (int i = pos; i < nums.length; i++) {
            item.add(nums[i]);
            helper(nums, item, res, i + 1);
            item.remove(item.size() - 1);
        }
    }
}


