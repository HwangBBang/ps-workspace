// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
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
        int to;
        int w;

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
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, w));
            graph[to].add(new Edge(from, w));
        }

        int answer = dijkstra(new Node(1, 0));
        System.out.println(answer);
    }

    static int dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[start.num] = 0;
        pq.add(start);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != dist[cur.num]) continue;
            for (Edge next : graph[cur.num]) {
                int newDist = next.w + cur.cost;
                if (dist[next.to] > newDist) {
                    dist[next.to] = newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }

        int result = dist[n];
        return result;
    }

}


/*
 */