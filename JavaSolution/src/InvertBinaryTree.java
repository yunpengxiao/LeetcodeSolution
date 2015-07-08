/**
 * Created by yunpengx on 7/5/15.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);
        TreeNode t = root.right;
        root.right = root.left;
        root.left = t;
        return root;
    }
}
