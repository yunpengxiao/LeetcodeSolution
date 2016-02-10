package FaceBook;

/**
 * Created by xyunpeng on 2/9/16.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        StringBuilder result = new StringBuilder("");
        if (words == null || words.length == 0) {
            return result.toString();
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                    inDegree.put(c, 0);
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            int fl = 0;
            int sl = 0;
            while (fl < words[i - 1].length() && sl < words[i].length()) {
                char c1 = words[i - 1].charAt(fl);
                char c2 = words[i].charAt(sl);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
                fl++;
                sl++;
            }

        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            for (char cc : graph.get(c)) {
                inDegree.put(cc, inDegree.get(cc) - 1);
                if (inDegree.get(cc) == 0) {
                    queue.offer(cc);
                }
            }
        }

        return result.length() == graph.size()? result.toString(): "";
    }
}

//没有别人家的代码,自己写的