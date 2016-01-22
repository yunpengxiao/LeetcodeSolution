package FaceBook;

/**
 * Created by xyunpeng on 1/20/16.
 */
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i, j, 0);
                }
            }
        }
    }

    private void helper(int[][] rooms, int x, int y, int step) {
        if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] < step) {
            //上面最后这个条件很重要,不然会TLE, 这个条件即起到了visited的作用又跳过了0和-1以及比step优的值,因为如果step比当前值大以后的所有点都会比当前值大
            return ;
        }

        if (step < rooms[x][y]) {
            rooms[x][y] = step;
        }
        helper(rooms, x, y + 1, step + 1);
        helper(rooms, x + 1, y, step + 1);
        helper(rooms, x - 1, y, step + 1);
        helper(rooms, x, y - 1, step + 1);
    }
}
