package FaceBook;

import javax.swing.tree.TreeNode;

/**
 * Created by xyunpeng on 1/20/16.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return root;
    }
}

//很简单,但是一上来真的一点思路都没有