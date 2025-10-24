// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] under;
    static List<Integer> answer;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        under = new ArrayList[n + 1];
        inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) under[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a < b , a 가 선행된다.
            under[a].add(b);
            // b의 제약 정도 up
            inDegree[b]++;
        }

        answer = new ArrayList<>();
        List<Integer> starts = getStart();
        topologicalSort(starts);

        StringBuilder sb = new StringBuilder();
        for (Integer each : answer) sb.append(each).append(" ");

        System.out.println(sb);
    }
    private static List<Integer> getStart() {
        List<Integer> starts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                starts.add(i);
            }
        }
        return starts;
    }

    private static void topologicalSort(List<Integer> starts) {
        Queue<Integer> que = new ArrayDeque<>();
        for (Integer start : starts) que.add(start);


        while (!que.isEmpty()) {
            Integer cur = que.poll();
            answer.add(cur);

            for (Integer comp : under[cur]) {
                inDegree[comp]--;
                if (inDegree[comp] == 0) que.add(comp);
            }
        }
    }
}
/*

    위상정렬 , DAG : 사이클 X , 방향 O

*/