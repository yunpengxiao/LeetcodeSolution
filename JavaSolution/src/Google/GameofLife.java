package Google;

/**
 * Created by xyunpeng on 3/28/16.
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return ;
        }

        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                if (i > 0) {
                    live += board[i - 1][j] == 1 || board[i - 1][j] == 2? 1: 0;
                }

                if (j > 0) {
                    live += board[i][j - 1] == 1 || board[i][j - 1] == 2? 1: 0;
                }

                if (i < m - 1) {
                    live += board[i + 1][j] == 1 || board[i + 1][j] == 2? 1: 0;
                }

                if (j < n - 1) {
                    live += board[i][j + 1] == 1 || board[i][j + 1] == 2? 1: 0;
                }

                if (i > 0 && j > 0) {
                    live += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2? 1: 0;
                }

                if (i > 0 && j < n - 1) {
                    live += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2? 1: 0;
                }

                if (i < m - 1 && j > 0) {
                    live += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2? 1: 0;
                }

                if (i < m - 1 && j < n - 1) {
                    live += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2? 1: 0;
                }

                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && (live > 3 || live < 2)) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
