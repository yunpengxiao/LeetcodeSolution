import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyunpeng on 7/8/15.
 * TODO: Need fully understand
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode t, long min, long max) {
        if (t == null)
            return true;
        if (t.val <= min || t.val >= max)
            return false;
        return helper(t.left, min, t.val) && helper(t.right, t.val, max);
    }
}
