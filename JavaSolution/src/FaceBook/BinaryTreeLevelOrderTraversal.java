package FaceBook;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xyunpeng on 1/7/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();

        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                if (!level.isEmpty()) {
                    res.add(level);
                    level = new ArrayList<>();
                }
                continue;
            }

            level.add(t.val);
            if (t.left != null) {
                queue.add(t.left);
            }

            if (t.right != null) {
                queue.add(t.right);
            }

            if (queue.peek() == null) {
                queue.add(null);
            }
        }

        return res;
    }
}
