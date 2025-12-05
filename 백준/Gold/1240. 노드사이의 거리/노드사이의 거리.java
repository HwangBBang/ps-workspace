//package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[node1].add(new Edge(node2, cost));
            graph[node2].add(new Edge(node1, cost));
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, end)).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int start, int end) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);
        dist[start] = 0;

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        while (!que.isEmpty()) {
            int curNode = que.poll();
            // if(end==curNode)break;
            for (Edge next : graph[curNode]) {
                if (dist[next.to] != -1) continue;
                dist[next.to] = next.cost + dist[curNode];
                que.add(next.to);
            }
        }
        return dist[end];
    }
}

/*
    Node : N 개
    n-1 개의 연결된 노드

    특정 노드에서 특정 노드까지의 거리

    1번 풀이 - 플로이드 워샬

    int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[node1][node2] = cost;
            graph[node2][node1] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (graph[i][k] == INF) continue;
                for (int j = 1; j <= n; j++) {
                    if (graph[j][k] == INF) continue;
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q1 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            sb.append(graph[q1][q2]).append("\n");
        }
*/