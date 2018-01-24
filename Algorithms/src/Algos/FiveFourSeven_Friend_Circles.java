package Algos;

import java.util.LinkedList;
import java.util.Queue;

public class FiveFourSeven_Friend_Circles {

    public int findCircleNum(int[][] M) {
        if (M == null || M[0].length == 0) {
            return 0;
        }

        int counter = 0;
        int[] visited = new int[M.length];
//        bfs
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                que.offer(i);
                while (!que.isEmpty()) {
                    int s = que.poll();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            que.offer(j);
                        }
                    }
                }
                // only when the starting node has not been visited, the counter can add 1.
                counter++;
            }
        }

//        dfs
//        for (int i = 0; i < M.length; i++) {
//            if (visited[i] == 0) {
//                dfs(M, visited, i);
//                counter++;
//            }
//        }

        return counter;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }


}
