import java.util.Stack;

/**
 * Created by xyunpeng on 12/31/15.
 */
public class BinaryTreeUpsideDown {
    //这个解法Memory Limit Exceeded了,估计是因为用到了stack
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }

        TreeNode newRoot = stack.peek();
        TreeNode p = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            p.left = t.right;
            p.right = t;
            p = t;
        }
        p.right = null;
        return newRoot;
    }


    //直接从根节点开始循环,不用递归也不用stack
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = root;
        TreeNode parent = null;
        TreeNode right = null;
        while (node != null) {
            TreeNode t = node.left;
            node.left = right;
            node.right = parent;
            right = node.right
            parent = node;
            node = t;
        }
        return parent;
    }
}
