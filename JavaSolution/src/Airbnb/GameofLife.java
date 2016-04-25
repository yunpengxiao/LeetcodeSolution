package Airbnb;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {
        if (board == null) {
            return ;
        }
        int m = board.length;
        if (m == 0) {
            return ;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
                    for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                        live += board[x][y] & 1;
                    }
                }

                if (live == 3 || live - board[i][j] == 3) {
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >>> 1;
            }
        }
    }
}

//别人家的解说: https://segmentfault.com/a/1190000003819277#articleHeader10