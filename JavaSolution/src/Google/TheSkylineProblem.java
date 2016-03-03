package Google;

/**
 * Created by xyunpeng on 3/2/16.
 */

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            points.add(new int[]{buildings[i][0], -buildings[i][2]});
            points.add(new int[]{buildings[i][1], buildings[i][2]});
        }

        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int pre = 0;
        pq.offer(0);

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i)[1] < 0) {
                pq.offer(-points.get(i)[1]);
            } else {
                pq.remove(points.get(i)[1]);
            }

            int cur = pq.peek();
            if (cur != pre) {
                result.add(new int[]{points.get(i)[0], cur});
                pre = cur;
            }
        }

        return result;

    }
}


//这题属于死都想不出来的题
//别人家的代码: https://leetcode.com/discuss/54201/short-java-solution