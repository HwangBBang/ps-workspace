// package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] indegree;
    static List<Edge>[] graph, reversedGraph;
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int to,w;

        public Edge(int to, int w) {
            this.to = to; this.w = w;
        }
    }

    static class Answer {
        int time;
        int cnt;

        public Answer(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }
        public String toString() {
            return time + "\n" + cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        reversedGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            indegree[next] ++;
            graph[prev].add(new Edge(next, cost));
            reversedGraph[next].add(new Edge(prev, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Answer answer = topoDijkstra(start, end);
        System.out.println(answer);
    }

    static Answer topoDijkstra(int start, int end) {
        Queue<Integer> que = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        dist[start] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (Edge next : graph[cur]) {
                indegree[next.to] --;
                dist[next.to] = Math.max(dist[next.to], dist[cur] + next.w);
                if (indegree[next.to] == 0) {
                    que.add(next.to);
                }
            }
        }

        boolean[] visited = new boolean[n + 1];
        int cnt = 0;
        visited[end] = true;
        que.add(end);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (Edge prev : reversedGraph[cur]) {

                if (dist[cur] == prev.w + dist[prev.to]) {
                    cnt++;

                    if (visited[prev.to]) continue;
                    visited[prev.to] = true;
                    que.add(prev.to);
                }

            }
        }

        return new Answer(dist[end], cnt);
    }
}

/*
 1 분도 쉬지않고 달린다.
* */