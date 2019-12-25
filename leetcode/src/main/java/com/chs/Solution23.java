package com.chs;

import java.util.Comparator;
import java.util.PriorityQueue;

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
