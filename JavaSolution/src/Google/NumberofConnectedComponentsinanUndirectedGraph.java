package Google;

/**
 * Created by xyunpeng on 4/30/16.
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if (!graph.containsKey(edges[i][0])) {
                graph.put(edges[i][0], new HashSet<>());
            }

            if (!graph.containsKey(edges[i][1])) {
                graph.put(edges[i][1], new HashSet<>());
            }

            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                count++;
                bfs(graph, visited, i);
            }
        }

        return count;
    }

    private void bfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int start) {
        if (visited[start]) {
            return ;
        }

        Queue<Integer> numQueue = new LinkedList<>();
        numQueue.offer(start);
        while (!numQueue.isEmpty()) {
            int t = numQueue.poll();
            visited[t] = true;
            if (graph.get(t) == null) {
                continue;
            }
            for (Integer i : graph.get(t)) {
                if (visited[i] == false) {
                    numQueue.offer(i);
                }
            }
        }
    }
}


//这道题基本上用bfs就可以做出来,但是答案里是清一色的union find