// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        int[] cost = new int[n + 1];
        int[] inOrder = new int[n + 1];

        List<Integer>[] preConditions = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) preConditions[i] = new ArrayList<>();


        for (int cur = 1; cur <= n; cur++) {
            st = new StringTokenizer(br.readLine());
            cost[cur] = Integer.parseInt(st.nextToken());
            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                preConditions[pre].add(cur);
                inOrder[cur]++;
            }
        }

        List<Integer> roots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (inOrder[i] == 0) roots.add(i);
        }

        int[] answer = topologicalSort(roots, cost, inOrder, preConditions);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int[] topologicalSort(List<Integer> roots, int[] cost, int[] inOrder, List<Integer>[] preConditions) {
        int[] result = new int[n + 1];

        Queue<Integer> que = new ArrayDeque<>();

        for (int root : roots) {
            result[root] = cost[root];
            que.add(root);
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : preConditions[cur]) {
                inOrder[next]--;
                result[next] = Math.max(cost[next] + result[cur], result[next]);

                if (inOrder[next] == 0)
                    que.add(next);
            }
        }

        return result;
    }

}
