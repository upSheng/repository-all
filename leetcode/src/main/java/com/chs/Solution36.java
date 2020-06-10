package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/29 11:29
 */
public class Solution36 {

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[i][num] > 0) {
                        return false;
                    }
                    if (column[i][num] > 0) {
                        return false;
                    }
                    int index = (i / 3) * 3 + j / 3;

                    if (box[index][num] > 0) {
                        return false;
                    }

                    row[i][num]++;
                    column[i][num]++;
                    box[index][num]++;

                }

            }
        }

        return true;

    }

    public static void main(String[] args) {


    }
}
