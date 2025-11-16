// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static final int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph;
    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        StringBuilder sb = new StringBuilder();
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int[] result = dijkstra(i);
            for (int j = 1; j <= n; j++) {
                grid[j][i] = result[j];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(grid[i][j] == -1 ? "-" : grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int [] dijkstra(int start) {
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.num] != cur.cost) continue;

            for (Edge next : graph[cur.num]) {
                if (dist[next.to] > cur.cost + next.w) {
                    dist[next.to] = cur.cost + next.w;
                    parent[next.to] = cur.num;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return parent;
    }

}


/*
 */