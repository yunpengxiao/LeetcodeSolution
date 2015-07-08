/**
 * Created by xyunpeng on 7/5/15.
 */
import java.lang.Math;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1)
            return false;
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }


    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
