package com.chs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/21 10:51
 */
public class Solution1028 {

    public TreeNode recoverFromPreorder(String S) {

        int pos = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        while (pos < S.length()) {
            int level = 0;
            int val = 0;
            while (S.charAt(pos) == '-') {
                level++;
                pos++;
            }
            while ( pos< S.length() && Character.isDigit(S.charAt(pos))) {
                val = val * 10 + (S.charAt(pos) - '0');
                pos++;
            }

            TreeNode treeNode = new TreeNode(val);
            if (deque.size() == level) {
                if (!deque.isEmpty()) {
                    deque.peek().left = treeNode;

                }
            } else {
                while (deque.size() != level) {
                    deque.pop();
                }
                if (!deque.isEmpty()) {
                    deque.peek().right = treeNode;
                }
            }
            deque.push(treeNode);
        }

        return deque.peekFirst();
    }
}
