package Uber;

/**
 * Created by xyunpeng on 1/8/16.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left, root.right));
        }
    }
}
