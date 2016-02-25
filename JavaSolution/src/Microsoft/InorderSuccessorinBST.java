package Microsoft;

/**
 * Created by xyunpeng on 2/24/16.
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;

        while (root != null) {
            if (root.val > p.val) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return result;
    }
}

//别人家的代码: https://leetcode.com/discuss/77805/java-5ms-short-code-with-explanations