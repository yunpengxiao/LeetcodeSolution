package FaceBook;

/**
 * Created by xyunpeng on 1/23/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            if (!map.containsKey(tmp)) {
                UndirectedGraphNode newNode = new UndirectedGraphNode(tmp.label);
                map.put(tmp, newNode);
                for (UndirectedGraphNode ugd : tmp.neighbors) {
                    if (!map.containsKey(ugd)) {
                        queue.offer(ugd);
                    }
                }
            }
        }

        for (UndirectedGraphNode ugd : map.KeySet()) {
            for (UndirectedGraphNode ugdn : ugd.neighbors) {
                map.get(ugd).neighbors.add(map.get(ugdn));
            }
        }

        return map.get(node);
    }
}
