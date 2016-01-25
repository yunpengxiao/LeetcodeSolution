package FaceBook;

import java.util.*;

/**
 * Created by xyunpeng on 1/24/16.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 1) return false;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new HashSet<Integer>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> nodes = new HashSet<>();
        Queue<Integer> visitQueue = new LinkedList<>();
        visitQueue.offer(0);
        while (!visitQueue.isEmpty()) {
            int node = visitQueue.poll();

            if (nodes.contains(node)) return false;

            for (int d : graph.get(node)) {
                visitQueue.offer(d);
                graph.get(d).remove(node);
            }
            nodes.add(node);
        }

        return nodes.size() == n;
    }
}


//参考 https://leetcode.com/discuss/52555/java-bfs-solution