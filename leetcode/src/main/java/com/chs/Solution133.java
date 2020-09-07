package com.chs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/12 14:07
 */
public class Solution133 {

    private HashMap<Node, Node> visited = new HashMap <> ();
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node result = new Node(node.val);
        visited.put(node, result);

        for (Node node1 : node.neighbors) {
            result.neighbors.add(cloneGraph(node1));
        }
        return result;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
