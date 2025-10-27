// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] indegree;
    static List<Integer>[] preCondition;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int [n + 1];
        preCondition = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) preCondition[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int nxt = Integer.parseInt(st.nextToken());
            indegree[nxt] ++;
            preCondition[pre].add(nxt);
        }

        List<Integer> starts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) starts.add(i);
        }

        List<Integer> result = topologicalSort(starts);
        for (Integer each : result) {
            sb.append(each).append(" ");
        }
        System.out.println(sb);

    }

    static List<Integer> topologicalSort(List<Integer> starts) {
        List<Integer> order = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int start : starts) pq.add(start);

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            order.add(cur);
            for (int nxt : preCondition[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0){
                    pq.add(nxt);
                }
            }
        }

        return order;
    }
}

/*

    사전 순서 => 위상 정렬 + 기본 순서
    기본 순서 => 우선순위 큐

*/
