package com.chs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution637 {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {

                TreeNode node = deque.poll();
                sum += node.val;

                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }

}
