package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/19 15:06
 */
public class Solution237 {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
