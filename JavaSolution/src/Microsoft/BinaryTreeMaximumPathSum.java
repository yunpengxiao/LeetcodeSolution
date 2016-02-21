package Microsoft;

/**
 * Created by xyunpeng on 2/20/16.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    //这个函数是返回从root出发到叶子节点的最大路径和,但是它在计算的过程中会更新max
    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);    //这一句是更新max

        return root.val + Math.max(left, right);
    }
}



//https://leetcode.com/discuss/43797/elegant-java-solution