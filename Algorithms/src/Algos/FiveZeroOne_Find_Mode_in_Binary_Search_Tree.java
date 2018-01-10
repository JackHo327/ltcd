package Algos;

import java.util.ArrayList;
import java.util.List;

public class FiveZeroOne_Find_Mode_in_Binary_Search_Tree {

    private static class TreeNode {
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // best solution with O(1) space
    private TreeNode prev;
    private int count = 0;
    private int maxCount = -1;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList();
        prev = root;
        inorder(root, modes);
        int[] ret = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) ret[i] = modes.get(i);
        return ret;
    }

    public void inorder(TreeNode root, List<Integer> modes) {
        if (root == null) return;
        inorder(root.left, modes);
        count = prev.val == root.val ? count + 1 : 1;

        if (count == maxCount) {
            modes.add(root.val);
        } else if (count > maxCount) {
            modes.clear();
            modes.add(root.val);
            maxCount = count;
        }

        prev = root;
        inorder(root.right, modes);
    }
    
    // a map solution
//    private Map<Integer, Integer> mp = new HashMap<>();
//
//    public int[] findMode(TreeNode root) {
//
//        if (root == null) {
//            return new int[]{};
//        }
//        // load the elements in map
//        inorder(root);
//        // sort the map
//        mp = sortMapByVal(mp);
//        // get the emelent which has the max freqency
//        int max = 0;
//        List<Integer> li = new ArrayList<>();
//        for (Integer i : mp.keySet()) {
//            if (max <= mp.get(i)) {
//                max = mp.get(i);
//                li.add(i);
//            }
//            if (max > mp.get(i)) {
//                break;
//            }
//        }
//
//        int[] ret = new int[li.size()];
//        for (int i = 0; i < li.size(); i++) {
//            ret[i] = li.get(i);
//        }
//        return ret;
//    }
//
//    // tree traversal
//    private void inorder(TreeNode root) {
//
//        if (root.left != null) {
//            inorder(root.left);
//        }
//
//        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);
//
//        if (root.right != null) {
//            inorder(root.right);
//        }
//    }
//
//    // sort the map by value
//    private Map<Integer, Integer> sortMapByVal(Map<Integer, Integer> mp) {
//        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(mp.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//
//        Map<Integer, Integer> newMp = new LinkedHashMap<>();
//
//        for (Map.Entry<Integer, Integer> me : list) {
//            newMp.put(me.getKey(), me.getValue());
//        }
//
//        return newMp;
//    }

    // a better map solution - without sorting
//    Map<Integer, Integer> map;
//    int max = 0;
//
//    public int[] findMode(TreeNode root) {
//        if (root == null) return new int[0];
//        this.map = new HashMap<>();
//
//        inorder(root);
//
//        List<Integer> list = new LinkedList<>();
//        for (int key : map.keySet()) {
//            if (map.get(key) == max) list.add(key);
//        }
//
//        int[] res = new int[list.size()];
//        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
//        return res;
//    }
//
//    private void inorder(TreeNode node) {
//        if (node.left != null) inorder(node.left);
//        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
//        max = Math.max(max, map.get(node.val));
//        if (node.right != null) inorder(node.right);
//    }
}
