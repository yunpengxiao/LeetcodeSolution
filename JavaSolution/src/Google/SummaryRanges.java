package Google;

/**
 * Created by xyunpeng on 2/10/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                result.add(build(nums[start], nums[i - 1]));
                start = i;
            } else if (i == nums.length - 1) {
                result.add(build(nums[start], nums[i]));
            }
        }

        if (start == nums.length - 1) {
            result.add(build(nums[start], nums[start]));
        }

        return result;
    }

    private String build(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        }

        return Integer.toString(start) + "->" + Integer.toString(end);
    }
}


//不是很简洁