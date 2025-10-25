// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n, k, target;


    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[] indegree = new int[n + 1];
            int[] useTime = new int[n + 1];
            List<Integer>[] preCondition = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) preCondition[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) useTime[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int nxt = Integer.parseInt(st.nextToken());
                preCondition[pre].add(nxt);
                indegree[nxt]++;
            }
            target = Integer.parseInt(br.readLine());
            int answer = topoLogicalSort(indegree, useTime, preCondition);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static int topoLogicalSort(int[] indegree, int[] useTime, List<Integer>[] preCondition) {
        int[] prefixTime = new int[n + 1];
        List<Integer> starts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                prefixTime[i] = useTime[i];
                starts.add(i);
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        for (Integer start : starts) que.add(start);

        while (!que.isEmpty()) {
            Integer cur = que.poll();

            for (Integer next : preCondition[cur]) {
                prefixTime[next] = Math.max(prefixTime[next], useTime[next] + prefixTime[cur]);
                indegree[next] --;
                if (indegree[next] == 0) {
                    que.add(next);
                }
            }
        }

        return prefixTime[target];
    }

}
