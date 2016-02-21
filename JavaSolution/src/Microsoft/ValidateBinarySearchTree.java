package Microsoft;

/**
 * Created by xyunpeng on 2/20/16.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && min >= root.val) {
            return false;
        }

        if (max != null && max <= root.val) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
