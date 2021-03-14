package com.chs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/9 11:38
 */
public class Solution131 {

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        dfs(s.toCharArray(), 0, s.length(), res, new LinkedList<>());
        return res;

    }


    public void dfs(char[] chars, int start, int end, List<List<String>> res, Deque<String> path) {

        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < end; i++) {

            if (!checkPalindrome(chars, start, i)) {
                continue;
            }

            path.addLast(new String(chars, start, i + 1 - start));
            dfs(chars, i+1, end, res, path);
            path.removeLast();

        }
    }

    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
