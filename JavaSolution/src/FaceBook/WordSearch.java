package FaceBook;

/**
 * Created by xyunpeng on 1/19/16.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean helper(char[][] board, String word, int len, int x, int y) {
        if (len == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        if (board[x][y] == word.charAt(len)) {
            char c = board[x][y];
            board[x][y] = '#';                                              //这里用这种方法来避免使用visited数组
            boolean result = helper(board, word, len + 1, x + 1, y) ||
                        helper(board, word, len + 1, x, y + 1) ||
                        helper(board, word, len + 1, x - 1, y) ||
                        helper(board, word, len + 1, x, y - 1);
            board[x][y] = c;
            return result;
        }

        return false;

    }
}


//参考了别人家的代码: https://leetcode.com/discuss/60857/simple-solution