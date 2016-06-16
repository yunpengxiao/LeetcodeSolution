package FaceBook;

/**
 * Created by xyunpeng on 1/20/16.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);                     //注意这里是第k大的,所以会用nums.length - k
    }

    private int helper(int[] nums, int start, int end, int k) {
        int left = start;
        int p = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] <= p) {
                swap(nums, i, left++);
            }
        }

        swap(nums, left, end);
        if (left == k) return nums[left];
        else if (left < k) return helper(nums, left + 1, end, k);
        else
            return helper(nums, start, left - 1, k);                 //注意这里是排序后下标为k的元素,不用改变k的值
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}


//参考: https://leetcode.com/discuss/69427/concise-java-solution-based-on-quick-select