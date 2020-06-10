package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/12 9:08
 */
public class Solution79 {


    public static boolean exist(char[][] board, String word) {

        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        boolean[][] ed = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, ed, word, 1, direction, m, n)) {

                    return true;
                }
            }
        }

        return false;

    }

    private static boolean dfs(char[][] board, int x, int y, boolean[][] ed, String word, int start, int[][] direction, int m, int n) {
        if (word.length() == start) {
            return true;
        }
        ed[x][y] = true;
        for (int i = 0; i < direction.length; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (isArea(newX, newY, m, n) && !ed[newX][newY] && board[newX][newY] == word.charAt(start)) {

                if (dfs(board, newX, newY, ed, word, start + 1, direction, m, n)) {
                    return true;
                }
                ;
                ed[newX][newY] = false;
            }

        }
        ed[x][y] = false;
        return false;
    }

    private static boolean isArea(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'a'},
                };
        String word = "aaa";

        System.out.println(exist(board, word));

    }
}
