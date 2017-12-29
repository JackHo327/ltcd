package Algos;

import java.util.HashSet;
import java.util.Set;

public class SevenTwoZero_Longest_Word_in_Dictionary {

    public String longestWord(String[] words) {

        Set<String> set = new HashSet<>();

        for (String s : words) {
            set.add(s);
        }
        String ret = "";

        for (String s : words) {
            boolean flag = true;
            if (s.length() > 1) {
                for (int i = 1; i < s.length(); i++) {
                    String tmp = s.substring(0, i);
                    if (!set.contains(tmp)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                if (ret.length() <= s.length()) {
                    if (ret.length() == s.length() && ret.compareTo(s) > 0) {
                        ret = s;
                    }
                    if (ret.length() < s.length()) {
                        ret = s;
                    }
                }
            }
        }


        return ret;

    }

}

// with Trie
//class Solution {
//    public String longestWord(String[] words) {
//        Trie trie = new Trie();
//        int index = 0;
//        for (String word: words) {
//            trie.insert(word, ++index); //indexed by 1
//        }
//        trie.words = words;
//        return trie.dfs();
//    }
//}
//class Node {
//    char c;
//    HashMap<Character, Node> children = new HashMap();
//    int end;
//    public Node(char c){
//        this.c = c;
//    }
//}
//
//class Trie {
//    Node root;
//    String[] words;
//    public Trie() {
//        root = new Node('0');
//    }
//
//    public void insert(String word, int index) {
//        Node cur = root;
//        for (char c: word.toCharArray()) {
//            cur.children.putIfAbsent(c, new Node(c));
//            cur = cur.children.get(c);
//        }
//        cur.end = index;
//    }
//
//    public String dfs() {
//        String ans = "";
//        Stack<Node> stack = new Stack();
//        stack.push(root);
//        while (!stack.empty()) {
//            Node node = stack.pop();
//            if (node.end > 0 || node == root) {
//                if (node != root) {
//                    String word = words[node.end - 1];
//                    if (word.length() > ans.length() ||
//                            word.length() == ans.length() && word.compareTo(ans) < 0) {
//                        ans = word;
//                    }
//                }
//                for (Node nei: node.children.values()) {
//                    stack.push(nei);
//                }
//            }
//        }
//        return ans;
//    }
//}
