// package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static final int INF = Integer.MAX_VALUE;
    static final int DEFAULT_START = 1;

    static class Edge implements Comparable<Edge> {
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/gold/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        int answer = prim();

        System.out.println(answer);
    }

    static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        for(Edge adj : graph[DEFAULT_START]) pq.add(adj);
        visited[DEFAULT_START] = true;
        int result = 0;

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            result += cur.w;
            visited[cur.to] = true;
            for (Edge nxt : graph[cur.to]) {
                pq.add(nxt);
            }
        }

        return result;
    }
}


/*
    1. 플로이드 워셜 : 정점이 10_000 이라 메모리 초과.
    2. edge의 가중치만 최소인것을 선택  
    3. DSU 
* */