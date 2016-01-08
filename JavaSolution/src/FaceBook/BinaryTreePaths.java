package FaceBook;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyunpeng on 1/7/16.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();

        if (root == null) {
            return res;
        }

        String t = "";
        helper(root, t, res);
        return res;
    }

    private void helper(TreeNode root, String t, List<String> res) {
        if (root.left == null && root.right == null) {
            t += Integer.toString(root.val);
            res.add(t);
        } else {
            t += Integer.toString(root.val) + "->";
        }

        if (root.left != null) helper(root.left, t, res);
        if (root.right != null) helper(rrot.right, t, res);
    }
}
