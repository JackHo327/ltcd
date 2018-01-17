package Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generalized_KSum {
    public List<List<Integer>> kSum_Trim(int[] a, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSum_Trim(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

    private void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {
            // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++;
                    right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        } else {
            // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                // a[i] too small
                if (a[i] + max * (k - 1) < target) continue;
                // a[i] too big
                if (a[i] * k > target) break;

                if (a[i] * k == target) {
                    // same numbers in a row.
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        // Add result immediately.
                        result.get(result.size() - 1).addAll(temp);
                    }
                    break;
                }
                path.add(a[i]);
                // recursion
                kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
                // Backtracking
                path.remove(path.size() - 1);
            }
        }
    }
}
