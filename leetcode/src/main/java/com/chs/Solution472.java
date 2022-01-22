package com.chs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution472 {

    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new ArrayList<String>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {

            if (words[i].length() == 0) {
                continue;
            }
            if (dfs(words[i], 0)) {
                res.add(words[i]);
            } else {
                insert(words[i]);
            }
        }

        return res;
    }

    public boolean dfs(String word, int start) {

        if (word.length() == start) {
            return true;
        }
        Trie node = trie;

        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            node = node.children[index];
            if (node == null) {
                return false;
            }


            if (node.end) {
                if (dfs(word, i + 1)) {
                    return true;
                }
            }


        }

        return false;

    }

    public void insert(String word) {

        Trie node = trie;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.end = true;
    }


}

class Trie {
    Trie[] children;
    Boolean end;

    public Trie() {
        children = new Trie[26];
        end = false;
    }
}
