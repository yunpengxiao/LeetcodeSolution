package Microsoft;

import apple.laf.JRSUIUtils;

import javax.swing.tree.TreeNode;

/**
 * Created by xyunpeng on 1/11/16.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        if (root.left == null && root.right != null) return hasPathSum(root.right, sum - root.val);
        if (root.right == null && root.left != null) return hasPathSum(root.left, sum - root.val);
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
