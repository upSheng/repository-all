package com.chs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/2 9:36
 */
public class Soulution114 {


    public void flatten(TreeNode root) {

        List<TreeNode> nodeList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;

        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.push(node);
                nodeList.add(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
        }
        int size = nodeList.size();

        for (int i = 0; i < size; i++) {
            TreeNode prev = nodeList.get(i - 1);
            TreeNode curr = nodeList.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }


}
