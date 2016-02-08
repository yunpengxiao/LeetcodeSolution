package FaceBook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xyunpeng on 2/7/16.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (numCourses == 0) {
            return result;
        }

        List<List<Integer>> adjust = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjust.add(new ArrayList<Integer>());
        }

        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            adjust.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int courseCount = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            result[courseCount++] = t;
            List<Integer> nodes = adjust.get(t);
            for (int i = 0; i < nodes.size(); i++) {
                int node = nodes.get(i);
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }

        return courseCount == numCourses? result: new int[0];
    }
}
