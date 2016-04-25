package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if (nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> max = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!max.isEmpty() && max.peekFirst() == i - k) {
                max.removeFirst();
            }

            while (!max.isEmpty() && nums[max.peekLast()] < nums[i]) {
                max.removeLast();
            }

            max.addLast(i);
            if (i < k - 1) continue;
            result[i - k + 1] = nums[max.peekFirst()];
        }

        return result;
    }
}


//参考了别人家的解说: https://segmentfault.com/a/1190000003903509