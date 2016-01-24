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
            return node;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> newNodes = new HashMap<>();
        Queue<UndirectedGraphNode> toCopy = new LinkedList<>();
        toCopy.offer(node);
        while (!toCopy.isEmpty()) {
            UndirectedGraphNode t = toCopy.poll();
            if (!newNodes.containsKey(t)) {
                UndirectedGraphNode p = new UndirectedGraphNode(t.label);
                newNodes.put(t, p);
                for (UndirectedGraphNode ugn : t.neighbors) {
                    toCopy.offer(ugn);
                }
            }
        }

        for (UndirectedGraphNode ugn : newNodes.keySet()) {
            UndirectedGraphNode newNode = newNodes.get(ugn);
            newNode.neighbors = new ArrayList<>();
            for (UndirectedGraphNode n : ugn.neighbors) {
                newNode.neighbors.add(newNodes.get(n));
            }
        }

        return newNodes.get(node);
    }
}
