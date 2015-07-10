import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xyunpeng on 7/8/15.
 * TODO: Not the best solution
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int last = 1;
        int cur = 0;
        boolean r = true;
        List<Integer> el = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            last--;
            if (r)
                el.add(t.val);
            else
                el.add(0, t.val);
            if (t.left != null) {
                q.add(t.left);
                cur++;
            }
            if (t.right != null) {
                q.add(t.right);
                cur++;
            }
            if (last == 0) {
                r = !r;
                last = cur;
                cur = 0;
                res.add(el);
                el = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
