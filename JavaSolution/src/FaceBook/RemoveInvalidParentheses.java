package FaceBook;

import java.util.*;

/**
 * Created by xyunpeng on 1/29/16.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String t = queue.poll();



            if (isValid(t)) {
                result.add(t);
                found = true;
            }

            if (found == true) continue;

            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')') {
                    continue;
                }

                String st = t.substring(0, i) + t.substring(i + 1);
                if (!visited.contains(st))
                {
                    queue.offer(st);
                    visited.add(st);                                            //一定要在这里把st加入集合,不然在这个for循环中会加入很多重复的元素
                }

            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')' && count-- == 0) {
                return false;
            }
        }

        return count == 0;
    }
}


//参考了别人家的代码:  https://leetcode.com/discuss/67842/share-my-java-bfs-solution