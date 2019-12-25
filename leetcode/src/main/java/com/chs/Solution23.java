package com.chs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists){


        if(lists.length==0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode listNode : lists){
            if(listNode != null){
                pq.add(listNode);
            }
        }


        while (!pq.isEmpty()){

            ListNode next = pq.poll();
            cur.next = next;
            cur = next;
            if(next.next != null){
                pq.add(next.next);
            }
        }

        return dummy.next;



    }
}
