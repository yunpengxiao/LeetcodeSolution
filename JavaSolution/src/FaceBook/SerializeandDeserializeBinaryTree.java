package FaceBook;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by xyunpeng on 1/16/16.
 */
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        serializeHelper(root, res);
        return res.toString();
    }


    private void serializeHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return ;
        }

        res.add(root.val);
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.substring(1, data.length() - 1).split(", ");
        Queue<String> strQue = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(strQue);
    }

    private TreeNode deserializeHelper(Queue<String> strQue) {
        if (strQue.isEmpty()) {
            return null;
        }
        String t = strQue.poll();
        if (t.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(t));
        root.left = deserializeHelper(strQue);
        root.right = deserializeHelper(strQue);
        return root;
    }
}
