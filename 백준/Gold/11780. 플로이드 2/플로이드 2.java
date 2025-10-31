// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] grid = new int[n + 1][n + 1];
        Map<Integer, LinkedHashSet<Integer>> paths = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    grid[i][j] = 0;
                    continue;
                }
                grid[i][j] = INF;
                paths.put(createKey(i, j), new LinkedHashSet<>());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (grid[u][v] > c) grid[u][v] = c;

            LinkedHashSet<Integer> cur = paths.get(createKey(u, v));
            cur.add(u); cur.add(v);

        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (grid[i][k] == INF) continue;
                for (int j = 1; j <= n; j++) {
                    if (grid[k][j] == INF) continue;
                    
                    if (grid[i][j] > grid[i][k] + grid[k][j]) {
                        grid[i][j] = grid[i][k] + grid[k][j];

                        LinkedHashSet<Integer> prev = paths.get(createKey(i, j));
                        LinkedHashSet<Integer> next1 = paths.get(createKey(i, k));
                        LinkedHashSet<Integer> next2 = paths.get(createKey(k, j));
                        LinkedHashSet<Integer> next = new LinkedHashSet<>();
                        next.addAll(next1);
                        next.addAll(next2);

                        paths.put(createKey(i, j), next);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int result = (grid[i][j] == INF) ? 0 : grid[i][j];
                sb.append(result).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || grid[i][j] == INF){ sb.append(0).append("\n"); continue;}

                LinkedHashSet<Integer> path = paths.get(createKey(i, j));
                sb.append(path.size()).append(" ");
                for (int each :path) {
                    sb.append(each).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int createKey(int i, int j) {
        return 1000 * i + j;
    }
}
