package Uber;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        result[0] = left[1] + right[1] + root.val;
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}
