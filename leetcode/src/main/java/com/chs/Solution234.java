package com.chs;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {

    public boolean isPalindrome(ListNode head) {


        List<Integer> listNodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            listNodes.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = listNodes.size() - 1;

        while (left < right) {

            if (!listNodes.get(left).equals(listNodes.get(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
