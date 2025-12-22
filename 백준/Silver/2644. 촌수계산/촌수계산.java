// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        int result = bfs(target1, target2, graph);
        int answer = result == INF ? -1 : result;
        System.out.println(answer);
    }

    static int bfs(int start, int end, List<Integer>[] graph) {
        int[] dist = new int[n + 1];
        Queue<Integer> que = new ArrayDeque<>();
        Arrays.fill(dist, INF);

        dist[start] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph[cur]) {
                if (dist[next] != INF) continue;
                dist[next] = dist[cur] + 1;
                que.add(next);
            }
        }
        return dist[end];
    }

}

/*

*/