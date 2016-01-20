package FaceBook;

/**
 * Created by xyunpeng on 1/17/16.
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int h = grid.length;
        if (h < 1) {
            return 0;
        }

        int w = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    res++;
                    helper(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return ;
        }

        if (grid[x][y] == '1' && visited[x][y] == false) {
            visited[x][y] = true;
        } else {
            return ;
        }

        helper(grid, visited, x + 1, y);
        helper(grid, visited, x, y + 1);
        helper(grid, visited, x - 1, y);
        helper(grid, visited, x, y - 1);
    }
}
