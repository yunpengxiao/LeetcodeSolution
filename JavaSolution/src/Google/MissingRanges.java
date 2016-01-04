package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyunpeng on 1/1/16.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int pre;
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            res.add(makeResult(lower, upper));
            return res;
        }

        if (lower < nums[0]) {
            res.add(makeResult(lower, nums[0] - 1));
            pre = nums[0];
        } else {
            pre = lower;
        }

        for (int cur : nums) {
            if (cur - pre > 1) {
                res.add(makeResult(pre + 1, cur - 1));
            }
            pre = cur;
        }

        if (upper > pre) {
            res.add(makeResult(pre + 1, upper));
        }

        return res;
    }

    private String makeResult(int start, int end) {
        if (start >= end) {
            return Integer.toString(start);
        } else {
            return Integer.toString(start) + "->" + Integer.toString(end);
        }
    }
}
