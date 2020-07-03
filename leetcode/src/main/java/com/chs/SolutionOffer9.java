package com.chs;

import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/30 17:30
 */
public class SolutionOffer9 {

    private LinkedList<Integer> linkedList;

    public SolutionOffer9() {

        linkedList = new LinkedList<>();
    }

    public void appendTail(int value) {

        linkedList.offer(value);
    }

    public int deleteHead() {

        Integer val = linkedList.poll();
        return val == null ? -1 : val;
    }
}
