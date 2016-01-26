package FaceBook;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by xyunpeng on 1/25/16.
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> col = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root);
        Map<TreeNode, Integer> nodecol = new HashMap<>();
        nodecol.put(root, 0);
        int min = 0;
        while (!nodes.isEmpty()) {
            TreeNode t = nodes.poll();
            int w = nodecol.get(t);
            if (!col.containsKey(w)) {
                col.put(w, new ArrayList<>());
            }
            col.get(w).add(t.val);
            if (t.left != null) {
                nodes.offer(t.left);
                nodecol.put(t.left, w - 1);
            }

            if (t.right != null) {
                nodes.offer(t.right);
                nodecol.put(t.right, w + 1);
            }

            min = Math.min(w, min);
        }

        while (col.containsKey(min)) {
            result.add(col.get(min++));
        }

        return result;
    }
}


//代码的简洁性参考了: https://leetcode.com/discuss/73113/using-hashmap-bfs-java-solution