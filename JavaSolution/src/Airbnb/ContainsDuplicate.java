package Airbnb;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xyunpeng on 1/1/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                return true;
            } else {
                numSet.add(nums[i]);
            }
        }

        return false;
    }
}
