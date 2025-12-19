// package baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int upperBound;

        public Node(int num, int upperBound) {
            this.num = num;
            this.upperBound = upperBound;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(other.upperBound, upperBound);
        }
    }
    static class Edge {
        int to;
        int limit;

        public Edge(int to, int limit) {
            this.to = to;
            this.limit = limit;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
//         System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, limit));
            graph[to].add(new Edge(from, limit));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int answer = dijkstra(start, end);
        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] weight = new int[n + 1];
        Arrays.fill(weight, -1);

        weight[start] = INF;
        pq.add(new Node(start, INF));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (weight[cur.num] != cur.upperBound) continue;

            for (Edge next : graph[cur.num]) {
                int nextUpbound = Math.min(next.limit, weight[cur.num]);

                if (nextUpbound > weight[next.to]) {
                    weight[next.to] = nextUpbound;
                    pq.add(new Node(next.to, weight[next.to]));
                }
            }
        }

//        System.out.println(Arrays.toString(weight));

        return weight[end];
    }

}


/*
    C <= 1_000_000_000

 */