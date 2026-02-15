// package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    static int n;
    static List<Edge>[] graph;
    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int cnt;
        int cost;

        public Node(int to, int cnt, int cost) {
            this.to = to;
            this.cnt = cnt;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(cost, other.cost);
        }
    }
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/platinum/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // 세금 인상횟수

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        int[] taxs = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            taxs[i] = Integer.parseInt(br.readLine()) + taxs[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        int[][] dist = dijkstra(start);

        for (int i = 0; i <= k; i++) {
            int answer = INF;
            for (int cnt = 0; cnt < n; cnt++) {
                if (dist[end][cnt] == INF) continue;
                answer = Math.min(answer, dist[end][cnt] + taxs[i] * cnt);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }

    static int[][] dijkstra(int start) {
        int[][] dist = new int[n + 1][n]; // value, cnt
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start][0] = 0;
        pq.add(new Node(start, 0,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int from = cur.to, cost = cur.cost, cnt = cur.cnt;

            if (dist[from][cnt] != cost) continue;
            if (cnt >= n - 1) continue;

            for (Edge next : graph[from]) {
                if (dist[next.to][cnt + 1] > dist[from][cnt] + next.cost) {
                    dist[next.to][cnt + 1] = dist[from][cnt] + next.cost;
                    pq.add(new Node(next.to, cnt + 1, dist[next.to][cnt + 1]));
                }
            }
        }
        return dist;
    }

}
/*
    간선 당 세금 부과
    도달까지 맥시멈 간선 갯수 ?
* */